package org.studentproject.student_project;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class LoadCourseInfoFromFileViewController
{
    @javafx.fxml.FXML
    private TableColumn<Course, String> typeCol;
    @javafx.fxml.FXML
    private TableColumn<Course, String> titleCol;
    @javafx.fxml.FXML
    private TableColumn<Course, String> titleCol2;
    @javafx.fxml.FXML
    private TableColumn<Course, String> idCol;
    @javafx.fxml.FXML
    private TableColumn<Course, String> idCol2;
    @javafx.fxml.FXML
    private TableColumn<Course, String> creditsCol2;
    @javafx.fxml.FXML
    private TableColumn<Course, String> typeCol2;
    @javafx.fxml.FXML
    private TableView<Course> courseInfoTableView2;
    @javafx.fxml.FXML
    private TableView<Course> courseInfoTableView1;
    @javafx.fxml.FXML
    private TableColumn<Course, String> creditsCol;

    @javafx.fxml.FXML
    public void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<Course, String>("courseID"));
        titleCol.setCellValueFactory(new PropertyValueFactory<Course, String>("title"));
        typeCol.setCellValueFactory(new PropertyValueFactory<Course, String>("type"));
        creditsCol.setCellValueFactory(new PropertyValueFactory<Course, String>("noOfCredits"));

        idCol2.setCellValueFactory(new PropertyValueFactory<Course, String>("courseID"));
        titleCol2.setCellValueFactory(new PropertyValueFactory<Course, String>("title"));
        typeCol2.setCellValueFactory(new PropertyValueFactory<Course, String>("type"));
        creditsCol2.setCellValueFactory(new PropertyValueFactory<Course, String>("noOfCredits"));

    }

    @javafx.fxml.FXML
    public void loadCourseFromBinFileOnAction(ActionEvent actionEvent) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            File f = new File("CourseInfo.bin");
            if (f.exists()){
                fis = new FileInputStream(f);
            }
            else{
                //
            }
            ois = new ObjectInputStream(fis);
            while(true){
                courseInfoTableView2.getItems().add((Course)ois.readObject());
            }
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void loadCourseFromTxtFileOnAction(ActionEvent actionEvent) {
        File f = new File("CourseInfo.txt");
        try{
            Scanner s = new Scanner(f);
            String str = "";
            String[] tokens;
            while(s.hasNextLine()){
                str = s.nextLine();
                tokens = str.split(",");
                Course c = new Course(tokens[0],tokens[1], tokens[2], Integer.parseInt(tokens[3]));
                courseInfoTableView1.getItems().add(c);
            }
        }
        catch (Exception e) {
            //
        }

    }
}