package com.alugueaki.project;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alugueaki.project.domain.Cidade;
import com.alugueaki.project.domain.Endereco;
import com.alugueaki.project.domain.Estado;
import com.alugueaki.project.domain.Locador;
import com.alugueaki.project.domain.enums.TipoLocador;
import com.alugueaki.project.repositories.CidadeRepository;
import com.alugueaki.project.repositories.EnderecoRepository;
import com.alugueaki.project.repositories.EstadoRepository;
import com.alugueaki.project.repositories.LocadorRepository;

@SpringBootApplication
public class AlugueakiApplication implements CommandLineRunner {

	@Autowired
	private EstadoRepository estadoRepo;

	@Autowired
	private CidadeRepository cidadeRepo;
	
	@Autowired
	private EnderecoRepository enderecoRepo;
	
	@Autowired
	private LocadorRepository locadorRepo;
	
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		SpringApplication.run(AlugueakiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Estado uf = new Estado(null, "Pernambuco");
		Estado uf1 = new Estado(null, "Bahia");
		Estado uf2 = new Estado(null, "São Paulo");
		Estado uf3 = new Estado(null, "Paraná");

		Cidade cid = new Cidade(null, "Jaboatão dos Guararapes", uf);
		Cidade cid1 = new Cidade(null, "Piripá", uf1);
		Cidade cid2 = new Cidade(null, "São Paulo", uf2);
		Cidade cid3 = new Cidade(null, "Cianorte", uf3);
		Cidade cid4 = new Cidade(null, "Vitoria da Conquista", uf1);
		Cidade cid5 = new Cidade(null, "Maringá", uf3);

		uf.getCidades().addAll(Arrays.asList(cid));
		uf1.getCidades().addAll(Arrays.asList(cid1, cid4));
		uf2.getCidades().addAll(Arrays.asList(cid2));
		uf3.getCidades().addAll(Arrays.asList(cid3, cid5));

		estadoRepo.saveAll(Arrays.asList(uf, uf1, uf2, uf3));
		cidadeRepo.saveAll(Arrays.asList(cid, cid1, cid2, cid3, cid4, cid5));
		
		Locador loc = new Locador(null, "Alex Barbosa", "051.113.335-92", TipoLocador.PESSOAFISICA, formato.parse("26/11/1990"),"" ,"051.113.335-92", "abarbosasilva7@gmail.com");
		
		Endereco ed = new Endereco(null, "Rua rossini rosvelt de albuquerque", "3", "Bloco A", "Piedade", "54410-310", cid, loc);
		Endereco ed2 = new Endereco(null, "Terceira travessa luis viana filho", "42", "Bloco A", "Centro", "54410-310", cid1, loc);
		
		locadorRepo.saveAll(Arrays.asList(loc));
		enderecoRepo.saveAll(Arrays.asList(ed, ed2));

	}

}
