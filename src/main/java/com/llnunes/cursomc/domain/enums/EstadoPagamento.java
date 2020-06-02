package com.llnunes.cursomc.domain.enums;

import lombok.Getter;

public enum EstadoPagamento {
	
	PENDENTE (1, "Pedente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	@Getter
	private int cod;
	
	@Getter
	private String descricao;
	
	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public static EstadoPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (EstadoPagamento tc: EstadoPagamento.values()) {
			if(cod.equals(tc.getCod())) {
				return tc;
			}
		}
		
		throw new IllegalArgumentException("Id invalido" + cod);
	}
}
