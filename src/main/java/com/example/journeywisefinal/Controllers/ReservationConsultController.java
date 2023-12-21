package com.example.journeywisefinal.Controllers;

import com.example.journeywisefinal.Entities.Reclamation;
import com.example.journeywisefinal.Entities.Reservation;
import com.example.journeywisefinal.Services.ServiceReclamation;
import com.example.journeywisefinal.Services.ServiceReservation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationConsultController implements Initializable {


    @FXML
    private TableView<Reservation> tableView;

    @FXML
    private TableColumn<Reservation, Integer> idColumn;

    @FXML
    private TableColumn<Reservation, LocalDate> dateDebut;

    @FXML
    private TableColumn<Reservation, LocalDate> dateFin;


    @FXML
    private TableColumn<Reservation, Integer> nombrePassages;

    @FXML
    private TableColumn<Reservation, Integer> idOffre;

    @FXML
    private TableColumn<Reservation, Integer> idUser;

    @FXML
    private TableColumn<Reservation, Void> supprimer;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        dateDebut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        dateFin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        nombrePassages.setCellValueFactory(new PropertyValueFactory<>("nombrePassages"));
        idOffre.setCellValueFactory(new PropertyValueFactory<>("Offre"));
        idUser.setCellValueFactory(new PropertyValueFactory<>("IdUser"));

        supprimer.setCellFactory(col -> new DeleteButtonCell2());

        ServiceReservation listReservation = new ServiceReservation();
        List<Reservation> reservations = null;
        try {
            reservations = listReservation.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tableView.getItems().addAll(reservations);
    }









}
