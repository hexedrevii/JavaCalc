package xyz.itseve.javacalc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
    @FXML private TextField output;

    @FXML private void numberClick(ActionEvent event) {
        Button self = (Button)event.getSource();
        output.appendText(self.getText());
    }

    @FXML private void equalClick() {

    }

    @FXML private void clearClick() {
        output.clear();
    }
}
