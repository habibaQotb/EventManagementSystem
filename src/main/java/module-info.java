module com.example.eventmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.eventmanagement to javafx.fxml;
    exports com.example.eventmanagement;
}