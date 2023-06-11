package com.example.trabalhopratico;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

public class RegisterprofessorController {
    @FXML
    private Button CloseButton;
    @FXML
    private Label registrationMessageLabel;
    @FXML
    private PasswordField setPasswordField;
    @FXML
    private PasswordField ConfirmPasswordField;
    @FXML
    private Label ConfirmPasswordLabel;
    @FXML
    private TextField FirstnameTextField;
    @FXML
    private TextField LastnameTextField;
    @FXML
    private TextField UsernameTextField;



    public void CloseButtonOnAction(ActionEvent event){
        Stage stage = (Stage) CloseButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }
    public void voltar(MouseEvent evento) throws IOException {
        Parent go2 = FXMLLoader.load(getClass().getResource("Profil.fxml"));
        Scene goScene2 = new Scene(go2);
        Stage goStage2 = (Stage) ((Node)evento.getSource()).getScene().getWindow();
        goStage2.setScene(goScene2);
        goStage2.show();
    }
    public void registrationButtonOnAction(ActionEvent event){
        if (setPasswordField.getText().equals(ConfirmPasswordField.getText())) {
            registerprofessor();
            ConfirmPasswordLabel.setText("");

        }
        else {
            ConfirmPasswordLabel.setText("Password does not match");
        }
    }


    public void registerprofessor(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String firstname=FirstnameTextField.getText();
        String lastname =LastnameTextField.getText();
        String username =UsernameTextField.getText();
        String password =setPasswordField.getText();
        String insertFields = "INSERT INTO professor(Firstname, LastName, Username, Password) VALUES ('";
        String insertValues = firstname +"','"+ lastname +"','" + username + "','" + password +"')";
        String insertToRegister = insertFields + insertValues;
        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            registrationMessageLabel.setText("User has been registered successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

}
