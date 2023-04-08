package com.edson.estoqueApi2.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private Integer quantidade;

    private BigDecimal valorTotal;

    public Item() {
    }

    public Item(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
//        this.valorTotal = produto.getPreco() * quantidade;
        this.valorTotal = produto.getPreco().multiply(new BigDecimal(quantidade));

    }

    // getters e setters


    public String getValorTotalEmReal() {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return format.format(valorTotal);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = BigDecimal.valueOf(valorTotal);
    }
}
