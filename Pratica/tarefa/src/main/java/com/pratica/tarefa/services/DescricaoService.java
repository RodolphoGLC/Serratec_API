package com.pratica.tarefa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratica.tarefa.entities.Descricao;
import com.pratica.tarefa.repositories.DescricaoRepository;

@Service
public class DescricaoService {
	
	@Autowired
	DescricaoRepository descricaoRepository;
	
	public List<Descricao> getAllDescricaoes() {
		return descricaoRepository.findAll();
	}
	
	public Descricao getDescricaoById(Integer id) {
		return descricaoRepository.findById(id).orElse(null);
	}
	
	public Descricao saveDescricao(Descricao descricao) {
		return descricaoRepository.save(descricao);
	}
	
	public Descricao updateDescricao(Descricao descricao, Integer id) {
		return descricaoRepository.save(descricao);
	}
	
	public boolean deleteDescricao(Integer id) {
		descricaoRepository.deleteById(id);
		Descricao descricaoDeletado = descricaoRepository.findById(id).orElse(null);
		if (null == descricaoDeletado) {
			return true;
		} else {
			return false;
		}
	}
}
