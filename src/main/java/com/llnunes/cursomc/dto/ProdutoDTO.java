package com.llnunes.cursomc.dto;

import java.io.Serializable;

import com.llnunes.cursomc.domain.Produto;

import lombok.Getter;
import lombok.Setter;

public class ProdutoDTO  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter	@Setter
	private Integer id;

	@Getter	@Setter
	private String nome;

	@Getter	@Setter
	private Double preco;

	public ProdutoDTO() {
	}
	
	public ProdutoDTO(Produto obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.preco = obj.getPreco();
	}
}
