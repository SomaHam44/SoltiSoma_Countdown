module com.example.countdown {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.countdown to javafx.fxml;
    exports com.example.countdown;
}