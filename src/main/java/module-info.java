module com.example.checkboxes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.checkboxes to javafx.fxml;
    exports com.example.checkboxes;
}