package com.kelvin.estoque.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String codigo; // ex: "PROD-001" — é esse código que o caixa manda pra API

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private Double preco;
}