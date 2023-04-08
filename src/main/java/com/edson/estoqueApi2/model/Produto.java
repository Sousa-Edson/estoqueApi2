package com.edson.estoqueApi2.model;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome do produto não pode ser nulo")
    @NotBlank(message = "O nome do produto não pode ser em branco")
    private String nome;

    @NotNull(message = "A descrição do produto não pode ser nula")
    @NotBlank(message = "A descrição do produto não pode ser em branco")
    private String descricao;

    private BigDecimal preco;

    private boolean ativa;

    @ManyToOne
    @JoinColumn(name = "unidade_id", nullable = false)
    private Unidade unidade;


    // getters e setters


    public Produto() {
    }

    public Produto(String nome, String descricao, Double preco, Unidade unidade, boolean ativa) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = BigDecimal.valueOf(preco);
        this.unidade = unidade;
        this.ativa = ativa;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public String getPrecoEmReal() {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return format.format(preco);
    }
}
