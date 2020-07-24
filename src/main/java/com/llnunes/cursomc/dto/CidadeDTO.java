package com.llnunes.cursomc.dto;

import java.io.Serializable;

import com.llnunes.cursomc.domain.Cidade;

import lombok.Getter;
import lombok.Setter;

public class CidadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private Integer id;
	
	@Getter @Setter
	private String nome;
	
	public CidadeDTO() {
	}

	public CidadeDTO(Cidade obj) {
		id = obj.getId();
		nome = obj.getNome();
	}
	

}
