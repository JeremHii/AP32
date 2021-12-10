package fr.ap.apjavafx.controller;

import fr.ap.apjavafx.libs.LoadScene;
import fr.ap.apjavafx.model.DAO.CommercialDAO;
import fr.ap.apjavafx.model.DAO.UtilisateurDAO;
import fr.ap.apjavafx.model.DTO.CommercialDTO;
import fr.ap.apjavafx.model.DTO.UtilisateurDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCommerciauxModifier extends ControllerBase implements Initializable {

    @FXML private TextField tbxNom;
    @FXML private TextField tbxPrenom;
    @FXML private TextField tbxMail;
    @FXML private TextField tbxAdresse;
    @FXML private TextField tbxTelephone;
    @FXML private TextField tbxInteressement;
    @FXML private Label lblMessage;

    @FXML protected void btnRetourClick(ActionEvent e) throws IOException {
        LoadScene.load(e, getClass().getResource("/fxml/view-commerciaux-liste.fxml"));
    }

    @FXML protected void btnConfirmerClick(ActionEvent e) throws IOException {
        if(tbxNom.getText().isBlank()
        || tbxPrenom.getText().isBlank()
        || tbxMail.getText().isBlank()
        || tbxAdresse.getText().isBlank()
        || tbxTelephone.getText().isBlank()
        || tbxInteressement.getText().isBlank()){
            lblMessage.setText("Tout les champs ne sont pas complétés !");
        }
        else{
            CommercialDTO commercial = (CommercialDTO) getParam("COMMERCIAL");
            commercial.setNom(tbxNom.getText());
            commercial.setPrenom(tbxPrenom.getText());
            commercial.setMail(tbxMail.getText());
            commercial.setAdresse(tbxAdresse.getText());
            commercial.setTelephone(tbxTelephone.getText());
            commercial.setPourcentinteressement(tbxInteressement.getText());
            if(CommercialDAO.updateCommercial(commercial) != -1){
                lblMessage.setText("Commercial modifié.");
            }
            else{
                lblMessage.setText("Modification du commercial impossible.");
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tbxNom.getScene();
    }

    @Override
    public void loaded() {
        CommercialDTO commercial = (CommercialDTO) getParam("COMMERCIAL");
        tbxNom.setText(commercial.getNom());
        tbxPrenom.setText(commercial.getPrenom());
        tbxMail.setText(commercial.getMail());
        tbxAdresse.setText(commercial.getAdresse());
        tbxTelephone.setText(commercial.getTelephone());
        tbxInteressement.setText(commercial.getPourcentinteressement());
    }
}
