package com.example.journeywisefinal.Controllers;

import com.example.journeywisefinal.Entities.Offres;
import com.example.journeywisefinal.Entities.Reclamation;
import com.example.journeywisefinal.Services.ServiceOffre;
import com.example.journeywisefinal.Services.ServiceReclamation;
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

public class OffresConsultController implements Initializable {


    @FXML
    private TableView<Offres> tableView;

    @FXML
    private TableColumn<Offres, Integer> idColumn;

    @FXML
    private TableColumn<Offres, String> paysColumn;

    @FXML
    private TableColumn<Offres, String> citeColumn;

    @FXML
    private Button newOffre;
    @FXML
    private TableColumn<Offres, String> lieuColumn;

    @FXML
    private TableColumn<Offres, LocalDate> dateColumn;

    @FXML
    private TableColumn<Offres, String> prixColumn;

    @FXML
    private TableColumn<Offres, Void> reserve;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id_offre"));
        paysColumn.setCellValueFactory(new PropertyValueFactory<>("Pays"));
        citeColumn.setCellValueFactory(new PropertyValueFactory<>("Cite"));
        lieuColumn.setCellValueFactory(new PropertyValueFactory<>("Lieu"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
        prixColumn.setCellValueFactory(new PropertyValueFactory<>("Prix"));

        reserve.setCellFactory(col -> new ReserverButton());

        ServiceOffre listOffres = new ServiceOffre();
            List<Offres> offres = null;
        try {
            offres = listOffres.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tableView.getItems().addAll(offres);
    }

    @FXML
    public void navigateToNewOffre() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/journeywisefinal/Offres-create.fxml"));
            Pane reclamationLayout = loader.load();

            Stage reclamationStage = new Stage();
            reclamationStage.setTitle("Reclamation");

            Scene reclamationScene = new Scene(reclamationLayout);
            reclamationStage.setScene(reclamationScene);

            reclamationStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }






}
