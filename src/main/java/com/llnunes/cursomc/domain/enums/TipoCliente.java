package com.llnunes.cursomc.domain.enums;

import lombok.Getter;

public enum TipoCliente {
	
	PESSOA_FISICA (1, "Pessoa Física"),
	PESSOA_JURIDICA (2, "Pessoa Jurídica");
	
	@Getter
	private int cod;
	
	@Getter
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (TipoCliente tc: TipoCliente.values()) {
			if(cod.equals(tc.getCod())) {
				return tc;
			}
		}
		
		throw new IllegalArgumentException("Id invalido" + cod);
	}
	
}
