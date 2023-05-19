package com.pratica.tarefa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratica.tarefa.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
