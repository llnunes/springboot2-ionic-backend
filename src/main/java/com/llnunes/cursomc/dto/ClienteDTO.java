package com.llnunes.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.llnunes.cursomc.domain.Cliente;

import lombok.Getter;
import lombok.Setter;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter @Setter 
	private Integer id;
	
	@Getter @Setter
	@NotEmpty(message = "Preenchimento Obrigatório")
	@Length(min=5, max=120, message = "O tamanho deve ser entre 5 e 120 caracteres.")	
	private String nome;
	
	@Getter @Setter
	@NotEmpty(message = "Preenchimento Obrigatório")
	@Email(message = "Email Inválido")
	private String email;
	
	public ClienteDTO() {
	}
	
	public ClienteDTO(Cliente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getNome();
	}
}
