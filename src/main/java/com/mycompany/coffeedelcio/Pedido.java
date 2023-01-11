package com.mycompany.coffeedelcio;

public class Pedido {

    int fkCliente;
    double total;
    String listaProdutos;

    public String getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(String listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public Pedido(int fkCliente, double total, String listaProdutos) {
        this.fkCliente = fkCliente;
        this.total = total;
        this.listaProdutos = listaProdutos;
    }

    public int getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(int fkCliente) {
        this.fkCliente = fkCliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
