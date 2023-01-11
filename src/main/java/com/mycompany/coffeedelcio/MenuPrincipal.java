package com.mycompany.coffeedelcio;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import javax.swing.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;


public class MenuPrincipal  {

    @FXML
    private TextField FieldCPF;

    @FXML
    private TextField FieldCliente;

    @FXML
    private TextField FieldPedidos;

    @FXML
    private TextArea FieldPedidos2;

    @FXML
    private TextField FieldTotal;

    @FXML
    private Button SearchButton;

    @FXML
    private Button clickBuscarCliente;

    @FXML
    private Button clickCadastrarCliente;

    @FXML
    private Button clickCadastroPedido;

    @FXML
    private Button inserirProduto;

    @FXML
    private Button sairApp;

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
    void buscarCliente(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("buscarCliente.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Buscar Cliente");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void cadastrarCliente(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("cadastroUsuario.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Cadastrar Cliente");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void cadastroPedido(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("pedido2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Cadastrar Pedido");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void clickInserirProduto(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("cadastrarproduto.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Adicionar Produto");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void fecharApp(ActionEvent event) {
        Stage stage = (Stage) sairApp.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    @FXML
    void SearchPedidos(ActionEvent event) throws SQLException {
        int id = 0;
        String nome = "";
        String pedidos = "";
        String listaPedidos = "";
        String cpf = FieldCPF.getText();
        float total = 0;

        ResultSet rs = getStatement().executeQuery("SELECT * from cliente where cpf = '" + cpf + "';");
        while (rs.next()){
            id = rs.getInt(1);
            nome = rs.getString(2);
        }
        if (id == 0){
            JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);

        }

        ResultSet resultSets = getStatement().executeQuery("SELECT * from pedido where fkCliente = '" + id + "';");
        while (resultSets.next()){
            total = resultSets.getFloat(3);
            pedidos = resultSets.getString(4);
        }
        if (total == 0 && id > 0){
            JOptionPane.showMessageDialog(null, "Usuário não realizou pedidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        String[] list = pedidos.split(",");
        for (String l: list) {
            listaPedidos += l + "\n";
        }

        FieldPedidos2.setText(listaPedidos);
        FieldCliente.setText(nome);
        FieldTotal.setText(String.valueOf(total));
    }


}
