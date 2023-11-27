package org.example;

;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class CronometroController {
    @FXML
    private Label tiempoLabel;
    @FXML
    private Button iniciarBtn;
    @FXML
    private Button detenerBtn;
    @FXML
    private Button reiniciarBtn;

    private Cronometro cronometro;

    @FXML
    public void initialize() {
        cronometro = new Cronometro(tiempoLabel);
        cronometro.start();
    }

    @FXML
    public void iniciarCronometro() {
        cronometro.iniciar();
    }

    @FXML
    public void detenerCronometro() {
        cronometro.detener();
    }

    @FXML
    public void reiniciarCronometro() {
        cronometro.reiniciar();
    }
}