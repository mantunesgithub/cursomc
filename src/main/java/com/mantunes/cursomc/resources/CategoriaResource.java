package com.mantunes.cursomc.resources;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mantunes.cursomc.domain.Categoria;
import com.mantunes.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id )	{
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri(); 
		return ResponseEntity.created(uri).build();		
				
/*	após inserir o metodo no banco de dados, o bd vai atribuir um novo Id
	para esse obj. Vamos pegar o Id e fornecer como argumento da nova URI (postman)
	localhost:8080/Categoria/3. escreva a linha acima da URI
	
	fromCurrentRequest() => pega a URI do postnman localhost:8080/Categoria
	e agora vamos qacrescentar nela o id gerado no BD. com path("/{id}").buildAndExpand(obj.getId()
	e para finalizar converte ele para URI com toUri()
	
	==>ResponseEntity.created(uri).build() o created gera o codigo 201 e recebe a uri como argumento
	==>.build() para gerar a resposta 
	
	==>Agora falta colocar as anotações que vão ser mapeadas no metodo post
	==> Para que esse Objeto (Categoria obj) seja construido a partir dos dados Json que eu enviar 
	tem que inserir a anotação  => @RequestBody para converter o Jason para obj Java automaticamente
	
 
*/ 	
	}
}
