package com.mycompany.coffeedelcio;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CadastrarPedidoController implements Initializable {

    @FXML
    private TextField ProcurarCliente;

    @FXML
    private TextField ValorTotalPagar;

    @FXML
    private Button botaoAdicionarPedido;

    @FXML
    private Button cadastrarPedido;

    @FXML
    private MenuButton nomePedido;

    @FXML
    private TextField pedidoInformado;

    @FXML
    private TextArea pedidosAdicionados;

    @FXML
    private Spinner<Integer> quantidadePedido;

    @FXML
    private TextField valorPedido;

    @FXML
    private CheckBox boxConfirmarPedido;


    public String nomeP;

    public double valorFinal;

    public String nomesFinal;
    public String todosPedidos;

    List<String> list = new ArrayList<>();

    double armazenarValor;


    public String getNome() {
        return nomeP;
    }

    public void setNome(String nome) {
        this.nomeP = nome;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valor) {
        this.valorFinal = valor;
    }

    public void setNomesFinal(String nomes){ this.nomesFinal = nomes; }

    public String getNomesFinal() {return nomesFinal;}



    @FXML
    void AdicionarPedido(ActionEvent event) {
        todosPedidos += pedidoInformado.getText() + "\n";
        pedidosAdicionados.setText(todosPedidos);



    }

    @FXML
    void clickBeijinho(ActionEvent event) {
        pedidoInformado.setText("Beijinho de Coco");
        setNome("Beijinho de Coco");

    }

    @FXML
    void clickBron(ActionEvent event) {
        pedidoInformado.setText("Brownies");
        setNome("Brownies");

    }

    @FXML
    void clickCadastrarProduto(ActionEvent event) {

    }

    @FXML
    void clickCafe(ActionEvent event) {
        pedidoInformado.setText("Café");
        setNome("Café");

    }

    @FXML
    void clickCook(ActionEvent event) {
        pedidoInformado.setText("Cookies");
        setNome("Cookies");

    }

    @FXML
    void clockTorta(ActionEvent event) {
        pedidoInformado.setText("Torta de Morango");
        setNome("Torta de Morango");

    }

    @FXML
    void mostrarNoMeu(ActionEvent event) {


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0,20);
        valueFactory.setValue(0);
        quantidadePedido.setValueFactory(valueFactory);
        int valorSpinner = quantidadePedido.getValue();
        valorPedido.setText(String.valueOf(valorSpinner));
        quantidadePedido.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                int valorSpinner = quantidadePedido.getValue();
                valorPedido.setText(String.valueOf(calculo(valorSpinner)));
            }
        });

    }


    private double calculo(double valor) {//Calculo para o valor somado

        if (getNome().equals("Cookies")) {
            armazenarValor = valor * 10;
            setValorFinal(armazenarValor);
            return armazenarValor;
        } else if (getNome().equals("Brownies")) {
            armazenarValor = valor * 4.50;
            setValorFinal(armazenarValor);
            return armazenarValor;
        } else if (getNome().equals("Torta de Morango")) {
            armazenarValor = valor * 16.50;
            setValorFinal(armazenarValor);
            return armazenarValor;
        }else if(getNome().equals("Café")){
            armazenarValor = valor * 3.50;
            setValorFinal(armazenarValor);
            return armazenarValor;
        }else if(getNome().equals("Beijinho de Coco")){
            armazenarValor = valor * 8.50;
            setValorFinal(armazenarValor);
            return armazenarValor;
        }
        return 0;
    }

}

