package com.pratica.tarefa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratica.tarefa.entities.Tarefa;
import com.pratica.tarefa.repositories.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	TarefaRepository tarefaRepository;
	
	public List<Tarefa> getAllTarefaes() {
		return tarefaRepository.findAll();
	}
	
	public Tarefa getTarefaById(Integer id) {
		return tarefaRepository.findById(id).orElse(null);
	}
	
	public Tarefa saveTarefa(Tarefa tarefa) {
		return tarefaRepository.save(tarefa);
	}
	
	public Tarefa updateTarefa(Tarefa tarefa, Integer id) {
		return tarefaRepository.save(tarefa);
	}
	
	public boolean deleteTarefa(Integer id) {
		tarefaRepository.deleteById(id);
		Tarefa tarefaDeletado = tarefaRepository.findById(id).orElse(null);
		if (null == tarefaDeletado) {
			return true;
		} else {
			return false;
		}
	}
}
