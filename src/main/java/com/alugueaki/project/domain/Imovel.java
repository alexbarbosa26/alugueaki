package com.alugueaki.project.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.alugueaki.project.domain.enums.TipoImovel;

@Entity
public class Imovel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer tipo;
	private Integer quartos;
	private Integer sala;
	private Integer cozinha;
	private Integer wc;

	@ManyToOne
	@JoinColumn(name = "locador_id")
	private Locador locador;
	
	@ManyToOne
	@JoinColumn(name="endereco_imovel_id")
	private EnderecoImovel enderecoImovel;

	public Imovel() {
	}

	public Imovel(Integer id, String nome, TipoImovel tipo, Integer quartos, Integer sala, Integer cozinha, Integer wc,
			Locador locador, EnderecoImovel enderecoImovel) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = (tipo == null) ? null : tipo.getCod();
		this.quartos = quartos;
		this.sala = sala;
		this.cozinha = cozinha;
		this.wc = wc;
		this.locador = locador;
		this.enderecoImovel = enderecoImovel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoImovel getTipo() {
		return TipoImovel.toEnum(tipo);
	}

	public void setTipo(TipoImovel tipo) {
		this.tipo = tipo.getCod();
	}

	public Integer getQuartos() {
		return quartos;
	}

	public void setQuartos(Integer quartos) {
		this.quartos = quartos;
	}

	public Integer getSala() {
		return sala;
	}

	public void setSala(Integer sala) {
		this.sala = sala;
	}

	public Integer getCozinha() {
		return cozinha;
	}

	public void setCozinha(Integer cozinha) {
		this.cozinha = cozinha;
	}

	public Integer getWc() {
		return wc;
	}

	public void setWc(Integer wc) {
		this.wc = wc;
	}

	public Locador getLocador() {
		return locador;
	}

	public void setLocador(Locador locador) {
		this.locador = locador;
	}	

	public EnderecoImovel getEnderecoImovel() {
		return enderecoImovel;
	}

	public void setEnderecoImovel(EnderecoImovel enderecoImovel) {
		this.enderecoImovel = enderecoImovel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imovel other = (Imovel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
