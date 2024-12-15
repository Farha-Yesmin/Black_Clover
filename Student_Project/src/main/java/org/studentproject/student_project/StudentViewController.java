package org.studentproject.student_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class StudentViewController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TextField cgpaTextField;
    @javafx.fxml.FXML
    private TableColumn<Student, String> dobCol;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TableColumn<Student, String> majorCol;
    @javafx.fxml.FXML
    private TableColumn<Student, String> cgpaCol;
    @javafx.fxml.FXML
    private TableColumn<Student, String> genderCol;
    @javafx.fxml.FXML
    private CheckBox pythonCheckbox;
    @javafx.fxml.FXML
    private ComboBox<String> majorCombobox;
    @javafx.fxml.FXML
    private TableColumn<Student, String> idCol;
    @javafx.fxml.FXML
    private RadioButton femaleRadioButton;
    @javafx.fxml.FXML
    private CheckBox javaCheckbox;
    @javafx.fxml.FXML
    private TableColumn<Student, String> nameCol;
    @javafx.fxml.FXML
    private RadioButton maleRadioButton;
    @javafx.fxml.FXML
    private DatePicker dobDatePicker;
    @javafx.fxml.FXML
    private TableView<Student> studentInfoTableView;
    @javafx.fxml.FXML
    private TableColumn<Student, String> skillCol;
    @javafx.fxml.FXML
    private Label errorLabel;
    ArrayList<Student> studentList;
    ToggleGroup tg;
    @javafx.fxml.FXML
    private TextArea avgCgpaTexrArea;
    @javafx.fxml.FXML
    private TextField minimumcgpaTextField;

    @javafx.fxml.FXML
    public void initialize() {
        studentList = new ArrayList<>();

      //  idTextField.setEditable(false);

        tg = new ToggleGroup();
        maleRadioButton.setToggleGroup(tg);
        femaleRadioButton.setToggleGroup(tg);

        dobDatePicker.setValue(LocalDate.now());
        majorCombobox.getItems().addAll("CSE", "EEE", "BBA");

        idCol.setCellValueFactory(new PropertyValueFactory<Student,String>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        majorCol.setCellValueFactory(new PropertyValueFactory<Student,String>("major"));
        cgpaCol.setCellValueFactory(new PropertyValueFactory<Student,String>("cgpa"));
        genderCol.setCellValueFactory(new PropertyValueFactory<Student,String>("gender"));
        dobCol.setCellValueFactory(new PropertyValueFactory<Student,String>("dob"));
        skillCol.setCellValueFactory(new PropertyValueFactory<Student,String>("skills"));
    }

    @javafx.fxml.FXML
    public void addOnAction(ActionEvent actionEvent) {
        boolean digitFound = false;
        for (int i=0; i<nameTextField.getText().length(); i++ ) {
            if (nameTextField.getText().charAt(i) >= '0' &&
                    nameTextField.getText().charAt(i) <= '9') {
                digitFound = true;
            }
        }
        if (idTextField.getText().isEmpty() || nameTextField.getText().isEmpty() ||
            cgpaTextField.getText().isEmpty() || dobDatePicker.getValue().isAfter(LocalDate.now()) ||
            digitFound){
                errorLabel.setText("Fill up the form properly");
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setContentText("Fill up the form properly");
                errorAlert.show();
        }
        else{
                boolean sameName = false;
                for(Student s: studentInfoTableView.getItems()){
                    if(s.getName().equals(nameTextField.getText())){
                        sameName = true;
                    }
                }
                if(sameName){
                    errorLabel.setText("Same Name Found");
                }
                else{
                    errorLabel.setText("Student Added");
                    String gender = "";
                    if(maleRadioButton.isSelected()){
                        gender = "Male";
                    } else if (femaleRadioButton.isSelected()) {
                        gender = "Female";

                    }
                    ArrayList<String> skillSet = new ArrayList<String>();
                    if (javaCheckbox.isSelected() && pythonCheckbox.isSelected()){
                        skillSet.add("Java");
                        skillSet.add("Python");
                    } else if (javaCheckbox.isSelected()) {
                        skillSet.add("Java");
                    } else if (pythonCheckbox.isSelected()) {
                        skillSet.add("Python");
                    }

                   // Random r = new Random();
                 //   String id = String.format("%04d", r.nextInt(10000));
                  //  Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
                 //   confirmAlert.setContentText("Are you sure?");
                 //   confirmAlert.showAndWait().ifPresent(response->){
                  //      if(response== ButtonType.OK){
                   //         add student code
                 //       }
                 //   }

                    Student addedStudent = new Student(
                            Integer.parseInt(idTextField.getText()),
                            nameTextField.getText(),
                            majorCombobox.getValue(),
                            gender,
                            Arrays.toString(skillSet.toArray()),
                            Float.parseFloat(cgpaTextField.getText()),
                            dobDatePicker.getValue());

                    studentInfoTableView.getItems().add(addedStudent);
                    studentList.add(addedStudent);
                    nameTextField.clear();
                    idTextField.clear();
                    cgpaTextField.clear();
                    majorCombobox.setValue(null);
                    maleRadioButton.setSelected(false);
                    femaleRadioButton.setSelected(false);
                    pythonCheckbox.setSelected(false);
                    javaCheckbox.setSelected(false);


                }


        }

    }


    @javafx.fxml.FXML
    public void showOnAction(ActionEvent actionEvent) {
        studentInfoTableView.getItems().clear();
        for(Student s:studentList){
            if (s.getGender().equals("Male")){
                studentInfoTableView.getItems().add(s);
            }
        }
    }

    @javafx.fxml.FXML
    public void showAvgOnAction(ActionEvent actionEvent) {
        float cgpaSum = 0;
        for(Student s: studentInfoTableView.getItems()){
            cgpaSum = cgpaSum + s.getCgpa();
            float avg = cgpaSum/studentInfoTableView.getItems().size();
            avgCgpaTexrArea.setText("Average CGPA is: " + avg);
        }
    }

    @javafx.fxml.FXML
    public void ageSeniorOnAction(ActionEvent actionEvent) {
        ArrayList<Integer> ageList = new ArrayList<Integer>();
        for (Student s: studentInfoTableView.getItems()) {
            ageList.add(s.calculateAge());
        }
        int maxAge = ageList.get(0);
        for (int i=1; i<ageList.size(); i++){
            if (maxAge<ageList.get(i)){
                maxAge = ageList.get(i);
            }
        }
        String mostSeniorStuName = "";
        for(Student s:studentInfoTableView.getItems()){
            if(s.calculateAge()==maxAge){
                mostSeniorStuName = s.getName();
            }
        }
        avgCgpaTexrArea.setText("The age of the most senior student is " + maxAge + "\n" +
                "Student Name: " + mostSeniorStuName);
    }

    @javafx.fxml.FXML
    public void filterOnAction(ActionEvent actionEvent) {
        studentInfoTableView.getItems().clear();
        for(Student s:studentList){
            if(s.getCgpa()>=Float.parseFloat(minimumcgpaTextField.getText())){
                studentInfoTableView.getItems().add(s);
            }
        }
    }

    @javafx.fxml.FXML
    public void dummyViewDifferentWindowOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("dummy-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = new Stage();
            nextStage.setTitle("Dummy View");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void dummyViewSameWindowOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("dummy-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            currentStage.setTitle("Dummy View");
            currentStage.setScene(nextScene);
            currentStage.show();
        }
        catch(Exception e) {

        }
    }
}