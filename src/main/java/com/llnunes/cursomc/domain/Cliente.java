package com.llnunes.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.llnunes.cursomc.domain.enums.Perfil;
import com.llnunes.cursomc.domain.enums.TipoCliente;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private Integer id;
	
	@Getter @Setter
	private String nome;
	
	@Getter @Setter	
	@Column(unique=true)
	private String email;
	
	@Getter @Setter	
	private String cpfCnpj;
	
	private Integer tipo;
	
	@JsonIgnore
	@Getter @Setter	
	private String senha;

	@Getter @Setter	
	@OneToMany(mappedBy = "cliente", cascade=CascadeType.ALL)	
	private List<Endereco> enderecos = new ArrayList<>();
	
	@Getter @Setter
	@ElementCollection
	@CollectionTable(name= "TELEFONE")
	@Column(name = "TELEFONE")
	private Set<String> telefones = new HashSet<>();
		
	@JsonIgnore
	@Getter @Setter
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos = new ArrayList<>();
		
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name= "PERFIS")
	private Set<Integer> perfis = new HashSet<>();
	
	@Getter @Setter
	private String imageUrl;
	
	public Cliente() {
		addPerfil(Perfil.CLIENTE);
	}	
	
	public Cliente(Integer id, String nome, String email, String cpfCnpj, TipoCliente tipo, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
		this.tipo = (tipo != null) ? tipo.getCod() : null;
		this.senha = senha;
		addPerfil(Perfil.CLIENTE);
	}	

	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo);
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod();
	}
	
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
