package com.ronanzenatti.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronanzenatti.cursomc.domain.Categoria;
import com.ronanzenatti.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public List<Categoria> findAll() {
		List<Categoria> list = repo.findAll();
		return list;
	}

}
