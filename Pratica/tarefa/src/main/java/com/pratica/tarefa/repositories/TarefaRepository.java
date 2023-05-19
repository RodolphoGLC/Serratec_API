package com.pratica.tarefa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratica.tarefa.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

}
