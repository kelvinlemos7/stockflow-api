package com.kelvin.estoque.controller;

import com.kelvin.estoque.model.Produto;
import com.kelvin.estoque.service.EstoqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final EstoqueService estoqueService;

    public ProdutoController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
        return ResponseEntity.ok(estoqueService.cadastrarProduto(produto));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        return ResponseEntity.ok(estoqueService.listarProdutos());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Produto> buscar(@PathVariable String codigo) {
        return ResponseEntity.ok(estoqueService.buscarPorCodigo(codigo));
    }

    @GetMapping("/estoque-baixo")
    public ResponseEntity<List<Produto>> estoqueBaixo() {
        return ResponseEntity.ok(estoqueService.listarEstoqueBaixo());
    }
}