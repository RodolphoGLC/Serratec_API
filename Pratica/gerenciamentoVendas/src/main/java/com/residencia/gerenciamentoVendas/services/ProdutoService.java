package com.residencia.gerenciamentoVendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.gerenciamentoVendas.entities.Produto;
import com.residencia.gerenciamentoVendas.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<Produto> getAllProdutos() {
		return produtoRepository.findAll();
	}
	
	public Produto getProdutoById(Integer id) {
		return produtoRepository.findById(id).orElse(null);
	}
	
	public Produto saveProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public Produto updateProduto(Produto produto, Integer id)  {
		Produto produtoAtualizado = produtoRepository.findById(id).orElse(null);
		if (produtoAtualizado != null) {
			return produtoRepository.save(produto);
		} else {
			return null;
		}
	}
	
	public boolean deleteProduto(Integer id) {
		produtoRepository.deleteById(id);
		Produto produtoDeletado = produtoRepository.findById(id).orElse(null);
		if (null == produtoDeletado) {
			return true;
		} else {
			return false;
		}
	}
}
