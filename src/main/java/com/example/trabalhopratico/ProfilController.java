package com.example.trabalhopratico;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ProfilController {
    @FXML
    private Button FecharButton1;
    @FXML
    private Button ButtonAluno;
    @FXML
    private Button ButtonProfessor;
    @FXML
    private Button ButtonFuncionario;



    public void ProfessorButtonOnAction(ActionEvent event){CreateLoginprofessorForm();}
    public void AlunoButtonOnAction(ActionEvent event){
        CreateLoginForm();
    }
    public void FuncionarioButtonOnAction(ActionEvent event){CreateLoginfuncionarioForm();}
    public void FecharButtonOnAction1(ActionEvent event){
        Stage stage = (Stage) FecharButton1.getScene().getWindow();
        stage.close();
    }
    public void CreateLoginForm(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource( "Login.fxml"));
            Stage registerStage =(Stage) ButtonAluno.getScene().getWindow();
            registerStage.setScene (new Scene(root, 800, 600));
            registerStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();}
    }
    public void CreateLoginprofessorForm(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource( "loginprofessor.fxml"));
            Stage registerStage =(Stage) ButtonProfessor.getScene().getWindow();
            registerStage.setScene (new Scene(root, 800, 600));
            registerStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();}
    }
    public void CreateLoginfuncionarioForm(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource( "loginfuncionario.fxml"));
            Stage registerStage =(Stage) ButtonFuncionario.getScene().getWindow();
            registerStage.setScene (new Scene(root, 800, 600));
            registerStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();}
    }
}
