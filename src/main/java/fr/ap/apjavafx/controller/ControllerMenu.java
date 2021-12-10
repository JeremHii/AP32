package fr.ap.apjavafx.controller;

import fr.ap.apjavafx.libs.LoadScene;
import fr.ap.apjavafx.model.DTO.UtilisateurDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMenu extends ControllerBase implements Initializable {

    @FXML Label lblMessage;

    private static UtilisateurDTO user;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void loaded() {
        setTitle("Menu");
        user = (UtilisateurDTO) getParam("UTILISATEUR");
    }

    @FXML public void btnCommerciauxClick(ActionEvent e) throws IOException {
        if(user.getFonction().equals("ADMIN") || user.getFonction().equals("RESPONSABLE")){
            LoadScene.load(e, getClass().getResource("/fxml/view-commerciaux-liste.fxml"));
        }
        else noPermission();
    }

    @FXML public void btnClientsClick(ActionEvent e) throws IOException {
        if(user.getFonction().equals("ADMIN") || user.getFonction().equals("COMMERCIAL")){
            //LoadScene.load(e, getClass().getResource("/fxml/view-commerciaux-liste.fxml"));
        }
        else noPermission();
    }

    @FXML public void btnLieuxClick(ActionEvent e) throws IOException {
        if(user.getFonction().equals("ADMIN") || user.getFonction().equals("COMMERCIAL")){
            //LoadScene.load(e, getClass().getResource("/fxml/view-commerciaux-liste.fxml"));
        }
        else noPermission();
    }

    private void noPermission(){
        lblMessage.setText("Vous n'avez pas la permission d'accèder à cette page.");
    }
}
