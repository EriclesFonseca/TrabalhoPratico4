package com.example.trabalhopratico;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Label FirstnameLabel;
    @FXML
    private Label FirstnameLabel1;
    @FXML
    private Label FirstnamefuncionarioLabel;
    @FXML
    private Label FirstnamefuncionarioLabel1;

    @FXML
    private Label FirstnameprofessorLabel;
    @FXML
    private Label FirstnameprofessorLabel1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (HelloController.pegarnome != null) {
            FirstnameLabel.setText(HelloController.pegarnome);
            FirstnameLabel1.setText(HelloController.pegarnome);
        }


        if (LoginfuncionarioController.pegarnomefuncionario != null) {
            FirstnamefuncionarioLabel.setText(LoginfuncionarioController.pegarnomefuncionario);
            FirstnamefuncionarioLabel1.setText(LoginfuncionarioController.pegarnomefuncionario);
        }

        if (LoginprofessorController.pegarnomeprofessor != null) {
            FirstnameprofessorLabel.setText(LoginprofessorController.pegarnomeprofessor);
        }
    }


}

