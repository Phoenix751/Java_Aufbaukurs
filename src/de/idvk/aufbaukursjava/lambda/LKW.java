package de.idvk.aufbaukursjava.lambda;

import java.time.LocalDate;

public class LKW extends Fahrzeug {
    public LKW(double preis,
               LocalDate baujar,
               double verbrauch,
               double gesamtMasse) {
        super(preis, baujar, verbrauch, gesamtMasse);
    }
}
