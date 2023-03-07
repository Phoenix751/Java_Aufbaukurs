package de.idvk.aufbaukursjava.beispiele.vererbung;

public class Lehrer extends Person {
    private String fach;

    @Override
    public String toString() {
        return super.toString() + " und ein Lehrer.";
    }
}
