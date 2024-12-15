module org.gpa.gpacalculate {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.gpa.gpacalculate to javafx.fxml;
    exports org.gpa.gpacalculate;
}