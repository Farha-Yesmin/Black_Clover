package org.gpa.gpacalculate;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GpaViewController
{
    @javafx.fxml.FXML
    private TextField course3credit;
    @javafx.fxml.FXML
    private TextField course1gpa;
    @javafx.fxml.FXML
    private TextField course2gpa;
    @javafx.fxml.FXML
    private TextField course1credit;
    @javafx.fxml.FXML
    private TextField course3gpa;
    @javafx.fxml.FXML
    private Label gpaLabel;
    @javafx.fxml.FXML
    private TextField course2credit;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TextField idTextField;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void calculateGPAOnAction(ActionEvent actionEvent) {
        Student s = new Student();
        s.name = nameTextField.getText();
        s.id = Integer.parseInt(idTextField.getText());

        s.creditArr[0] = Integer.parseInt(course1credit.getText());
        s.creditArr[1] = Integer.parseInt(course2credit.getText());
        s.creditArr[2] = Integer.parseInt(course3credit.getText());

        s.gradeArr[0] = Double.parseDouble(course1gpa.getText());
        s.gradeArr[1] = Double.parseDouble(course2gpa.getText());
        s.gradeArr[2] = Double.parseDouble(course3gpa.getText());

        double gpa = s.gpaCalculate();
        gpaLabel.setText(s.name + "'s GPA is " + gpa);


    }
}