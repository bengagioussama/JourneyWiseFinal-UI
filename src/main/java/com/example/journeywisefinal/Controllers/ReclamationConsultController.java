package com.example.journeywisefinal.Controllers;

import com.example.journeywisefinal.Entities.Etat;
import com.example.journeywisefinal.Entities.Reclamation;
import com.example.journeywisefinal.Entities.Reservation;
import com.example.journeywisefinal.Services.ServiceReclamation;
import com.example.journeywisefinal.Services.ServiceReservation;
import com.example.journeywisefinal.SideBarController;
import com.example.journeywisefinal.Utils.DataSource;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReclamationConsultController implements Initializable {


    @FXML
    private TableView<Reclamation> tableView;

    @FXML
    private TableColumn<Reclamation, Integer> idColumn;

    @FXML
    private TableColumn<Reclamation, LocalDate> dateColumn;

    @FXML
    private TableColumn<Reclamation, String> objetColumn;

    @FXML
    private Button newReclamation;
    @FXML
    private TableColumn<Reclamation, String> etatColumn;

    @FXML
    private TableColumn<Reclamation, String> Description;

    @FXML
    private TableColumn<Reclamation, Void> deleteColumn;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateReclamation"));
        objetColumn.setCellValueFactory(new PropertyValueFactory<>("objet"));
        etatColumn.setCellValueFactory(new PropertyValueFactory<>("etat"));
        Description.setCellValueFactory(new PropertyValueFactory<>("description"));

        deleteColumn.setCellFactory(col -> new DeleteButtonCell());

        ServiceReclamation listReclamations = new ServiceReclamation();
        List<Reclamation> reclamations = null;
        try {
            reclamations = listReclamations.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tableView.getItems().addAll(reclamations);
    }

    @FXML
    public void navigateToNewReclamation() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/journeywisefinal/Reclamation.fxml"));
            Pane reclamationLayout = loader.load();

            // Create a new stage for the Reclamation window
            Stage reclamationStage = new Stage();
            reclamationStage.setTitle("Reclamation Window");

            // Set the scene with the content loaded from Reclamation.fxml
            Scene reclamationScene = new Scene(reclamationLayout);
            reclamationStage.setScene(reclamationScene);

            // Show the Reclamation window
            reclamationStage.show();
        } catch (IOException ex) {
            ex.printStackTrace(); // Handle the exception appropriately
        }
    }






}
