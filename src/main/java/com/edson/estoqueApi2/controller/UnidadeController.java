package com.edson.estoqueApi2.controller;


import com.edson.estoqueApi2.exception.ResourceNotFoundException;
import com.edson.estoqueApi2.model.Unidade;
import com.edson.estoqueApi2.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {

    @Autowired
    private UnidadeRepository unidadeRepository;

    @GetMapping
    public List<Unidade> getUnidades() {
        return unidadeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Unidade getUnidadeById(@PathVariable Long id) {
        return unidadeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unidade não encontrada com o id " + id));
    }

    @PostMapping
    public Unidade createUnidade(@Valid @RequestBody Unidade unidade) {
        return unidadeRepository.save(unidade);
    }

    @PutMapping("/{id}")
    public Unidade updateUnidade(@PathVariable Long id, @Valid @RequestBody Unidade unidadeAtualizada) {
        return unidadeRepository.findById(id)
                .map(unidade -> {
                    unidade.setNome(unidadeAtualizada.getNome());
                    unidade.setSigla(unidadeAtualizada.getSigla());
                    return unidadeRepository.save(unidade);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Unidade não encontrada com o id " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteUnidade(@PathVariable Long id) {
        unidadeRepository.deleteById(id);
    }

}
