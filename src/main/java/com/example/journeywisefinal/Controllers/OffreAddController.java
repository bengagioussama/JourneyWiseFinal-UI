package com.example.journeywisefinal.Controllers;

import com.example.journeywisefinal.Entities.Etat;
import com.example.journeywisefinal.Entities.Offres;
import com.example.journeywisefinal.Entities.Reclamation;
import com.example.journeywisefinal.Entities.Reservation;
import com.example.journeywisefinal.Services.ServiceOffre;
import com.example.journeywisefinal.Services.ServiceReclamation;
import com.example.journeywisefinal.Services.ServiceReservation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OffreAddController implements Initializable {

    @FXML
    public TextField paysOffre;

    @FXML
    public TextField citeOffre;

    @FXML
    public TextField lieuOffre;

    @FXML
    public DatePicker dateOffre;

    @FXML
    public TextField prixOffre;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }




    public void addOffre(MouseEvent mouseEvent) {
        try {

            Offres offres = new Offres(paysOffre.getText(),citeOffre.getText(),lieuOffre.getText(),dateOffre.getValue(),Float.parseFloat(prixOffre.getText()));
            ServiceOffre serviceOffre = new ServiceOffre();
            serviceOffre.add(offres);
            showAlert(Alert.AlertType.INFORMATION, "Congratulations", "Offre Ajoutée!!.");

        }
        catch (Exception e) {
            System.out.println(e);
        }
    }


    private void showAlert(Alert.AlertType alertType, String title, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}
