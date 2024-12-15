package org.studentproject.student_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class CreateNewCourseViewController
{
    @javafx.fxml.FXML
    private TextField titleTextField;
    @javafx.fxml.FXML
    private ComboBox<String> typeComboBox;
    @javafx.fxml.FXML
    private ComboBox<Integer> creditsComboBox;
    @javafx.fxml.FXML
    private TextField courseIDTextField;
    ArrayList<Course> courseList;
    @javafx.fxml.FXML
    public void initialize() {
        courseList = new ArrayList<>();
        creditsComboBox.getItems().addAll(1,3,4,6);
        typeComboBox.getItems().addAll("Core","Major","Minor","Foundation");
    }

    @javafx.fxml.FXML
    public void addOnAction(ActionEvent actionEvent){
        courseList.add(new Course(
                courseIDTextField.getText(),
                titleTextField.getText(),
                typeComboBox.getValue(),
                creditsComboBox.getValue())
        );
        courseIDTextField.clear();
        titleTextField.clear();
    }

    @javafx.fxml.FXML
    public void saveCourseListTextFileOnAction(ActionEvent actionEvent) {
        FileWriter fw = null;
        File f = new File("CourseInfo.txt");
        try {
            if(f.exists()){
                fw = new FileWriter(f,true); //true means append
            }
            else{
                fw = new FileWriter(f); //by default false means new file add
            }
            String str = "";
            for(Course c: courseList){
                str += c.toString("for file");
            }
            fw.write(str);
            fw.close();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void saveCourseListBinaryFileOnAction(ActionEvent actionEvent) {
        File f = new File("CourseInfo.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
           if (f.exists()){
               fos = new FileOutputStream(f,true);
               oos = new AppendableObjectOutputStream(fos);
           }
           else{
               fos = new FileOutputStream(f);
               oos = new ObjectOutputStream(fos);
           }
           for(Course c: courseList){
               oos.writeObject(c);
           }
           oos.close();
        }
        catch (Exception e){
            //
        }

    }

    @javafx.fxml.FXML
    public void goToLoadCourseInfoOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("loadCourseInfoFromFile-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = new Stage();
            nextStage.setTitle("Course Info");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e) {
//
        }
    }

    @javafx.fxml.FXML
    public void viewCourseInfoSamePageOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("loadCourseInfoFromFile-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            currentStage.setTitle("Course Info");
            currentStage.setScene(nextScene);
            currentStage.show();
        }
        catch(Exception e) {
//
        }
    }
}