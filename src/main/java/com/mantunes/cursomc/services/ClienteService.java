package com.mantunes.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mantunes.cursomc.domain.Cliente;
import com.mantunes.cursomc.repositories.ClienteRepository;
import com.mantunes.cursomc.services.exception.ObjectNotfoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	
	public	Cliente buscar (Integer id) {
		Cliente obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotfoundException("Objeto não encontrado! " + id 
					+ ", tipo : " + Cliente.class.getName());
		}
		return obj;
	}

}
