package de.idvk.aufbaukursjava.beispiele.vererbung;

public class Main {
    public static void main(String[] args) {
        Person[] personen = new Person[3];

        personen[0] = new Person();
        personen[1] = new Lehrer();
        personen[2] = new Schueler();

        for (Person p : personen) {
            System.out.println(p);
        }
    }
}
