package com.example.journeywisefinal.Controllers;

import com.example.journeywisefinal.Entities.Reclamation;
import com.example.journeywisefinal.Services.ServiceReclamation;
import com.example.journeywisefinal.Utils.DataSource;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

import java.sql.SQLException;

public class  DeleteButtonCell extends TableCell<Reclamation, Void> {
    private final Button deleteButton;

    public DeleteButtonCell() {
        deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> {
            Reclamation reclamation = getTableView().getItems().get(getIndex());
            ServiceReclamation serviceReclamation = new ServiceReclamation();
            try {
                serviceReclamation.delete((int) reclamation.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            getTableView().getItems().remove(reclamation);
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
