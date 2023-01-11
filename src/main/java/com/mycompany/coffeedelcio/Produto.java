package com.mycompany.coffeedelcio;

public class Produto {

    private String nome;

    private String preco;

    private String tipo;

    public Produto(String nome, String preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Produto(String nome, String preco, String tipo) {
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
