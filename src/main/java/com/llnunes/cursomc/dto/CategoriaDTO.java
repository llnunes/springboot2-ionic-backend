package com.llnunes.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.llnunes.cursomc.domain.Categoria;

import lombok.Getter;
import lombok.Setter;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter	@Setter
	private Integer id;

	@Getter	@Setter
	@NotEmpty(message = "Preenchimento Obrigatório")
	@Length(min=5, max=80, message = "O tamanho deve ser entre 5 e 80 caracteres.")
	private String nome;

	public CategoriaDTO() {
	}

	public CategoriaDTO(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public CategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}
}
