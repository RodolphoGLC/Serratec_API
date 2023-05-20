package com.residencia.gerenciamentoVendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.gerenciamentoVendas.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
