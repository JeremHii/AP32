package fr.ap.apjavafx.controller;

import fr.ap.apjavafx.model.DTO.Commercial;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCommerciauxListe implements Initializable {

    @FXML private TableView<Commercial> tabCommerciaux;

    @FXML protected void btnNewCommercial(ActionEvent e){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
