package com.residencia.gerenciamentoVendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.gerenciamentoVendas.entities.Categoria;
import com.residencia.gerenciamentoVendas.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public List<Categoria> getAllCategorias() {
		return categoriaRepository.findAll();
	}
	
	public Categoria getCategoriaById(Integer id) {
		return categoriaRepository.findById(id).orElse(null);
	}
	
	public Categoria saveCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public Categoria updateCategoria(Categoria categoria, Integer id)  {
		Categoria categoriaAtualizado = categoriaRepository.findById(id).orElse(null);
		if (categoriaAtualizado != null) {
			return categoriaRepository.save(categoria);
		} else {
			return null;
		}
	}
	
	public Boolean deleteCategoria(Integer id) {
		categoriaRepository.deleteById(id);
		Categoria categoriaDeletado = categoriaRepository.findById(id).orElse(null);
		if (null == categoriaDeletado) {
			return true;
		} else {
			return false;
		}
	}
}