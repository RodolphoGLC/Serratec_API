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

import com.pratica.tarefa.entities.Descricao;
import com.pratica.tarefa.services.DescricaoService;

@RestController 
@RequestMapping("/descricoes")
public class DescricaoController {
	
	@Autowired
	DescricaoService descricaoService;
	
	@GetMapping
	public ResponseEntity<List<Descricao>> getAllDescricaos() {
		return new ResponseEntity<>(descricaoService.getAllDescricaoes(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Descricao> getDescricaoById(@PathVariable Integer id) {
		Descricao descricaoResponse = descricaoService.getDescricaoById(id);
		if (null == descricaoResponse)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(descricaoResponse, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Descricao> saveDescricao(@RequestBody Descricao descricao) {
		return new ResponseEntity<>(descricaoService.saveDescricao(descricao), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Descricao> updateDescricao(@RequestBody Descricao descricao,@PathVariable Integer id) {
		Descricao verificar = descricaoService.getDescricaoById(id);
		if(verificar == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<>(descricaoService.updateDescricao(descricao, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delDescricao(@PathVariable Integer id) {
		if (descricaoService.getDescricaoById(id) != null) {
			Boolean resp = descricaoService.deleteDescricao(id);
			if (resp)
				return new ResponseEntity<>(resp, HttpStatus.OK);
			else
				return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
		}
		else 
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);	
	}
}
