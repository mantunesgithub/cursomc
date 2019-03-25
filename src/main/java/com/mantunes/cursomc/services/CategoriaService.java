package com.mantunes.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mantunes.cursomc.domain.Categoria;
import com.mantunes.cursomc.repositories.CategoriaRepository;
import com.mantunes.cursomc.services.exception.DataIntegrityException;
import com.mantunes.cursomc.services.exception.ObjectNotfoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
	
	public	Categoria find(Integer id) {
		Categoria obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotfoundException("Objeto não encontrado! " + id 
					+ ", tipo : " + Categoria.class.getName());
		}
		return obj;
	}
	public Categoria insert (Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
//
//
//	
	public Categoria update (Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
//
//	DELETE VIA POSTMAN
//	
	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
		}
	}
}