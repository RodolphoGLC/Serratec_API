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

import com.residencia.gerenciamentoVendas.entities.Pedido;
import com.residencia.gerenciamentoVendas.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> getAllPedidos() {
		List<Pedido> pedidoResponse = pedidoService.getAllPedidos();
		if(pedidoResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(pedidoResponse, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> getPedidoById(@PathVariable Integer id) {
		Pedido pedidoResponse = pedidoService.getPedidoById(id);
		if(pedidoResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(pedidoResponse, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Pedido> savePedido(@RequestBody Pedido pedido) {
		Pedido pedidoResponse = pedidoService.savePedido(pedido);
		return new ResponseEntity<>(pedidoResponse, HttpStatus.CREATED);
	}
	
	// @PutMapping
	@PutMapping("/{id}") //Lembrete para quando voltar
	public ResponseEntity<Pedido> updatePedido(@RequestBody Pedido pedido, @PathVariable Integer id) {
		//Pedido pedidoGet = pedidoService.getPedidoById(id);
		Pedido pedidoResponse = pedidoService.updatePedido(pedido, id);
		//if(pedidoGet == null) 
			//return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED); 
		//else
			return new ResponseEntity<>(pedidoResponse, HttpStatus.OK); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deletePedido(@PathVariable Integer id) {
		Boolean pedidoResponse = pedidoService.deletePedido(id);
		if(pedidoResponse)
			return new ResponseEntity<>(pedidoResponse, HttpStatus.OK);
		else
			return new ResponseEntity<>(pedidoResponse, HttpStatus.NOT_MODIFIED);
	}
}
