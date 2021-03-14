package com.microservicos.cloud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.microservicos.cloud.dto.ProdutoDTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Produto")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Produto {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY )
	private Long id;
	
	@Column (name="Nome", nullable= false, length=255)
	private String nome;
	
	@Column (name="Estoque", length=10)
	private Integer estoque;
	
	
	@Column (name="Preço", nullable= false, length=10)
	private String preco;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public static Produto create (ProdutoDTO produtoDto) {
		
		return new ModelMapper().map(produtoDto, Produto.class);
		 
	}

}
