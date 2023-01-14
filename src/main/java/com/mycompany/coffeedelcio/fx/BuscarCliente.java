package com.mycompany.coffeedelcio.fx;

import com.mycompany.coffeedelcio.classe.Driver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
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
    void BotaoBusca(ActionEvent event) throws SQLException {
        ResultSet rs = getStatement().executeQuery("SELECT * from  cliente where CPF = '" + CampoUser.getText()+"';");
        while (rs.next()){
            NomeUser.setText(rs.getString(2));
            CPFUser.setText(rs.getString(3));
            TelefoneUser.setText(rs.getString(4));
            EmailUser.setText(rs.getString(5));
            EnderecoUser.setText(rs.getString(6));
        }

    }

}
