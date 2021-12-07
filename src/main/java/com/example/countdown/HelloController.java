package com.example.countdown;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class HelloController {
    @FXML
    public TextField megadottIdopont;
    @FXML
    public Label hatralevoIdo;


    public void inditas(ActionEvent actionEvent) {
        String bekertIdo = megadottIdopont.getText();
        LocalDateTime idopont = LocalDateTime.parse(bekertIdo, DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
        Period datum = Period.between(LocalDate.now(), idopont.toLocalDate());
        Duration idopontokKozott = Duration.between(LocalDateTime.now(), idopont);



    }


    private void lejartAzIdo() {
        Alert alertAblak = new Alert(Alert.AlertType.NONE, "Lejárt az idő!", ButtonType.OK);
        alertAblak.setTitle("Amikor lejár az idő");
        alertAblak.show();
    }
}