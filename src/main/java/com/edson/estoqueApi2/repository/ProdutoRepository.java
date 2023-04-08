package com.edson.estoqueApi2.repository;

import com.edson.estoqueApi2.model.Produto;
import com.edson.estoqueApi2.model.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
