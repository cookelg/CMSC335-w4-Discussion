package com.cookelg;

import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextFormatter;

public class App extends Application {
    private TextField tfInputDouble = new TextField();

    @Override
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();
        // textFormatter property inherits from TextInputControl. Every time a character
        // is typed, the whole string from the input field is checked against the regex.
        // if the input does not match the format of a decimal number, it is ignored.
        tfInputDouble.setTextFormatter(new TextFormatter<String>(change -> {
            if (change.getControlNewText().matches("-?\\d*(\\.\\d*)?")) {
                return change;
            }
            return null;
        }));
        Label output = new Label();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Input a decimal number"), 0, 0);
        gridPane.add(tfInputDouble, 1, 0);
        gridPane.add(output, 1, 1);
        // Add a listenter that updates the output label after every key stroke
        tfInputDouble.textProperty()
                .addListener(
                        // process each key-press
                        (obs, oldText, newText) -> output.setText("Double Precision Float Binary: " + binaryString()));
        Scene scene = new Scene(gridPane, 400, 250);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private String binaryString() {
        // input text field gets input into a Double object
        Double input = Double.valueOf(tfInputDouble.getText());
        // Double's static method outputs a long type representation of the bits
        long bits = Double.doubleToRawLongBits(input.doubleValue());
        // Long has a pre-built static method to display binary string. by default,
        // the output does not pad zeroe, e.g. 1.0 would output only 62 bits vice 64.
        // Formatted string with 64 slots for characters, with the space character
        // replaced with 0's'
        String s = String.format("%64s", Long.toBinaryString(bits)).replace(' ', '0');
        // seperate sign bit, exponent, and mantissa with a space character
        return s.substring(0, 1) + " " + s.substring(1, 12) + " " + s.substring(12);
    }

}
