module com.example.convert {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.convert to javafx.fxml;
    exports com.example.convert;
}