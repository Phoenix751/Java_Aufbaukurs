package de.idvk.aufbaukursjava.lambda;

import java.time.LocalDate;

public class Auto extends Fahrzeug {
    public Auto(double preis,
                LocalDate baujar,
                double verbrauch,
                double gesamtMasse) {
        super(preis, baujar, verbrauch, gesamtMasse);
    }
}
