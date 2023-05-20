package com.residencia.gerenciamentoVendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.gerenciamentoVendas.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
