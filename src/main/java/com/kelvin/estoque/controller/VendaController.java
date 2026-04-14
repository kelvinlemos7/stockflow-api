package com.kelvin.estoque.controller;

import com.kelvin.estoque.model.Venda;
import com.kelvin.estoque.service.EstoqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final EstoqueService estoqueService;

    public VendaController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @PostMapping
    public ResponseEntity<Venda> registrar(@RequestBody VendaRequest request) {
        Venda venda = estoqueService.registrarVenda(request.codigoProduto(), request.quantidade());
        return ResponseEntity.ok(venda);
    }

    @GetMapping
    public ResponseEntity<List<Venda>> listar() {
        return ResponseEntity.ok(estoqueService.listarVendas());
    }

    public record VendaRequest(String codigoProduto, int quantidade) {}
}