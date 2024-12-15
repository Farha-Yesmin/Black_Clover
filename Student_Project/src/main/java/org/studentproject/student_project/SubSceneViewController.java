package org.studentproject.student_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SubSceneViewController {

    @FXML
    private BorderPane stageBorderPane;

    @FXML
    void option1OnAction(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("option1-view.fxml"));
            stageBorderPane.setCenter(fxmlLoader.load());
        }
        catch(Exception e) {
//
        }

    }

    @FXML
    void option2OnAction(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("option2-view.fxml"));
            stageBorderPane.setCenter(fxmlLoader.load());
        }
        catch(Exception e) {
//
        }
    }

    @FXML
    void option3OnAction(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("option3-view.fxml"));
            stageBorderPane.setCenter(fxmlLoader.load());
        }
        catch(Exception e) {
//
        }
    }

}
