package com.mycompany.coffeedelcio.fx;

import com.mycompany.coffeedelcio.classe.Cliente;
import com.mycompany.coffeedelcio.classe.Driver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.*;

import java.sql.SQLException;
import java.sql.Statement;

public class CadastroUsuarioController {

    @FXML
    private Button Limpar;

    @FXML
    private TextField CPFUser;

    @FXML
    private Button CadastroButton;

    @FXML
    private TextField EmailUser;

    @FXML
    private TextField EnderecoUser;

    @FXML
    private TextField NomeUser;

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
    void ButtonPersist(ActionEvent event) throws SQLException {
         Cliente cliente = new Cliente(NomeUser.getText(),CPFUser.getText(),TelefoneUser.getText(),EmailUser.getText(),EnderecoUser.getText());
         getStatement().execute("INSERT INTO cliente (nome, CPF, Telefone, email, Endereco) values ('" +cliente.getNome() +"','" + cliente.getCpf() + "','" + cliente.getTelefone() +"','" + cliente.getEmail() +"','"+
                cliente.getEndereco() +"');");
         String title = "Usuário Cadastrado";

        JOptionPane.showMessageDialog(null, "Nome: " + cliente.getNome(), "Usuário Cadastrado", JOptionPane.INFORMATION_MESSAGE);



    }

    @FXML
    void BotaoLimpar(ActionEvent event) {
        NomeUser.setText(null);
        CPFUser.setText(null);
        TelefoneUser.setText(null);
        EmailUser.setText(null);
        EnderecoUser.setText(null);


    }

}

