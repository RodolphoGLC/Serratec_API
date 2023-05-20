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

import com.residencia.gerenciamentoVendas.entities.Categoria;
import com.residencia.gerenciamentoVendas.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAllCategorias() {
		List<Categoria> categoriaResponse = categoriaService.getAllCategorias();
		if(categoriaResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(categoriaResponse, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getCategoriaById(@PathVariable Integer id) {
		Categoria categoriaResponse = categoriaService.getCategoriaById(id);
		if(categoriaResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(categoriaResponse, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> saveCategoria(@RequestBody Categoria categoria) {
		Categoria categoriaResponse = categoriaService.saveCategoria(categoria);
		return new ResponseEntity<>(categoriaResponse, HttpStatus.CREATED);
	}
	
	// @PutMapping
	@PutMapping("/{id}") //Lembrete para quando voltar
	public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria, @PathVariable Integer id) {
		//Categoria categoriaGet = categoriaService.getCategoriaById(id);
		Categoria categoriaResponse = categoriaService.updateCategoria(categoria, id);
		//if(categoriaGet == null) 
			//return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED); 
		//else
			return new ResponseEntity<>(categoriaResponse, HttpStatus.OK); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteCategoria(@PathVariable Integer id) {
		Boolean categoriaResponse = categoriaService.deleteCategoria(id);
		if(categoriaResponse)
			return new ResponseEntity<>(categoriaResponse, HttpStatus.OK);
		else
			return new ResponseEntity<>(categoriaResponse, HttpStatus.NOT_MODIFIED);
	}
}
