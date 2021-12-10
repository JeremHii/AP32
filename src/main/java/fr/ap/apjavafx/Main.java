package fr.ap.apjavafx;


import fr.ap.apjavafx.model.DAO.AdminDAO;
import fr.ap.apjavafx.model.DAO.CommercialDAO;
import fr.ap.apjavafx.model.DAO.ResponsableDAO;
import fr.ap.apjavafx.model.DAO.UtilisateurDAO;
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
			System.out.println(loader.getLocation());
			rootLayout = loader.load();

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("GSB Gestion des frais - Compta Fiche de frais");

			//Chargement des objets de la BDD
			AdminDAO.createAdmins();
			ResponsableDAO.createResponsables();
			UtilisateurDAO.createUsers();
			CommercialDAO.createCommerciaux();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
