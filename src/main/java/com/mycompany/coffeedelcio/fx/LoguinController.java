package com.mycompany.coffeedelcio.fx;

import com.mycompany.coffeedelcio.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.IOException;


public class LoguinController  {


    @FXML
    private Button loguinUser;

    @FXML
    private PasswordField passwordUser;

    @FXML
    private TextField textUser;

    @FXML
    private Label userIncorreto;

    @FXML
    void openSystem(ActionEvent event) throws IOException {
        if(textUser.getText().equals("admin") && passwordUser.getText().equals("admin")){
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menuPrincipal.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("MENU");
            stage.setScene(scene);
            stage.show();
            Main loguin = new Main();

        }else {
            userIncorreto.setText("Incorrect user");
        }

    }


}
