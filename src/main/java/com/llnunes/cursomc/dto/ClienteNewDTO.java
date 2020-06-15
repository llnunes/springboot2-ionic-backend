package com.llnunes.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.llnunes.cursomc.services.validation.ClienteInsert;

import lombok.Getter;
import lombok.Setter;

@ClienteInsert
public class ClienteNewDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	@Getter @Setter
	private String nome;

	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	@Getter @Setter
	private String email;

	@NotEmpty(message="Preenchimento obrigatório")
	@Getter @Setter
	private String cpfOuCnpj;

	@Getter @Setter
	private Integer tipo;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Getter @Setter
	private String senha;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Getter @Setter
	private String logradouro;

	@NotEmpty(message="Preenchimento obrigatório")
	@Getter @Setter
	private String numero;

	@Getter @Setter
	private String complemento;

	@Getter @Setter
	private String bairro;

	@NotEmpty(message="Preenchimento obrigatório")
	@Getter @Setter
	private String cep;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Getter @Setter
	private String telefone1;

	@Getter @Setter
	private String telefone2;
	
	@Getter @Setter
	private String telefone3;

	@Getter @Setter
	private Integer cidadeId;
	
	public ClienteNewDTO() {
	}

}
