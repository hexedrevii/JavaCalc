package xyz.itseve.javacalc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import xyz.itseve.shuntingyard.ArithmeticExpression;

public class CalculatorController {
    @FXML private TextField output;

    @FXML private void numberClick(ActionEvent event) {
        Button self = (Button)event.getSource();
        output.appendText(self.getText());
    }

    @FXML private void equalClick() {
        String math = output.getText();
        try {
            ArithmeticExpression expr = new ArithmeticExpression(math);
            output.setText("" + expr.evaluate());
        } catch (Exception e) {
            output.setText("Mathematical error.");
        }
    }

    @FXML private void clearClick() {
        output.clear();
    }
}
