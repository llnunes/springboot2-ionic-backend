package com.llnunes.cursomc.dto;

import java.io.Serializable;

import com.llnunes.cursomc.domain.Estado;

import lombok.Getter;
import lombok.Setter;

public class EstadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private Integer id;
	
	@Getter @Setter
	private String nome;
	
	public EstadoDTO() {
	}
	
	public EstadoDTO(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public EstadoDTO(Estado obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
	}
}
