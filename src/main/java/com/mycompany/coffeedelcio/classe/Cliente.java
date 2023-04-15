package com.mycompany.coffeedelcio.classe;
import java.sql.SQLException;
import java.sql.Statement;

public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String endereco;

    public Cliente(String nome, String cpf, String telefone, String email, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
            this.endereco = endereco;
    }

    private Statement statement;
    {
        try {
            setStatement(Driver.createConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void inserirCliente(Cliente cli) throws SQLException {
        getStatement().execute("INSERT INTO cliente (nome, telefone, email, endereco) values ('" +cli.getNome() +"','" + cli.getTelefone() + "','" + cli.getEmail() +"','" + cli.getEndereco() + "');");

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cliente(String nome, String cpf, String telefone, String email, String endereco, Statement statement) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.statement = statement;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}
