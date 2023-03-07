package de.idvk.aufbaukursjava.lambda;

import java.time.LocalDate;

/**
 * Basisklasse für Fahrzeuge
 */
public abstract class Fahrzeug implements Comparable<Fahrzeug> {

    /**
     * Verkaufspreis in Euro.
     */
    private final double preis;

    /**
     * Baujahr der des Fahrzeugs.
     */
    private final LocalDate baujar;

    /**
     * Verbrauch in l
     */
    private final double verbrauch;

    /**
     * Gesamtmasse in kilo.
     */
    private final double gesamtMasse;

    public Fahrzeug(double preis,
                    LocalDate baujar,
                    double verbrauch,
                    double gesamtMasse) {
        this.preis = preis;
        this.baujar = baujar;
        this.verbrauch = verbrauch;
        this.gesamtMasse = gesamtMasse;
    }

    public double getPreis() {
        return preis;
    }

    public LocalDate getBaujar() {
        return baujar;
    }

    public double getVerbrauch() {
        return verbrauch;
    }

    public double getGesamtMasse() {
        return gesamtMasse;
    }

    /**
     * Überschrieben!
     *
     * @see Comparable#compareTo(Object)
     **/
    @Override
    public int compareTo(Fahrzeug other) {
        int erg = getClass().getSimpleName().compareTo(other.getClass().getSimpleName());

        if (erg == 0) {
            erg = (int) (verbrauch - other.verbrauch);
        }

        return erg;
    }

}
