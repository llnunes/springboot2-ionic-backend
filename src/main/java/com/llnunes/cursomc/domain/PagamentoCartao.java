package com.llnunes.cursomc.domain;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.llnunes.cursomc.domain.enums.EstadoPagamento;

import lombok.Getter;
import lombok.Setter;

@Entity
@JsonTypeName("pagamentoCartao")
public class PagamentoCartao extends Pagamento {

	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private Integer numeroParcelas;
	
	public PagamentoCartao() {
	}

	public PagamentoCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroParcelas) {
		super(id, estado, pedido);
		this.numeroParcelas = numeroParcelas;
	}	
}
