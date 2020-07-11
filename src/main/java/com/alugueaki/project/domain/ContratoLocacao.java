package com.alugueaki.project.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ContratoLocacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; 
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date instanteLocacao;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date instanteDevolucao;

}
