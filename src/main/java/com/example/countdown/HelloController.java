package com.example.countdown;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.DataFormatException;

public class HelloController {
    @FXML
    public TextField megadottIdopont;
    @FXML
    public Label hatralevoIdo;
    @FXML
    public Button inditosGomb;
    private Timer datumIdoTimer;
    private boolean megnyomniAGombot;


    public void inditas(ActionEvent actionEvent) {
        String bekertIdo = megadottIdopont.getText();
        try {
            LocalDateTime idopont = LocalDateTime.parse(bekertIdo, DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
            Period datum = Period.between(LocalDate.now(), idopont.toLocalDate());
            Duration idopontokKozott = Duration.between(LocalDateTime.now(), idopont);
            if (!datum.isNegative() || !idopontokKozott.isNegative()) {
                megnyomniAGombot = false;
                datumIdoTimer = new Timer();
                TimerTask timerTaskunk = new TimerTask() {
                    @Override
                    public void run() {
                        Period datum = Period.between(LocalDate.now(), idopont.toLocalDate());
                        Duration idopontokKozott = Duration.between(LocalDateTime.now(), idopont);
                        int evunk = datum.getYears();
                        int honapunk = datum.getMonths();
                        int napunk = datum.getDays();
                        int orank = idopontokKozott.toHoursPart();
                        int percunk = idopontokKozott.toMinutesPart();
                        int masodpercunk = idopontokKozott.toSecondsPart();
                        Platform.runLater(() -> hatralevoIdo.setText(evunk + " év " + honapunk + " hó " +
                                napunk + " nap " + "0" + orank + ":" + "0" + percunk + ":" + "0" + masodpercunk));
                        if (evunk == 0 && honapunk == 0 && napunk == 0 && orank == 0 && percunk == 0 && masodpercunk == 0) {
                            datumIdoTimer.cancel();
                            Platform.runLater(()->lejartAzIdo());
                            megnyomniAGombot = true;
                            Platform.runLater(() -> inditosGomb.setText("Indít"));
                        }
                    }

                };
                datumIdoTimer.schedule(timerTaskunk,1 ,1 );

            }
            else {
                hatralevoIdo.setText("A dátum vagy idő nem lehet negatív szám!");
            }
        }
        catch (DateTimeException e) {
            hatralevoIdo.setText("Nem megfelelő időpont!");

        }




    }


    private void lejartAzIdo() {
        Alert alertAblak = new Alert(Alert.AlertType.NONE, "Lejárt az idő!", ButtonType.OK);
        alertAblak.setTitle("Amikor lejár az idő");
        alertAblak.show();
    }
}