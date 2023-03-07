package de.idvk.aufbaukursjava.beispiele.giblaut;

public class Main {
    public static void main(String[] args) {
        Tier[] tiere = new Tier[3];

        tiere[0] = new Fisch();
        tiere[1] = new Hund();
        tiere[2] = new Katze();

        for (Tier tier : tiere) {
            tier.gibLaut();
        }

    }
}
