package fr.ap.apjavafx;


import fr.ap.apjavafx.model.DAO.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	private Pane rootLayout;

	/*
	 * Chargement au lancement de l'application de le vue "view-connexion.fxml"
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/fxml/view-connexion.fxml"));
			rootLayout = loader.load();

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Connexion");

			//Chargement des objets de la BDD
			AdminDAO.createAdmins();
			ResponsableDAO.createResponsables();
			UtilisateurDAO.createUsers();
			CommercialDAO.createCommerciaux();
			ContacterDAO.createContacts();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
