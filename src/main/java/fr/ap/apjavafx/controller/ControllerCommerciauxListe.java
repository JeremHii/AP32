package fr.ap.apjavafx.controller;

import fr.ap.apjavafx.libs.LoadScene;
import fr.ap.apjavafx.model.DTO.CommercialDTO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class ControllerCommerciauxListe extends ControllerBase implements Initializable {

    @FXML private TableView<CommercialDTO> tabCommerciaux;
    @FXML private TableColumn<CommercialDTO, String> tcLogin;
    @FXML private TableColumn<CommercialDTO, String> tcNom;
    @FXML private TableColumn<CommercialDTO, String> tcPrenom;
    @FXML private TableColumn<CommercialDTO, String> tcAdresse;
    @FXML private TableColumn<CommercialDTO, String> tcTelephone;
    @FXML private TableColumn<CommercialDTO, String> tcMail;
    @FXML private TableColumn<CommercialDTO, String> tcInteressement;

    @FXML private Button btnSupprimer;
    @FXML private Button btnModifier;

    private ObservableList<CommercialDTO> data = FXCollections.observableArrayList();
    private CommercialDTO commercialSelected = null;

    @FXML
    protected void btnNewCommercial(ActionEvent e) throws IOException {
        LoadScene.load(e, getClass().getResource("/fxml/view-commerciaux-ajouter.fxml"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tabCommerciaux.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CommercialDTO>() {
            @Override
            public void changed(ObservableValue<? extends CommercialDTO> observable, CommercialDTO oldValue, CommercialDTO newValue) {
                btnSupprimer.setDisable(false);
                btnModifier.setDisable(false);
                commercialSelected = newValue;
            }
        });

        data.addAll(CommercialDTO.getCommerciaux());

        tcLogin.setCellValueFactory(new PropertyValueFactory<CommercialDTO, String>("Login"));
        tcNom.setCellValueFactory(new PropertyValueFactory<CommercialDTO, String>("Nom"));
        tcPrenom.setCellValueFactory(new PropertyValueFactory<CommercialDTO, String>("Prenom"));
        tcAdresse.setCellValueFactory(new PropertyValueFactory<CommercialDTO, String>("Adresse"));
        tcTelephone.setCellValueFactory(new PropertyValueFactory<CommercialDTO, String>("Telephone"));
        tcMail.setCellValueFactory(new PropertyValueFactory<CommercialDTO, String>("Mail"));
        tcInteressement.setCellValueFactory(new PropertyValueFactory<CommercialDTO, String>("Pourcentinteressement"));

        tabCommerciaux.setItems(data);

    }

    @FXML public void btnSupprimerClick(ActionEvent actionEvent) throws IOException {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("COMMERCIAL", commercialSelected);
        LoadScene.load(actionEvent, getClass().getResource("/fxml/view-commerciaux-supprimer.fxml"), ControllerCommerciauxSupprimer.class, params);
    }

    @FXML public void btnModifierClick(ActionEvent actionEvent) {
    }
}
