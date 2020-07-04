package com.alugueaki.project.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/estados")
public class EstadoResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		
		
		return "Requisição Estado funcionando com sucesso!";
	}

}
