package com.edson.estoqueApi2.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    private String nome;
    @NotNull(message = "O cnpj não pode ser nulo")
    @NotBlank(message = "O cnpj não pode ser em branco")
    private String cnpj;
    @NotNull(message = "O endereco não pode ser nulo")
    @NotBlank(message = "O endereco não pode ser em branco")
    private String endereco;
    private String telefone;
    @NotNull(message = "O inscricao estadual não pode ser nulo")
    @NotBlank(message = "O inscricao estadual não pode ser em branco")
    private String inscricaoEstadual;

    public Cliente(String nome, String cnpj, String endereco, String telefone, String inscricaoEstadual) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
}