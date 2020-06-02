package com.llnunes.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.llnunes.cursomc.domain.enums.EstadoPagamento;

import lombok.Getter;
import lombok.Setter;

@Entity
public class PagamentoBoleto extends Pagamento {

	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private Date dataVencimento;
	
	@Getter @Setter
	private Date dataPagamento;
	
	public PagamentoBoleto() {
	}

	public PagamentoBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}
	
	
}
