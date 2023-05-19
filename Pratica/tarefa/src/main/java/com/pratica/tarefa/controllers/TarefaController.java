package com.pratica.tarefa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratica.tarefa.entities.Tarefa;
import com.pratica.tarefa.services.TarefaService;

@RestController 
@RequestMapping("/tarefas")
public class TarefaController {
	
	@Autowired
	TarefaService tarefaService;
	
	@GetMapping
	public ResponseEntity<List<Tarefa>> getAllTarefas() {
		return new ResponseEntity<>(tarefaService.getAllTarefaes(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> getTarefaById(@PathVariable Integer id) {
		Tarefa tarefaResponse = tarefaService.getTarefaById(id);
		if (null == tarefaResponse)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(tarefaResponse, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Tarefa> saveTarefa(@RequestBody Tarefa tarefa) {
		return new ResponseEntity<>(tarefaService.saveTarefa(tarefa), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Tarefa> updateTarefa(@RequestBody Tarefa tarefa,@PathVariable Integer id) {
		Tarefa verificar = tarefaService.getTarefaById(id);
		if(verificar == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<>(tarefaService.updateTarefa(tarefa, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delTarefa(@PathVariable Integer id) {
		if (tarefaService.getTarefaById(id) != null) {
			Boolean resp = tarefaService.deleteTarefa(id);
			if (resp)
				return new ResponseEntity<>(resp, HttpStatus.OK);
			else
				return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
		}
		else 
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);	
	}
}