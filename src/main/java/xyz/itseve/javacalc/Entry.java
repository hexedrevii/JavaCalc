package xyz.itseve.javacalc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Entry extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load the GUI.
        FXMLLoader fxmlLoader = new FXMLLoader(Entry.class.getResource("calculator.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 350, 400);
        scene.setOnKeyPressed(keyEvent -> {
            // Calculate result when enter is pressed.
            if (keyEvent.getCode() == KeyCode.ENTER) {
                CalculatorController controller = fxmlLoader.getController();
                controller.getEqualsButton().fire();
            }
        });

        // Add CSS styles.
        scene.getStylesheets().add(
            Objects.requireNonNull(
                Entry.class.getResource("calculator.css")
            ).toExternalForm()
        );

        // Set window minimum size.
        stage.setMinHeight(400);
        stage.setMinWidth(350);

        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}