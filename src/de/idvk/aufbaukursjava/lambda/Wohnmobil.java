package de.idvk.aufbaukursjava.lambda;

import java.time.LocalDate;

public class Wohnmobil extends Fahrzeug {
    public Wohnmobil(double preis,
                     LocalDate baujar,
                     double verbrauch,
                     double gesamtMasse) {
        super(preis, baujar, verbrauch, gesamtMasse);
    }
}
