package com.residencia.gerenciamentoVendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.gerenciamentoVendas.entities.Pedido;
import com.residencia.gerenciamentoVendas.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	public List<Pedido> getAllPedidos() {
		return pedidoRepository.findAll();
	}
	
	public Pedido getPedidoById(Integer id) {
		return pedidoRepository.findById(id).orElse(null);
	}
	
	public Pedido savePedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public Pedido updatePedido(Pedido pedido, Integer id)  {
		Pedido pedidoAtualizado = pedidoRepository.findById(id).orElse(null);
		if (pedidoAtualizado != null) {
			return pedidoRepository.save(pedido);
		} else {
			return null;
		}
	}
	
	public boolean deletePedido(Integer id) {
		pedidoRepository.deleteById(id);
		Pedido pedidoDeletado = pedidoRepository.findById(id).orElse(null);
		if (null == pedidoDeletado) {
			return true;
		} else {
			return false;
		}
	}
}
