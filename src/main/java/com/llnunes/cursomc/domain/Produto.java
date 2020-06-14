package com.llnunes.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter	@Setter
	private Integer id;

	@Getter	@Setter
	private String nome;

	@Getter	@Setter
	private Double preco;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIA", 
		joinColumns = @JoinColumn(name = "produto_id"), 
		inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	@Getter @Setter
	private List<Categoria> categorias = new ArrayList<>();
	
	@Getter @Setter
	@OneToMany(mappedBy = "id.produto")
	@JsonIgnore
	private Set<ItemPedido> itens = new HashSet<>();

	public Produto(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public Produto() {
		super();
	}
	
	@JsonIgnore
	public List<Pedido> getPedidos(){
		List<Pedido> lista = new ArrayList<>();
		for(ItemPedido ip: itens) {
			lista.add(ip.getPedido());
		}
		return lista;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
