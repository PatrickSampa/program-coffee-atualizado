package com.mycompany.coffeedelcio;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MenuPrincipal  {

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


}
