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

import com.residencia.gerenciamentoVendas.entities.ItemPedido;
import com.residencia.gerenciamentoVendas.services.ItemPedidoService;

@RestController
@RequestMapping("/itemPedidos")
public class ItemPedidoController {
	
	@Autowired
	ItemPedidoService itemPedidoService;
	
	@GetMapping
	public ResponseEntity<List<ItemPedido>> getAllItemPedidos() {
		List<ItemPedido> itemPedidoResponse = itemPedidoService.getAllItemPedidos();
		if(itemPedidoResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(itemPedidoResponse, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemPedido> getItemPedidoById(@PathVariable Integer id) {
		ItemPedido itemPedidoResponse = itemPedidoService.getItemPedidoById(id);
		if(itemPedidoResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(itemPedidoResponse, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ItemPedido> saveItemPedido(@RequestBody ItemPedido itemPedido) {
		ItemPedido itemPedidoResponse = itemPedidoService.saveItemPedido(itemPedido);
		return new ResponseEntity<>(itemPedidoResponse, HttpStatus.CREATED);
	}
	
	// @PutMapping
	@PutMapping("/{id}") //Lembrete para quando voltar
	public ResponseEntity<ItemPedido> updateItemPedido(@RequestBody ItemPedido itemPedido, @PathVariable Integer id) {
		//ItemPedido itemPedidoGet = itemPedidoService.getItemPedidoById(id);
		ItemPedido itemPedidoResponse = itemPedidoService.updateItemPedido(itemPedido, id);
		//if(itemPedidoGet == null) 
			//return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED); 
		//else
			return new ResponseEntity<>(itemPedidoResponse, HttpStatus.OK); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteItemPedido(@PathVariable Integer id) {
		Boolean itemPedidoResponse = itemPedidoService.deleteItemPedido(id);
		if(itemPedidoResponse)
			return new ResponseEntity<>(itemPedidoResponse, HttpStatus.OK);
		else
			return new ResponseEntity<>(itemPedidoResponse, HttpStatus.NOT_MODIFIED);
	}
}
