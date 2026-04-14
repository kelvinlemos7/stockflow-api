package com.kelvin.estoque.repository;

import com.kelvin.estoque.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    List<Venda> findByProdutoId(Long produtoId);
}
