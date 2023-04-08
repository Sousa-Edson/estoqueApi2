package com.edson.estoqueApi2.repository;

import com.edson.estoqueApi2.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
