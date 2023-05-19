package com.pratica.tarefa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratica.tarefa.entities.Pessoa;
import com.pratica.tarefa.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	public List<Pessoa> getAllPessoaes() {
		return pessoaRepository.findAll();
	}
	
	public Pessoa getPessoaById(Integer id) {
		return pessoaRepository.findById(id).orElse(null);
	}
	
	public Pessoa savePessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public Pessoa updatePessoa(Pessoa pessoa, Integer id) {
		return pessoaRepository.save(pessoa);
	}
	
	public boolean deletePessoa(Integer id) {
		pessoaRepository.deleteById(id);
		Pessoa pessoaDeletado = pessoaRepository.findById(id).orElse(null);
		if (null == pessoaDeletado) {
			return true;
		} else {
			return false;
		}
	}
}
