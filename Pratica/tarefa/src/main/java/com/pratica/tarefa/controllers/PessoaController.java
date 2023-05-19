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

import com.pratica.tarefa.entities.Pessoa;
import com.pratica.tarefa.services.PessoaService;

@RestController 
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> getAllPessoas() {
		return new ResponseEntity<>(pessoaService.getAllPessoaes(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> getPessoaById(@PathVariable Integer id) {
		Pessoa pessoaResponse = pessoaService.getPessoaById(id);
		if (null == pessoaResponse)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(pessoaResponse, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Pessoa> savePessoa(@RequestBody Pessoa pessoa) {
		return new ResponseEntity<>(pessoaService.savePessoa(pessoa), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> updatePessoa(@RequestBody Pessoa pessoa,@PathVariable Integer id) {
		Pessoa verificar = pessoaService.getPessoaById(id);
		if(verificar == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
		else 
			return new ResponseEntity<>(pessoaService.updatePessoa(pessoa, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delPessoa(@PathVariable Integer id) {
		if (pessoaService.getPessoaById(id) != null) {
			Boolean resp = pessoaService.deletePessoa(id);
			if (resp)
				return new ResponseEntity<>(resp, HttpStatus.OK);
			else
				return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
		}
		else 
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);	
	}
}
