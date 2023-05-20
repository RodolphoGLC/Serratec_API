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

import com.residencia.gerenciamentoVendas.entities.Produto;
import com.residencia.gerenciamentoVendas.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAllProdutos() {
		List<Produto> produtoResponse = produtoService.getAllProdutos();
		if(produtoResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(produtoResponse, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getProdutoById(@PathVariable Integer id) {
		Produto produtoResponse = produtoService.getProdutoById(id);
		if(produtoResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(produtoResponse, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Produto> saveProduto(@RequestBody Produto produto) {
		Produto produtoResponse = produtoService.saveProduto(produto);
		return new ResponseEntity<>(produtoResponse, HttpStatus.CREATED);
	}
	
	// @PutMapping
	@PutMapping("/{id}") //Lembrete para quando voltar
	public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto, @PathVariable Integer id) {
		//Produto produtoGet = produtoService.getProdutoById(id);
		Produto produtoResponse = produtoService.updateProduto(produto, id);
		//if(produtoGet == null) 
			//return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED); 
		//else
			return new ResponseEntity<>(produtoResponse, HttpStatus.OK); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteProduto(@PathVariable Integer id) {
		Boolean produtoResponse = produtoService.deleteProduto(id);
		if(produtoResponse)
			return new ResponseEntity<>(produtoResponse, HttpStatus.OK);
		else
			return new ResponseEntity<>(produtoResponse, HttpStatus.NOT_MODIFIED);
	}
}