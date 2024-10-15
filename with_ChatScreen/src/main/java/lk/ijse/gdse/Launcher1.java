package lk.ijse.gdse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Launcher1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            Scene scene1 = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/serverPage.fxml"))));
            stage.setScene(scene1);
            stage.setTitle("Server Page");
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            System.err.println("Error loading FXML: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
