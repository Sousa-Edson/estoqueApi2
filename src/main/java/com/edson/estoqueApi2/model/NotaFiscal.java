package com.edson.estoqueApi2.model;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class NotaFiscal {
    private String numero;
    private LocalDate dataEmissao;
    private String nomeCliente;
    private String cpfCliente;
    private String enderecoCliente;
    private BigDecimal valorTotal;
    private List<Item> itens;

    // construtores, getters e setters
}
