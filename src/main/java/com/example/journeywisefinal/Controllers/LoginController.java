package com.example.journeywisefinal.Controllers;

import com.example.journeywisefinal.Services.ServiceUser;
import com.example.journeywisefinal.Utils.DataSource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {

    private Connection connection = DataSource.getInstance().getCon();

    @FXML
    private TextField emailTextField;

    @FXML
    private Button loginBtn;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button signupBtn;

    @FXML
    void loginBtnOnAction(ActionEvent event) {
        if(!emailTextField.getText().isEmpty() && !passwordTextField.getText().isEmpty()){
            loginMessageLabel.setText("You try to login!");
            validateLogin();
        }
        else {
            loginMessageLabel.setText("Please enter username and password");
        }
    }
    public void validateLogin(){

        ServiceUser serviceUser = new ServiceUser();
        Boolean isLoggedIn = serviceUser.validateLogin(emailTextField.getText(),passwordTextField.getText());


        if(isLoggedIn) {

        loginMessageLabel.setText("Welcome");
        }
        else {
        loginMessageLabel.setText("Invalid login");
        }


    }
    @FXML
    public void addAccount() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/journeywisefinal/user-view.fxml"));
            Pane reclamationLayout = loader.load();

            Stage reclamationStage = new Stage();
            reclamationStage.setTitle("Reclamation");

            Scene reclamationScene = new Scene(reclamationLayout);
            reclamationStage.setScene(reclamationScene);

            reclamationStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}