package com.ronanzenatti.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronanzenatti.cursomc.domain.Estado;
import com.ronanzenatti.cursomc.repositories.EstadoRepository;
import com.ronanzenatti.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repo;

	public Estado findById(Integer id) {
		Optional<Estado> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName()));
	}

	public List<Estado> findAll() {
		List<Estado> list = repo.findAll();
		return list;
	}

}
