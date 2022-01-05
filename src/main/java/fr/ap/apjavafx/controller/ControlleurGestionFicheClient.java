package fr.ap.apjavafx.controller;

import fr.ap.apjavafx.libs.LoadScene;
import fr.ap.apjavafx.model.DAO.FicheClientDAO;
import fr.ap.apjavafx.model.DTO.FicheClientDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;


public class ControlleurGestionFicheClient extends ControllerBase implements Initializable {



    /**
     * Les variables du fichier FXML associé
     */
    @FXML 	private TableView<FicheClientDTO> tableGestionFicheClient;

    @FXML 	private TableColumn<FicheClientDTO,String> colIdNomEntreprise;
    @FXML 	private TableColumn<FicheClientDTO,String> colIdAdresse;
    @FXML 	private TableColumn<FicheClientDTO,String> colIdVillePays;
    @FXML   private TableColumn<FicheClientDTO,String> colIdNumTel;
    @FXML   private TableColumn<FicheClientDTO,String> colIdAdresseContact;
    @FXML   private TableColumn<FicheClientDTO,String> colIdEtatContact;
    @FXML   private TableColumn<FicheClientDTO,String> colidMailEntreprise;
    @FXML   private TableColumn<FicheClientDTO,String> colidtelContact;
    @FXML   private TableColumn<FicheClientDTO,String> colIdNomPrenomDuContact;
    @FXML   private Button closeButtonGestionFicheClient;

    @FXML
    protected void btnNewFicheClient(ActionEvent e) throws IOException {
        LoadScene.load(e, getClass().getResource("/fxml/view-fiche-client-ajouter.fxml"));
    }


    //Déclaration de l'ObservableList nécessaire au remplissage de la tableView
    private ObservableList<FicheClientDTO> data = FXCollections.observableArrayList();

    /**
     * Ouverture de la fiche sélectionnée
     * Click sur le bouton "Ouvrir fiche sélectionnée"
     * @param
     */
    @FXML
    private void buttonOuvrirFicheClientClick(ActionEvent e) {


    }



    /**
     * Remplissage le la tableView "liste des fiches de clients"
     */
    private void remplissagetableGestionFicheClient() {
        try {

            ResultSet rsListeFicheClient = FicheClientDAO.lesFichesClients();



            while (rsListeFicheClient.next()) {

                FicheClientDTO uneFicheClient = new FicheClientDTO(
                        rsListeFicheClient.getString(1),
                        rsListeFicheClient.getString(2),
                        rsListeFicheClient.getString(3),
                        rsListeFicheClient.getString(4),
                        rsListeFicheClient.getString(5),
                        rsListeFicheClient.getString(6),
                        rsListeFicheClient.getString(7),
                        rsListeFicheClient.getString(8),
                        rsListeFicheClient.getString(9));

                data.add(uneFicheClient);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        colIdNomEntreprise.setCellValueFactory(new PropertyValueFactory<FicheClientDTO,String>("NomEntreprise"));
        colIdAdresse.setCellValueFactory(new PropertyValueFactory<FicheClientDTO,String>("adresseEntreprise"));
        colIdVillePays.setCellValueFactory(new PropertyValueFactory<FicheClientDTO,String>("vilePays"));
        colIdNumTel.setCellValueFactory(new PropertyValueFactory<FicheClientDTO,String>("telEntreprise"));
        colidMailEntreprise.setCellValueFactory(new PropertyValueFactory<FicheClientDTO,String>("emailEntreprise"));
        colIdNomPrenomDuContact.setCellValueFactory(new PropertyValueFactory<FicheClientDTO,String>("nomPrenomContacts"));
        colIdEtatContact.setCellValueFactory(new PropertyValueFactory<FicheClientDTO,String>("etatContact"));
        colIdAdresseContact.setCellValueFactory(new PropertyValueFactory<FicheClientDTO,String>("mailContact"));
        colidtelContact.setCellValueFactory(new PropertyValueFactory<FicheClientDTO,String>("telContact"));

        tableGestionFicheClient.setItems(data);
    }





    /**
     * Fermeture de la vue
     * @param e
     */
    @FXML protected void closeGestionFicheClient(ActionEvent e) {
        Stage stage = (Stage) closeButtonGestionFicheClient.getScene().getWindow();
        stage.close();
    }

    /**
     * Appel de la fonction de remplissage de la tableView "liste des fiches"
     * initialisation de la vue
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        remplissagetableGestionFicheClient();
    }

}
