package com.mantunes.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mantunes.cursomc.domain.Pedido;
import com.mantunes.cursomc.repositories.PedidoRepository;
import com.mantunes.cursomc.services.exception.ObjectNotfoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repo;
	
	public	Pedido buscar (Integer id) {
		Pedido obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotfoundException("Objeto não encontrado! " + id 
					+ ", tipo : " + Pedido.class.getName());
		}
		return obj;
	}

}
