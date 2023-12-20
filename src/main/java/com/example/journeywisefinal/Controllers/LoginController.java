package com.example.journeywisefinal.Controllers;

import com.example.journeywisefinal.Utils.DataSource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

        String verifyLogin = "SELECT count(1) FROM `user` WHERE `email` = '"+emailTextField.getText()+"' AND `password` = '"+passwordTextField.getText()+ "';";
        try{
            Statement statement = connection.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next()){
                if (queryResult.getInt(1)==1){
                    loginMessageLabel.setText("Welcome");

                }
                else {
                    loginMessageLabel.setText("Invalid login");
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}