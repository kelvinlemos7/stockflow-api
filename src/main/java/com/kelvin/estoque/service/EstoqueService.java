package com.kelvin.estoque.service;

import com.kelvin.estoque.model.Produto;
import com.kelvin.estoque.model.Venda;
import com.kelvin.estoque.repository.ProdutoRepository;
import com.kelvin.estoque.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EstoqueService {

    private final ProdutoRepository produtoRepository;
    private final VendaRepository vendaRepository;
    private final EmailService emailService;

    @Value("${estoque.alerta.minimo}")
    private int estoqueMinimo;

    public EstoqueService(ProdutoRepository produtoRepository,
                          VendaRepository vendaRepository,
                          EmailService emailService) {
        this.produtoRepository = produtoRepository;
        this.vendaRepository = vendaRepository;
        this.emailService = emailService;
    }

    public Produto cadastrarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorCodigo(String codigo) {
        return produtoRepository.findByCodigo(codigo)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + codigo));
    }

    public Venda registrarVenda(String codigoProduto, int quantidade) {
        Produto produto = buscarPorCodigo(codigoProduto);

        if (produto.getQuantidade() < quantidade) {
            throw new RuntimeException("Estoque insuficiente. Disponível: " + produto.getQuantidade());
        }

        produto.setQuantidade(produto.getQuantidade() - quantidade);
        produtoRepository.save(produto);

        Venda venda = new Venda();
        venda.setProduto(produto);
        venda.setQuantidadeVendida(quantidade);
        venda.setDataVenda(LocalDateTime.now());
        venda.setValorTotal(produto.getPreco() * quantidade);
        vendaRepository.save(venda);

        if (produto.getQuantidade() <= estoqueMinimo) {
            emailService.enviarAlertaEstoqueBaixo(produto.getNome(), produto.getQuantidade());
        }

        return venda;
    }

    public List<Venda> listarVendas() {
        return vendaRepository.findAll();
    }

        public List<Produto> listarEstoqueBaixo() {
            return produtoRepository.findByQuantidadeLessThanEqual(estoqueMinimo);
        }
}