package com.llnunes.cursomc.domain.enums;

import lombok.Getter;

public enum Perfil {
	
	ADMIN (1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLIENTE");
	
	@Getter
	private int cod;
	
	@Getter
	private String descricao;
	
	private Perfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public static Perfil toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (Perfil tc: Perfil.values()) {
			if(cod.equals(tc.getCod())) {
				return tc;
			}
		}
		
		throw new IllegalArgumentException("Id invalido" + cod);
	}
	
}
