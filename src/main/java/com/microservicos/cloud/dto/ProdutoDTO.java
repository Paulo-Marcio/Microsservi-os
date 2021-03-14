package com.microservicos.cloud.dto;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.microservicos.cloud.model.Produto;

import lombok.EqualsAndHashCode;


@JsonPropertyOrder({"id", "nome", "estoque", "preco"})

@EqualsAndHashCode (callSuper = false)
public class ProdutoDTO extends RepresentationModel<ProdutoDTO>implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ProdutoDTO () {
		
	}
	
	
	public ProdutoDTO(Long id, String nome, Integer estoque, Double preco) {
		
		this.id = id;
		this.nome = nome;
		this.estoque = estoque;
		this.preco = preco;
	}

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("estoque")
	private Integer estoque;
	
	@JsonProperty("preco")
	private Double preco;
	
	public static ProdutoDTO create (Produto produto) {
		
		return new ModelMapper().map(produto, ProdutoDTO.class);
	}

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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
