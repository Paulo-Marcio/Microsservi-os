package com.microservicos.cloud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.microservicos.cloud.dto.ProdutoDTO;
import com.microservicos.cloud.exception.RessourceNotFoundException;
import com.microservicos.cloud.message.ProdutoSendMessage;
import com.microservicos.cloud.model.Produto;
import com.microservicos.cloud.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoSendMessage produtoSendMessage;
	
	public ProdutoDTO create (ProdutoDTO produtoDto) {
		
	   ProdutoDTO produtoDTO = ProdutoDTO.create(produtoRepository.save(Produto.create(produtoDto)));
	   produtoSendMessage.sendMessage(produtoDTO);
	   return produtoDTO;
	}	
	
	public Page<ProdutoDTO> findAll(Pageable pageable){
		
		var page= produtoRepository.findAll(pageable);
		return page.map(this::convertToProdutoDTO);
	}
	
	private ProdutoDTO convertToProdutoDTO( Produto produto) {
		return ProdutoDTO.create(produto);
	}
	
	public ProdutoDTO findById (Long id) {
		Produto produto = produtoRepository.findById(id).
		orElseThrow(() -> new RessourceNotFoundException("Produto não encontrado"));
		return ProdutoDTO.create(produto);
		
	}
	
	public ProdutoDTO update (ProdutoDTO produtoDTO) {
		final Optional<Produto> produto= produtoRepository.findById(produtoDTO.getId());
		if(!produto.isPresent()) {
			new RessourceNotFoundException("Produto não encontrado");
		}
		return ProdutoDTO.create(produtoRepository.save(Produto.create(produtoDTO)));
	}
	public void delete (Long id) {
		
		Produto produto = produtoRepository.findById(id).
		orElseThrow(() -> new RessourceNotFoundException("Produto não encontrado"));
		this.produtoRepository.delete(produto);
	}
}
