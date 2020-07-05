package com.alugueaki.project.domain.enums;

public enum TipoImovel {
	
	CASA(1, "Casa"),
	APARTAMENTO(2, "Apartamento"),
	SITIO(3, "Sitio"),
	CHACARA(4, "Chacará"),
	KITNET(5, "Kitnet");
	
	private int cod;
	private String descricao;
	
	private TipoImovel(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoImovel toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoImovel x : TipoImovel.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}


}
