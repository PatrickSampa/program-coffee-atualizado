package com.mycompany.coffeedelcio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.sql.Statement;

public class BuscarCliente {

    @FXML
    private TextField CPFUser;

    @FXML
    private TextField CampoUser;

    @FXML
    private TextField EmailUser;

    @FXML
    private TextField EnderecoUser;

    @FXML
    private TextField NomeUser;

    @FXML
    private Button SearchButton;

    @FXML
    private TextField TelefoneUser;

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
    void BotaoBusca(ActionEvent event) {


    }

}
