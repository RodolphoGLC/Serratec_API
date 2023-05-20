package com.residencia.gerenciamentoVendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.gerenciamentoVendas.entities.ItemPedido;
import com.residencia.gerenciamentoVendas.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	
	public List<ItemPedido> getAllItemPedidos() {
		return itemPedidoRepository.findAll();
	}
	
	public ItemPedido getItemPedidoById(Integer id) {
		return itemPedidoRepository.findById(id).orElse(null);
	}
	
	public ItemPedido saveItemPedido(ItemPedido itemPedido) {
		return itemPedidoRepository.save(itemPedido);
	}
	
	public ItemPedido updateItemPedido(ItemPedido itemPedido, Integer id)  {
		ItemPedido itemPedidoAtualizado = itemPedidoRepository.findById(id).orElse(null);
		if (itemPedidoAtualizado != null) {
			return itemPedidoRepository.save(itemPedido);
		} else {
			return null;
		}
	}
	
	public boolean deleteItemPedido(Integer id) {
		itemPedidoRepository.deleteById(id);
		ItemPedido itemPedidoDeletado = itemPedidoRepository.findById(id).orElse(null);
		if (null == itemPedidoDeletado) {
			return true;
		} else {
			return false;
		}
	}
}
