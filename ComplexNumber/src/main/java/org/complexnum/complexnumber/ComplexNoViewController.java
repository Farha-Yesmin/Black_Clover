package org.complexnum.complexnumber;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;

public class ComplexNoViewController
{
    @javafx.fxml.FXML
    private Label result;
    @javafx.fxml.FXML
    private TextField real2;
    @javafx.fxml.FXML
    private TextField real1;
    @javafx.fxml.FXML
    private TextField img2;
    @javafx.fxml.FXML
    private TextField img1;
    ComplexNo c1,c2,c3;

    @javafx.fxml.FXML
    public void addOnAction(ActionEvent actionEvent) {
        c1 = new ComplexNo(Integer.parseInt(real1.getText()),
                Integer.parseInt(img1.getText()));
        c2 = new ComplexNo(Integer.parseInt(real2.getText()),
                Integer.parseInt(img2.getText()));
        c3 = c1.add(c2);
        result.setText(c3.toString());

        try{
            File file = new File("ComplexNo.txt");
            FileWriter fw = new FileWriter(file);
            fw.write(c1.toString()+"\n"+
                    c2.toString()+"\n"+
                    c3.toString());
            fw.close();
        }
        catch (Exception e){

        }

    }

    @javafx.fxml.FXML
    public void subtractOnAction(ActionEvent actionEvent) {
        c1 = new ComplexNo(Integer.parseInt(real1.getText()),
                Integer.parseInt(img1.getText()));
        c2 = new ComplexNo(Integer.parseInt(real2.getText()),
                Integer.parseInt(img2.getText()));
        c3 = c1.subtract(c2);
        result.setText(c3.toString());
    }

}