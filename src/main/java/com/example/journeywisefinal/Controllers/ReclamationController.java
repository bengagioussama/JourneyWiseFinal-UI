package com.example.journeywisefinal.Controllers;

import com.example.journeywisefinal.Entities.Etat;
import com.example.journeywisefinal.Entities.Reclamation;
import com.example.journeywisefinal.Entities.Reservation;
import com.example.journeywisefinal.Services.ServiceReclamation;
import com.example.journeywisefinal.Services.ServiceReservation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

public class ReclamationController implements Initializable {


    @FXML
    public ChoiceBox<String> choiceBox;

    @FXML
    public TextField subjectReclamation;

    @FXML
    public TextArea problemDescription;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateChoiceBox();
    }

    private void populateChoiceBox() {
        try {
            ServiceReservation sr = new ServiceReservation();
            ArrayList<Reservation> Reservations = sr.readAll();

            for (Reservation reservation : Reservations) {
                choiceBox.getItems().add("Réservation Numéro : "+String.valueOf(reservation.getId()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addReclamation(MouseEvent mouseEvent) {
        try {
            LocalDate date = LocalDate. now();
            Reclamation reclamation = new Reclamation(date, subjectReclamation.getText(),problemDescription.getText() , Etat.PENDING);
            ServiceReclamation serviceReclamation = new ServiceReclamation();
            serviceReclamation.add(reclamation);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
