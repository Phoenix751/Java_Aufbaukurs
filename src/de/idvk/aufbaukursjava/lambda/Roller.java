package de.idvk.aufbaukursjava.lambda;

import java.time.LocalDate;

public class Roller extends Fahrzeug {
    public Roller(double preis,
                  LocalDate baujar,
                  double verbrauch,
                  double gesamtMasse) {
        super(preis, baujar, verbrauch, gesamtMasse);
    }
}
