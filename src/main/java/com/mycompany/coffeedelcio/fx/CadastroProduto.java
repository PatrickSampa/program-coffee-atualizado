package com.mycompany.coffeedelcio.fx;

import com.mycompany.coffeedelcio.classe.Driver;
import com.mycompany.coffeedelcio.classe.Produto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.SQLException;
import java.sql.Statement;

public class CadastroProduto {

    @FXML
    private Button BotaoCadastro;

    @FXML
    private TextField NomeProduto;

    @FXML
    private TextField ValorProduto;

    private Statement statement;

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    {
        try {
            setStatement(Driver.createConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void CadastroProduto(ActionEvent event) throws SQLException {
        Produto produto = new Produto(NomeProduto.getText(), ValorProduto.getText());
        getStatement().execute("INSERT INTO produto (Nome, Preco) values ('" + produto.getNome() + "','" + produto.getPreco() + "');");
        JOptionPane.showMessageDialog(null, "Produto Cadastrado");

    }

}
