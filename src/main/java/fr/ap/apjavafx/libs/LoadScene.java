package fr.ap.apjavafx.libs;

import fr.ap.apjavafx.controller.ControllerBase;
import fr.ap.apjavafx.controller.ControllerCommerciauxSupprimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.xml.transform.Source;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class LoadScene {
    public static void load(ActionEvent e, URL resource) throws IOException {
        load(e, resource, null);
    }

    public static <T extends ControllerBase> List<T> load(ActionEvent e, URL resource, HashMap<String, Object> params) throws IOException {
        FXMLLoader loader = new FXMLLoader(resource);
        Parent root = (Parent) loader.load();

        T controller = loader.<T>getController();

        if(params != null){
            controller.setParams(params);
            controller.loaded();
        }

        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(controller.getTitle());
        stage.show();

        return null;
    }
}
