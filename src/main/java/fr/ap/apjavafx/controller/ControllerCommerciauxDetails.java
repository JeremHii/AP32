package fr.ap.apjavafx.controller;

import fr.ap.apjavafx.libs.LoadScene;
import fr.ap.apjavafx.model.DTO.CommercialDTO;
import fr.ap.apjavafx.model.DTO.ContacterDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCommerciauxDetails extends ControllerBase implements Initializable {


    @FXML private ComboBox cbxAnnee;
    @FXML private ComboBox cbxMois;

    private int selectedYear;
    private CommercialDTO commercial;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbxMois.setDisable(true);
    }

    @Override
    public void loaded() {
        commercial = (CommercialDTO) getParam("COMMERCIAL");
        setTitle("Statistiques de " + commercial.getPrenom() + " " + commercial.getNom());

        for(int year : ContacterDTO.getYearsActivityCommercial(commercial)){
            cbxAnnee.getItems().add(year);
        }
    }

    @FXML
    public void btnRetourClick(ActionEvent e) throws IOException {
        LoadScene.load(e, getClass().getResource("/fxml/view-commerciaux-liste.fxml"));
    }

    @FXML
    public void cbxAnneeChanged(ActionEvent e) {
        selectedYear = (int)cbxAnnee.getValue();

        cbxMois.getItems().clear();
        for(int month : ContacterDTO.getMonthsActivityCommercial(commercial, selectedYear)){
            cbxMois.getItems().add(month);
        }

        cbxMois.setDisable(false);
    }

    @FXML
    public void cbxMoisChanged(ActionEvent e) {
    }
}
