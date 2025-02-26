package com.furb.model;

import java.io.Serializable;

public class Atleta implements Serializable {

    private String nome;
    private String cpf;
    private Float altura;
    private Float peso;
    private Endereco endereco;

    public Atleta(String nome, String cpf, Float altura, Float peso, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.altura = altura;
        this.peso = peso;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Float getAltura() {
        return altura;
    }

    public Float getPeso() {
        return peso;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
