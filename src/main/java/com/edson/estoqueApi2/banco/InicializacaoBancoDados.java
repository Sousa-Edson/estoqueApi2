package com.edson.estoqueApi2.banco;


import com.edson.estoqueApi2.model.Item;
import com.edson.estoqueApi2.model.Produto;
import com.edson.estoqueApi2.model.Unidade;
import com.edson.estoqueApi2.repository.ItemRepository;
import com.edson.estoqueApi2.repository.ProdutoRepository;
import com.edson.estoqueApi2.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class InicializacaoBancoDados implements CommandLineRunner {

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void run(String... args) throws Exception {
        Unidade unidade1 = new Unidade();
        unidade1.setNome("Kilograma");
        unidade1.setSigla("kg");
        unidade1.setAtiva(true);
        unidadeRepository.save(unidade1);

        Unidade unidade2 = new Unidade();
        unidade2.setNome("Litro");
        unidade2.setSigla("ml");
        unidade2.setAtiva(true);
        unidadeRepository.save(unidade2);

        Unidade unidade3 = new Unidade();
        unidade3.setNome("Unidade");
        unidade3.setSigla("un");
        unidade3.setAtiva(true);
        unidadeRepository.save(unidade3);
//
//        Produto produto1 = new Produto();
//        produto1.setNome("Arroz");
//        produto1.setDescricao("Arroz branco tipo 1");
//        produto1.setPreco(BigDecimal.valueOf(5.50));
//        produto1.setUnidade(unidade1);
//        produto1.setAtiva(true);
//        produtoRepository.save(produto1);
//
//        Produto produto2 = new Produto();
//        produto2.setNome("Feijão");
//        produto2.setDescricao("Feijão carioca");
//        produto2.setPreco(BigDecimal.valueOf(8.90));
//        produto2.setUnidade(unidade3);
//        produto2.setAtiva(true);
//        produtoRepository.save(produto2);
//
//        Produto produto3 = new Produto();
//        produto3.setNome("Leite");
//        produto3.setDescricao("Leite integral");
//        produto3.setPreco(BigDecimal.valueOf(3.50));
//        produto3.setUnidade(unidade2);
//        produto3.setAtiva(true);
//        produtoRepository.save(produto3);

        Produto produto1 = new Produto();
        produto1.setNome("Arroz");
        produto1.setDescricao("Arroz branco tipo 1");
        produto1.setPreco(BigDecimal.valueOf(5.50));
        produto1.setUnidade(unidade1);
        produto1.setAtiva(true);
        produtoRepository.save(produto1);

        Produto produto2 = new Produto();
        produto2.setNome("Feijão");
        produto2.setDescricao("Feijão carioca tipo 1");
        produto2.setPreco(BigDecimal.valueOf(8.20));
        produto2.setUnidade(unidade1);
        produto2.setAtiva(true);
        produtoRepository.save(produto2);

        Produto produto3 = new Produto();
        produto3.setNome("Azeite");
        produto3.setDescricao("Azeite de oliva extravirgem");
        produto3.setPreco(BigDecimal.valueOf(25.90));
        produto3.setUnidade(unidade1);
        produto3.setAtiva(true);
        produtoRepository.save(produto3);

        Produto produto4 = new Produto();
        produto4.setNome("Macarrão");
        produto4.setDescricao("Macarrão tipo espaguete");
        produto4.setPreco(BigDecimal.valueOf(3.40));
        produto4.setUnidade(unidade1);
        produto4.setAtiva(true);
        produtoRepository.save(produto4);

        Produto produto5 = new Produto();
        produto5.setNome("Molho de tomate");
        produto5.setDescricao("Molho de tomate pronto");
        produto5.setPreco(BigDecimal.valueOf(4.90));
        produto5.setUnidade(unidade1);
        produto5.setAtiva(true);
        produtoRepository.save(produto5);

        Produto produto6 = new Produto();
        produto6.setNome("Cerveja");
        produto6.setDescricao("Cerveja Pilsen");
        produto6.setPreco(BigDecimal.valueOf(3.50));
        produto6.setUnidade(unidade2);
        produto6.setAtiva(true);
        produtoRepository.save(produto6);

        Produto produto7 = new Produto();
        produto7.setNome("Refrigerante");
        produto7.setDescricao("Refrigerante de cola");
        produto7.setPreco(BigDecimal.valueOf(4.80));
        produto7.setUnidade(unidade2);
        produto7.setAtiva(true);
        produtoRepository.save(produto7);

        Produto produto8 = new Produto();
        produto8.setNome("Leite");
        produto8.setDescricao("Leite integral");
        produto8.setPreco(BigDecimal.valueOf(3.60));
        produto8.setUnidade(unidade2);
        produto8.setAtiva(true);
        produtoRepository.save(produto8);

        Produto produto9 = new Produto();
        produto9.setNome("Café");
        produto9.setDescricao("Café torrado e moído");
        produto9.setPreco(BigDecimal.valueOf(8.90));
        produto9.setUnidade(unidade1);
        produto9.setAtiva(true);
        produtoRepository.save(produto9);

        Produto produto10 = new Produto();
        produto10.setNome("Biscoito");
        produto10.setDescricao("Biscoito recheado");
        produto10.setPreco(BigDecimal.valueOf(2.70));
        produto10.setUnidade(unidade1);
        produto10.setAtiva(true);
        produtoRepository.save(produto10);

        itemRepository.save(new Item(produto1, 5));
        itemRepository.save(new Item(produto2, 2));
    }
}
