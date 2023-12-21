package com.example.journeywisefinal.Controllers;

import com.example.journalfx.Entities.Journal;

import com.example.journeywisefinal.Services.ServiceJournal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class JournalController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField titreJournalField;

    @FXML
    private TextArea descriptionJournalArea;

    @FXML
    private TextField nomOffreVoyageField;

    @FXML
    private TextField nomPaysVoyageField;

    @FXML
    private Button submitButton;
    @FXML
    private VBox journalContainer;

    private ServiceJournal serviceJournal = new ServiceJournal();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Récupérer les données de la table journal
        List<Journal> journals;
        try {
            journals = serviceJournal.readAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Afficher chaque entrée dans le conteneur
        for (Journal journal : journals) {
            conteneurJournaux(journal);
        }
    }
    private void conteneurJournaux(Journal journal) {
        Label titleLabel = new Label(journal.getTitre());
        Label offreLabel = new Label(journal.getOffreVoyage());
        Label descriptionArea = new Label(journal.getDescrption());
        Separator separator = new Separator();
        titleLabel.getStyleClass().add("titleJournal");
        offreLabel.getStyleClass().add("offreJournal");
        descriptionArea.getStyleClass().add("descriptionJournal");

        if (journalContainer != null) {
            journalContainer.getChildren().addAll(titleLabel, offreLabel, descriptionArea, separator);
        }
    }

    public void redirection_Page_GererJournal(ActionEvent event) throws IOException{
        Parent parent = FXMLLoader.load((getClass().getResource("/FXML/GererJournal.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
    public void redirection_Page_FormAjoutJournal(ActionEvent event) throws IOException{
        Parent parent = FXMLLoader.load((getClass().getResource("/FXML/FormAjoutJournal.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    public void createJournal(ActionEvent event) {
        String titreJournal = titreJournalField.getText();
        String descriptionJournal = descriptionJournalArea.getText();
        String nomOffreVoyage = nomOffreVoyageField.getText();
        String nomPaysVoyage = nomPaysVoyageField.getText();

        // Note l'image et l'idUser est encore non implementé
        Journal newJournal = new Journal(nomOffreVoyage, nomPaysVoyage, titreJournal, descriptionJournal, "../../assets/images/R2.jpg", 1, 1);

        try {
            serviceJournal.add(newJournal);
            System.out.println("Journal added successfully!");
            redirectToGererjournal();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void redirectToGererjournal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/GererJournal.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) submitButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
