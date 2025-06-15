package xyz.itseve.javacalc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import xyz.itseve.shuntingyard.ArithmeticExpression;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {
    private boolean nextDelete = false;
    private int caret = 0;

    @FXML private TextField output;

    @FXML private Button equalsButton;
    public Button getEqualsButton() {
        return equalsButton;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        output.caretPositionProperty().addListener(
            (obs, oldPos, newPos) -> {
                caret = newPos.intValue();
            }
        );
    }

    @FXML private void inputChanged() {
        if (nextDelete) {
            output.clear();
            nextDelete = false;
        }
    }

    @FXML private void numberClick(ActionEvent event) {
        if (nextDelete) {
            output.clear();
            nextDelete = false;
        }

        Button self = (Button)event.getSource();
        output.insertText(caret, self.getText());
    }

    @FXML private void equalClick() {
        String math = output.getText();
        try {
            ArithmeticExpression expr = new ArithmeticExpression(math);
            output.setText("" + expr.evaluate());
        } catch (Exception e) {
            output.setText("Mathematical error.");

            nextDelete = true;
        }
    }

    @FXML private void delClick() {
        if (nextDelete) {
            output.clear();
            nextDelete = false;

            return;
        }

        String text = output.getText();
        if (!output.getText().isEmpty()) {
            String cut = (text.substring(0, text.length() - 1));
            output.setText(cut);

            output.positionCaret(output.getText().length());
        }
    }

    @FXML private void clearClick() {
        output.clear();
        if (nextDelete) nextDelete = false;
    }
}
