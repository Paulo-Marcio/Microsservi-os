package com.microservicos.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservicos.cloud.model.Produto;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
