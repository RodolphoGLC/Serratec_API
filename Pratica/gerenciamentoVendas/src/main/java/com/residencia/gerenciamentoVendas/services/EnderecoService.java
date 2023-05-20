package com.residencia.gerenciamentoVendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.gerenciamentoVendas.entities.Endereco;
import com.residencia.gerenciamentoVendas.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	public List<Endereco> getAllEnderecos() {
		return enderecoRepository.findAll();
	}
	
	public Endereco getEnderecoById(Integer id) {
		return enderecoRepository.findById(id).orElse(null);
	}
	
	public Endereco saveEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public Endereco updateEndereco(Endereco endereco, Integer id)  {
		Endereco enderecoAtualizado = enderecoRepository.findById(id).orElse(null);
		if (enderecoAtualizado != null) {
			return enderecoRepository.save(endereco);
		} else {
			return null;
		}
	}
	
	public boolean deleteEndereco(Integer id) {
		enderecoRepository.deleteById(id);
		Endereco enderecoDeletado = enderecoRepository.findById(id).orElse(null);
		if (null == enderecoDeletado) {
			return true;
		} else {
			return false;
		}
	}
}

