package de.idvk.aufbaukursjava.lambda;

import java.time.LocalDate;

public class Motorrad extends Fahrzeug {
    public Motorrad(double preis,
                    LocalDate baujar,
                    double verbrauch,
                    double gesamtMasse) {
        super(preis, baujar, verbrauch, gesamtMasse);
    }
}
