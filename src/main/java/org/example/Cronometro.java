package org.example;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class Cronometro extends Thread {
    private volatile boolean running;
    private int horas, minutos, segundos;
    private Label tiempoLabel;

    public Cronometro(Label tiempoLabel) {
        this.running = false;
        this.horas = 0;
        this.minutos = 0;
        this.segundos = 0;
        this.tiempoLabel = tiempoLabel;
    }

    @Override
    public void run() {
        while (true) {
            if (running) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                segundos++;
                if (segundos == 60) {
                    segundos = 0;
                    minutos++;
                    if (minutos == 60) {
                        minutos = 0;
                        horas++;
                    }
                }
                Platform.runLater(() -> actualizarTiempoLabel());
            }
        }
    }

    public void iniciar() {
        running = true;
    }

    public void detener() {
        running = false;
    }

    public void reiniciar() {
        running = false;
        horas = 0;
        minutos = 0;
        segundos = 0;
        Platform.runLater(() -> tiempoLabel.setText("00:00:00"));
    }

    private void actualizarTiempoLabel() {
        String tiempo = String.format("%02d:%02d:%02d", horas, minutos, segundos);
        tiempoLabel.setText(tiempo);
    }
}