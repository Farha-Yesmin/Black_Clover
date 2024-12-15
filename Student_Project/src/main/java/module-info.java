module org.studentproject.student_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.studentproject.student_project to javafx.fxml;
    exports org.studentproject.student_project;
}