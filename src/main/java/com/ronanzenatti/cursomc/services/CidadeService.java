package com.ronanzenatti.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronanzenatti.cursomc.domain.Cidade;
import com.ronanzenatti.cursomc.repositories.CidadeRepository;
import com.ronanzenatti.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;

	public Cidade findById(Integer id) {
		Optional<Cidade> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()));
	}

	public List<Cidade> findAll() {
		List<Cidade> list = repo.findAll();
		return list;
	}

}
