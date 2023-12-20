package com.example.journeywisefinal.Controllers;

import com.example.journeywisefinal.Entities.Etat;
import com.example.journeywisefinal.Entities.Reclamation;
import com.example.journeywisefinal.Entities.Reservation;
import com.example.journeywisefinal.Services.ServiceReclamation;
import com.example.journeywisefinal.Services.ServiceReservation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
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
    private TableColumn<Reclamation, String> etatColumn;

    @FXML
    private TableColumn<Reclamation, Void> deleteColumn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateReclamation"));
        objetColumn.setCellValueFactory(new PropertyValueFactory<>("objet"));
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

    }



}
