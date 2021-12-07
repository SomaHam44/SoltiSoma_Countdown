package com.example.countdown;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    public Label megadottIdopont;
    @FXML
    public Label hatralevoIdo;


    public void inditas(ActionEvent actionEvent) {


    }


    private void lejartAzIdo() {
        Alert alertAblak = new Alert(Alert.AlertType.NONE, "Lejárt az idő!", ButtonType.OK);
        alertAblak.setTitle("Amikor lejár az idő");
        alertAblak.show();
    }
}