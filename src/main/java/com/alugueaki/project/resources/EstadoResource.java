package com.alugueaki.project.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alugueaki.project.domain.Estado;

@RestController
@RequestMapping(value="/estados")
public class EstadoResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Estado> listar() {
		
		Estado uf = new Estado(1, "Pernambuco");
		Estado uf1 = new Estado(1, "Bahia");
		
		List<Estado> list = new ArrayList<>();
		list.add(uf);
		list.add(uf1);
		
		return list;
	}

}
