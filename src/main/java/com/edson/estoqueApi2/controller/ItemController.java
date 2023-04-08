package com.edson.estoqueApi2.controller;


import com.edson.estoqueApi2.exception.ResourceNotFoundException;
import com.edson.estoqueApi2.model.Item;
import com.edson.estoqueApi2.model.Produto;
import com.edson.estoqueApi2.repository.ItemRepository;
import com.edson.estoqueApi2.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itens")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProdutoRepository produtoRepository;



    @GetMapping
    public List<Item> listar() {
        return itemRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> buscarPorId(@PathVariable Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Item> criar(@RequestBody Item itemDTO) {
        Optional<Produto> produto = produtoRepository.findById(itemDTO.getProduto().getId());
        if (produto.isEmpty()) {
            throw new ResourceNotFoundException("Produto não encontrado");
        }

        Item item = new Item(produto.get(), itemDTO.getQuantidade());
        itemRepository.save(item);

        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> atualizar(@PathVariable Long id, @RequestBody Item itemDTO) {
        Optional<Item> itemExistente = itemRepository.findById(id);
        if (itemExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Optional<Produto> produto = produtoRepository.findById(itemDTO.getProduto().getId());
        if (produto.isEmpty()) {
            throw new ResourceNotFoundException("Produto não encontrado");
        }

        Item itemAtualizado = new Item(produto.get(), itemDTO.getQuantidade());
        itemAtualizado.setId(id);
        itemRepository.save(itemAtualizado);

        return ResponseEntity.ok(itemAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        itemRepository.delete(item.get());

        return ResponseEntity.noContent().build();
    }
}
