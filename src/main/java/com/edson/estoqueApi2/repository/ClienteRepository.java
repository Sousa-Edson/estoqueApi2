package com.edson.estoqueApi2.repository;

import com.edson.estoqueApi2.model.Cliente;
 import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
