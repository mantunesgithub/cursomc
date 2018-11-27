package com.mantunes.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mantunes.cursomc.domain.Categoria;
import com.mantunes.cursomc.repositories.CategoriaRepository;
import com.mantunes.cursomc.services.exception.ObjectNotfoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
	
	public	Categoria buscar (Integer id) {
		Categoria obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotfoundException("Objeto não encontrado! " + id 
					+ ", tipo : " + Categoria.class.getName());
		}
		return obj;
	}

}
