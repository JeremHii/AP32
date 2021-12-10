package fr.ap.apjavafx.controller;

import fr.ap.apjavafx.Main;
import fr.ap.apjavafx.libs.LoadScene;
import fr.ap.apjavafx.model.DAO.*;
import fr.ap.apjavafx.model.DTO.UtilisateurDTO;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControllerIdentification extends ControllerBase implements Initializable {
	

	/**
	 * Les variables du fichier FXML associ�
	 */
	@FXML private Label messageConnexionLabel;
	@FXML private TextField loginTextField;
	@FXML private PasswordField mdpPasswordField;
	
	
	/**
	 * M�thode associ�e � l'�v�nement click sur le bouton valider
	 * @param e
	 */
	@FXML	protected void buttonValiderIdentificationClick(ActionEvent e) {
		//Chargement des diff�rentes vues en fonction du statut de la personne authentifi�e.
		ResultSet rs = UtilisateurDAO.getUserByCredentials(loginTextField.getText(), mdpPasswordField.getText());
		try {
			if(rs.next()){
				UtilisateurDTO utilisateur = UtilisateurDTO.getUtilisateur(loginTextField.getText());
				if(utilisateur.getFonction().equals("ADMIN") || utilisateur.getLogin().equals("RESPONSABLE")){
					LoadScene.load(e, getClass().getResource("/fxml/view-commerciaux-liste.fxml"));
				}
				else{
					messageConnexionLabel.setText("Vous n'avez pas la permission d'accèder à cette page.");
				}
			}
		} catch (SQLException | IOException throwables) {
			throwables.printStackTrace();
		}
	}

	/**
	 * Fermeture de l'application associ�e au click sur le boton quitter
	 * @param e
	 */
	@FXML
	protected void quitterIdentificationButton(ActionEvent e) {
		Platform.exit();
		
	}

	/**
	 * Valeurs par d�faut pour la connexion au SGBD
	 * A l'inicilisation du contr�leur 
	 ***/
	@Override
	public void initialize(URL location , ResourceBundle ressources) {
		loginTextField.setText("jeremy");
		mdpPasswordField.setText("1234");
	}
	
	

}
