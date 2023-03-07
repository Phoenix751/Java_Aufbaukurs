/*
 * Copyright (c) 2017 Statistisches Bundesamt
 */
package de.idvk.aufbaukursjava.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * Main-Klasse für Übung zu lambdas
 */
public class Lambda {


    /**
     * start ...
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Fahrzeug> geraete = new ArrayList<>();

        geraete.add(new Auto(15000, LocalDate.of(2015, 2, 5), 6.9, 2764));
        geraete.add(new Auto(8000, LocalDate.of(2006, 2, 5), 4.6, 1723));
        geraete.add(new Auto(12000, LocalDate.of(2018, 2, 5), 5.8, 2487));
        geraete.add(new Motorrad(9000, LocalDate.of(2020, 1, 1), 4.3, 350));
        geraete.add(new Motorrad(12000, LocalDate.of(2021, 2, 24), 5.2, 450));
        geraete.add(new LKW(120000, LocalDate.of(2005, 2, 24), 30.5, 40000));
        geraete.add(new LKW(200000, LocalDate.of(2010, 2, 24), 29.4, 40000));
        geraete.add(new LKW(300000, LocalDate.of(2022, 2, 24), 32.6, 40000));
        geraete.add(new Wohnmobil(90000, LocalDate.of(2018, 3, 15), 12.4, 3200));
        geraete.add(new Roller(1200, LocalDate.of(2023, 1, 15), 2.2, 120));
        geraete.add(new Roller(800, LocalDate.of(2018, 1, 15), 3.9, 170));
        geraete.add(new Roller(1000, LocalDate.of(2021, 1, 15), 2.8, 150));
        geraete.add(new Roller(999, LocalDate.of(2019, 1, 15), 2.7, 200));

        // Hinweis jeder Stream muss mit einer "terminal operations" enden.
        // Zum Beispiel  average, sum, min, max, count, reduce und collect


        geraete.stream().forEach(System.out::println);
        // TODO geben Sie das Gewicht aller Fahrzeuge aus.


        System.out.println();

        // TODO Geben Sie die Fahrzeuge sortiert aus (Methode compare in Geräte-Klasse bereits vorhanden).
        // ...

        System.out.println();

        // TODO geben Sie das Gewicht aller Fahrzeuge sortiert aus.
        // ...
        System.out.println();

        // TODO geben Sie das Fahrzeug mit dem höchsten Verbrauch aus.
        // ...


        System.out.println();

        // TODO Geben Sie den Gesamtverbrauch aller Geräte, ohne die LKW aus
        // ...
        System.out.println();

        System.out.println();

        // TODO das durchschnittsalter aller Fahrzeuge die mehr als 5 l/100km verbrauchen
        // ...

    }

}
