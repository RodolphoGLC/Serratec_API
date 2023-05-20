package com.residencia.gerenciamentoVendas.controllers;

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

import com.residencia.gerenciamentoVendas.entities.Endereco;
import com.residencia.gerenciamentoVendas.services.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	
	@Autowired
	EnderecoService enderecoService;
	
	@GetMapping
	public ResponseEntity<List<Endereco>> getAllEnderecos() {
		List<Endereco> enderecoResponse = enderecoService.getAllEnderecos();
		if(enderecoResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(enderecoResponse, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> getEnderecoById(@PathVariable Integer id) {
		Endereco enderecoResponse = enderecoService.getEnderecoById(id);
		if(enderecoResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(enderecoResponse, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Endereco> saveEndereco(@RequestBody Endereco endereco) {
		Endereco enderecoResponse = enderecoService.saveEndereco(endereco);
		return new ResponseEntity<>(enderecoResponse, HttpStatus.CREATED);
	}
	
	// @PutMapping
	@PutMapping("/{id}") //Lembrete para quando voltar
	public ResponseEntity<Endereco> updateEndereco(@RequestBody Endereco endereco, @PathVariable Integer id) {
		//Endereco enderecoGet = enderecoService.getEnderecoById(id);
		Endereco enderecoResponse = enderecoService.updateEndereco(endereco, id);
		//if(enderecoGet == null) 
			//return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED); 
		//else
			return new ResponseEntity<>(enderecoResponse, HttpStatus.OK); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteEndereco(@PathVariable Integer id) {
		Boolean enderecoResponse = enderecoService.deleteEndereco(id);
		if(enderecoResponse)
			return new ResponseEntity<>(enderecoResponse, HttpStatus.OK);
		else
			return new ResponseEntity<>(enderecoResponse, HttpStatus.NOT_MODIFIED);
	}
}