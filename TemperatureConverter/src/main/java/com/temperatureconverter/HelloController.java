package com.temperatureconverter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField celciusTextField;
    @FXML
    private TextField fahrenheitTextField;

    @FXML
    public void convertCOnAction(ActionEvent actionEvent) {
        Temperature t = new Temperature();
        t.temperature = Double.parseDouble(fahrenheitTextField.getText());

        celciusTextField.setText(String.valueOf(t.convertToCelcius()));
    }

    @FXML
    public void convertFOnAction(ActionEvent actionEvent) {
        Temperature t = new Temperature();
        t.temperature = Double.parseDouble(celciusTextField.getText());

        fahrenheitTextField.setText(String.valueOf(t.convertToFahrenheit()));
    }

    @FXML
    public void clearOnAction(ActionEvent actionEvent) {
        fahrenheitTextField.clear();
        celciusTextField.clear();
    }
}