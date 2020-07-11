package com.alugueaki.project.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.alugueaki.project.domain.enums.TipoLocador;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Locador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String rg;
	private Integer tipo;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataNascimento;
	@ElementCollection
	@CollectionTable(name="TELEFONE_LOCADOR")
	private Set<String> telefones = new HashSet<>();

	@JsonIgnore
	private String senha;

	@Column(unique = true)
	private String cpfOuCnpj;

	@Column(unique = true)
	private String email;

	@OneToMany(mappedBy = "locador", cascade = CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();

	@OneToMany(mappedBy = "locador", cascade = CascadeType.ALL)
	private List<Imovel> imoveis = new ArrayList<>();

	public Locador() {
	}

	public Locador(Integer id, String nome, String rg, TipoLocador tipo, Date dataNascimento, String senha,
			String cpfOuCnpj, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.rg = rg;
		this.tipo = (tipo == null) ? null : tipo.getCod();
		this.dataNascimento = dataNascimento;
		this.senha = senha;
		this.cpfOuCnpj = cpfOuCnpj;
		this.email = email;
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public TipoLocador getTipo() {
		return TipoLocador.toEnum(tipo);
	}

	public void setTipo(TipoLocador tipo) {
		this.tipo = tipo.getCod();
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Imovel> getImoveis() {
		return imoveis;
	}

	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}	

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
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
		Locador other = (Locador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
