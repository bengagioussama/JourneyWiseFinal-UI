package com.example.journeywisefinal;

import com.example.journeywisefinal.Utils.DataSource;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SideBarController implements Initializable {
    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane ap;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }



    public void Home(javafx.scene.input.MouseEvent mouseEvent) {
        bp.setCenter(ap);
    }

    public void Journal(javafx.scene.input.MouseEvent mouseEvent) {
        loadPage("/com/example/journeywisefinal/GererJournal");
    }


    public void Offres(javafx.scene.input.MouseEvent mouseEvent) {
        loadPage("/com/example/journeywisefinal/Offre-Consult");
    }

    public void Reservation(javafx.scene.input.MouseEvent mouseEvent) {
        loadPage("/com/example/journeywisefinal/Reservation");
    }

    public void Reclamation(javafx.scene.input.MouseEvent mouseEvent) {
        loadPage("Reclamation-consult");
    }


    public void Login(javafx.scene.input.MouseEvent mouseEvent) {
        loadPage("/com/example/journeywisefinal/Login-SignUp");
    }

    public void loadPage(String page) {
        Parent root  = null;

        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        }
        catch (IOException ex) {
            Logger.getLogger(SideBarController.class.getName()).log(Level.SEVERE,null,ex);
        }
        bp.setCenter(root);
    }



    public BorderPane getBorderPane() {
        return bp;
    }

    public AnchorPane getContentPane() {
        return ap;
    }



}
