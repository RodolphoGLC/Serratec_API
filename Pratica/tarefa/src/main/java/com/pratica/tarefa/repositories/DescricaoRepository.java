package com.pratica.tarefa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratica.tarefa.entities.Descricao;

public interface DescricaoRepository extends JpaRepository<Descricao, Integer> {

}
