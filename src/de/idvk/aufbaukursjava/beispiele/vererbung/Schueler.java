package de.idvk.aufbaukursjava.beispiele.vererbung;

public class Schueler extends Person {
    private String klasse;

    @Override
    public String toString() {
        return super.toString() + " und ein Schüler.";
    }
}
