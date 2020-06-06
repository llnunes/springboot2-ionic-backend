package com.llnunes.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.llnunes.cursomc.domain.enums.EstadoPagamento;

import lombok.Getter;
import lombok.Setter;

@Entity
public class PagamentoBoleto extends Pagamento {

	private static final long serialVersionUID = 1L;

	@Getter @Setter
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataVencimento;
	
	@Getter @Setter
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataPagamento;
	
	public PagamentoBoleto() {
	}

	public PagamentoBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}
	
	
}
