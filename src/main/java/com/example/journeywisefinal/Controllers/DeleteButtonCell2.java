package com.example.journeywisefinal.Controllers;

import com.example.journeywisefinal.Entities.Reclamation;
import com.example.journeywisefinal.Entities.Reservation;
import com.example.journeywisefinal.Services.ServiceReclamation;
import com.example.journeywisefinal.Services.ServiceReservation;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

import java.sql.SQLException;

public class DeleteButtonCell2 extends TableCell<Reservation, Void> {
    private final Button deleteButton;

    public DeleteButtonCell2() {
        deleteButton = new Button("Supprimer");
        deleteButton.setOnAction(event -> {
            Reservation reservation = getTableView().getItems().get(getIndex());
            ServiceReservation serviceReservation = new ServiceReservation();
            try {
                serviceReservation.delete((int) reservation.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            getTableView().getItems().remove(reservation);
        });
    }

    @Override
    protected void updateItem(Void item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
        } else {
            setGraphic(deleteButton);
        }
    }
}
