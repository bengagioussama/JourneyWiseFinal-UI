package com.example.journeywisefinal.Controllers;

import com.example.journeywisefinal.Entities.User;
import com.example.journeywisefinal.Services.ServiceUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class GestionUsersController {
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<User, String> emailCol;

    @FXML
    private TextField emailTxt;

    @FXML
    private TableColumn<User, String> firstNameCol;

    @FXML
    private TextField firstNameTxt;

    @FXML
    private TableColumn<User, String> idCol;

    @FXML
    private TableColumn<User, String> lastNameCol;

    @FXML
    private TextField lastNameTxt;

    @FXML
    private TableColumn<User, String> passwordCol;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private TableColumn<User, String> roleCol;

    @FXML
    private TableView<User> table;
    private final ServiceUser serviceUser = new ServiceUser();

    @FXML
    void Add(ActionEvent event){
        String firstName,lastName,email,password,role;
        firstName=firstNameTxt.getText();
        lastName=lastNameTxt.getText();
        email=emailTxt.getText();
        password=passwordTxt.getText();
        role="user";
        User newUser=new User(0,firstName,lastName,email,password);
        try{
            serviceUser.add(newUser);
            table();
            clearFields();
        }
        catch (SQLException ex){
            System.out.println(ex);
        }
    }

    @FXML
    void Delete(ActionEvent event) {

    }

    @FXML
    void Update(ActionEvent event) {

    }
    private void clearFields(){
        firstNameTxt.clear();
        lastNameTxt.clear();
        emailTxt.clear();
        passwordTxt.clear();
    }

    Connection con;
    PreparedStatement pst;
    int myIndex;
    int id;



    public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/journey_wise","root","");
        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void initialize(URL url, ResourceBundle rb) {
        Connect();
    }
    public void table(){
        Connect();
        //ObservableList<User> users = FXCollections.observableList();
        try {
            serviceUser.readAll();
            //table.setItems(users);
            //idCol.setCellValueFactory(f->f.getValue().getId());
            //firstNameCol.setCellValueFactory(f->f.getValue().getFirstName());
            //lastNameCol.setCellValueFactory(f->f.getValue().lastNameProperty);
            //emailCol.setCellValueFactory(f->f.getValue().emailProperty);
            //passwordCol.setCellValueFactory(f->f.getValue().passwordProperty);
            //roleCol.setCellValueFactory(f->f.getValue().roleProperty);
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }

}
