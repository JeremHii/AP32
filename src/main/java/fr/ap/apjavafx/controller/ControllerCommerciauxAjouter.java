package fr.ap.apjavafx.controller;

import fr.ap.apjavafx.libs.LoadScene;
import fr.ap.apjavafx.model.DAO.CommercialDAO;
import fr.ap.apjavafx.model.DAO.UtilisateurDAO;
import javafx.fxml.Initializable;

import fr.ap.apjavafx.model.DTO.CommercialDTO;
import fr.ap.apjavafx.model.DTO.UtilisateurDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCommerciauxAjouter extends ControllerBase implements Initializable {

    @FXML private TextField tbxLogin;
    @FXML private TextField tbxMdp;
    @FXML private TextField tbxNom;
    @FXML private TextField tbxPrenom;
    @FXML private TextField tbxMail;
    @FXML private TextField tbxAdresse;
    @FXML private TextField tbxTelephone;
    @FXML private TextField tbxInteressement;
    @FXML private Label lblMessage;

    @FXML protected void btnAnnulerClick(ActionEvent e) throws IOException {
        LoadScene.load(e, getClass().getResource("/fxml/view-commerciaux-liste.fxml"));
    }

    @FXML protected void btnConfirmerClick(ActionEvent e) throws IOException {
        if(tbxLogin.getText().isBlank()
        || tbxMdp.getText().isBlank()
        || tbxNom.getText().isBlank()
        || tbxPrenom.getText().isBlank()
        || tbxMail.getText().isBlank()
        || tbxAdresse.getText().isBlank()
        || tbxTelephone.getText().isBlank()
        || tbxInteressement.getText().isBlank()){
            lblMessage.setText("Tout les champs ne sont pas complétés !");
        }
        else{
            UtilisateurDTO utilisateur = new UtilisateurDTO(tbxLogin.getText());
            if(UtilisateurDAO.addUser(utilisateur, tbxMdp.getText()) != -1){
                CommercialDTO commercial = new CommercialDTO(utilisateur.getLogin(), tbxNom.getText(), tbxPrenom.getText(), tbxAdresse.getText(), tbxTelephone.getText(), tbxMail.getText(), tbxInteressement.getText());
                if(CommercialDAO.addCommercial(commercial) != -1){
                    LoadScene.load(e, getClass().getResource("/fxml/view-commerciaux-liste.fxml"));
                }
                else{
                    lblMessage.setText("Création du commercial impossible.");
                }
            }
            else{
                lblMessage.setText("Création de l'utilisateur impossible.");
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
