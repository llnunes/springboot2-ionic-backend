package com.llnunes.cursomc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
public class ItemPedido implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	@Getter @Setter	
	private ItemPedidoPK id = new ItemPedidoPK();
	
	@Getter @Setter
	private Double desconto;
	
	@Getter @Setter
	private Integer quantidade;
	
	@Getter @Setter
	private Double preco;

	public ItemPedido() {
	}
	
	public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
		super();
		this.id.setPedido(pedido);
		this.id.setProduto(produto);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public Double getSubTotal () {
		return (preco - desconto) * quantidade;
	}
	
	@JsonIgnore
	public Pedido getPedido () {
		return this.id.getPedido();
	}
	
	public void setPedido (Pedido pedido) {
		this.id.setPedido(pedido);
	}
	
	public Produto getProduto () { 
		return this.id.getProduto();
	}
	
	public void setProduto (Produto produto) {
		this.id.setProduto(produto);
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
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
