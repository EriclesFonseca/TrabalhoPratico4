package com.example.trabalhopratico;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodRequests;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginprofessorController {
    @FXML
    private Button FecharButton;
    @FXML
    private Button registerButton;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;

    public static String pegarnomeprofessor;
    @FXML
    public void loginButtonOnAction(ActionEvent event){
        if (usernameTextField.getText().isBlank()==false && passwordPasswordField.getText().isBlank()==false){
            pegarnomeprofessor=getusernameTextField2();
            ValidateLogin();
        }else {
            loginMessageLabel.setText("Please enter username and password.");
        }
    }
    public void voltar(MouseEvent evento) throws IOException {
        Parent go2 = FXMLLoader.load(getClass().getResource("Profil.fxml"));
        Scene goScene2 = new Scene(go2);
        Stage goStage2 = (Stage) ((Node)evento.getSource()).getScene().getWindow();
        goStage2.setScene(goScene2);
        goStage2.show();
    }
    public void registerButtonOnAction(ActionEvent event){
        createAccountForm();
    }
    public void FecharButtonOnAction(ActionEvent event){
        Stage stage = (Stage) FecharButton.getScene().getWindow();
        stage.close();
    }
    public String getusernameTextField2(){
        return usernameTextField.getText();
    }
    public void ValidateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String verifyLogin="SELECT count(1) FROM professor WHERE username = '" + usernameTextField.getText() + "' AND password = '" + passwordPasswordField.getText() + "'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery (verifyLogin);
            while(queryResult.next()) {
                if (queryResult.getInt( 1) == 1) {
                    createPageForm();
                } else {
                    loginMessageLabel.setText("Invalid Login. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void createAccountForm(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource( "registerprofessor.fxml"));
            Stage registerStage = (Stage) registerButton.getScene().getWindow();
            registerStage.setScene (new Scene(root, 800, 600));
            registerStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();}
    }
    public void createPageForm(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource( "Homeprofessor.fxml"));
            Stage HomeStage = (Stage) loginButton.getScene().getWindow();
            HomeStage.setScene (new Scene(root, 940, 612));
            HomeStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();}
    }
}
