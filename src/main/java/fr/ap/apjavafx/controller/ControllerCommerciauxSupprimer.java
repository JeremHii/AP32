package fr.ap.apjavafx.controller;

import fr.ap.apjavafx.libs.LoadScene;
import fr.ap.apjavafx.model.DTO.CommercialDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCommerciauxSupprimer extends ControllerBase implements Initializable {

    @FXML public Label lblCommercial;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @Override
    public void loaded() {
        CommercialDTO commercial = (CommercialDTO) getParam("COMMERCIAL");

        setTitle("Suppression de " + commercial.getNom() + " " + commercial.getPrenom());

        lblCommercial.setText(commercial.getPrenom() + " " + commercial.getNom() + " ?");
    }

    @FXML public void btnConfirmerClick(ActionEvent actionEvent) throws IOException {
        CommercialDTO commercial = (CommercialDTO) getParam("COMMERCIAL");
        commercial.delete();
        LoadScene.load(actionEvent, getClass().getResource("/fxml/view-commerciaux-liste.fxml"));
    }

    @FXML public void btnAnnulerClick(ActionEvent actionEvent) throws IOException {
        LoadScene.load(actionEvent, getClass().getResource("/fxml/view-commerciaux-liste.fxml"));
    }
}
