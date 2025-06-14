package xyz.itseve.javacalc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Entry extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load the GUI.
        FXMLLoader fxmlLoader = new FXMLLoader(Entry.class.getResource("calculator.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();

        // stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }
}