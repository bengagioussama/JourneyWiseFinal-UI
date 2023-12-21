package com.example.journeywisefinal.Controllers;
import com.example.journeywisefinal.Entities.Offres;
import com.example.journeywisefinal.Entities.Reservation;
import com.example.journeywisefinal.Services.ServiceReclamation;
import com.example.journeywisefinal.Services.ServiceReservation;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import static java.sql.Date.valueOf;

public class ReserverButton extends TableCell<Offres, Void> {
    private final Button reserveButton;

    public ReserverButton() {
        reserveButton = new Button("Reserver");
        reserveButton.setOnAction(event -> {
            Offres offres = getTableView().getItems().get(getIndex());
            ServiceReservation serviceReservation = new ServiceReservation();

            // Pass the Offres object to the Reservation constructor
            Reservation reservation = new Reservation(valueOf(offres.getDate()), valueOf(offres.getDate()), 2, offres.getId_offre(), 1);

            try {
                serviceReservation.add(reservation);
                showAlert(Alert.AlertType.INFORMATION, "Congratulations", "Reserved Successfully!.");



            } catch (SQLException e) {
                e.printStackTrace();
            }

        });
    }


    @Override
    protected void updateItem(Void item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
        } else {
            setGraphic(reserveButton);
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
