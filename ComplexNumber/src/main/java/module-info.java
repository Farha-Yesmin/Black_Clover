module org.complexnum.complexnumber {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.complexnum.complexnumber to javafx.fxml;
    exports org.complexnum.complexnumber;
}