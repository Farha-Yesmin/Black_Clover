module com.temperatureconverter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.temperatureconverter to javafx.fxml;
    exports com.temperatureconverter;
}