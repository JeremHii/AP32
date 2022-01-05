package fr.ap.apjavafx.controller;

import fr.ap.apjavafx.libs.LoadScene;
import fr.ap.apjavafx.model.DAO.FicheClientDAO;
import fr.ap.apjavafx.model.DTO.ClientDTO;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerFicheClientAjouter extends ControllerBase implements Initializable {

    @FXML private TextField tbxIdEnt;
    @FXML private TextField tbxLogin;
    @FXML private TextField tbxNom;
    @FXML private TextField tbxPrenom;
    @FXML private TextField tbxContacto_n;
    @FXML private TextField tbxTelephone;
    @FXML private TextField tbxMail;
    @FXML private TextField tbxEtatContact;
    @FXML private Label lblMessage;

    @FXML protected void btnAnnulerClick(ActionEvent e) throws IOException {
        LoadScene.load(e, getClass().getResource("/fxml/view-client-fiche.fxml"));
    }

    @FXML protected void btnConfirmerClick(ActionEvent e) throws IOException {
        if(tbxLogin.getText().isBlank()
                || tbxIdEnt.getText().isBlank()
                || tbxNom.getText().isBlank()
                || tbxPrenom.getText().isBlank()
                || tbxMail.getText().isBlank()
                || tbxContacto_n.getText().isBlank()
                || tbxTelephone.getText().isBlank()
                || tbxEtatContact.getText().isBlank()){
            lblMessage.setText("Tout les champs ne sont pas complétés !");
        }
        else{
            ClientDTO unClient = new ClientDTO(tbxIdEnt.getText(), tbxLogin.getText(), tbxNom.getText(),  tbxPrenom.getText(),tbxContacto_n.getText(), tbxTelephone.getText(), tbxMail.getText(),tbxEtatContact.getText());
                if(FicheClientDAO.addFicheClient(unClient) != -1){
                    LoadScene.load(e, getClass().getResource("/fxml/view-client-fiche.fxml"));
                }
                else{
                    lblMessage.setText("Création de la fiche client impossible.");
                }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
