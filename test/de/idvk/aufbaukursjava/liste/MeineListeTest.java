package de.idvk.aufbaukursjava.liste;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MeineListeTest {

    private MeineListe<Integer> liste;

    @BeforeEach
    public void beforeEach() {
        liste = new MeineListe<>();
    }

    @Test
    public void addTest() {
        liste.add(42);
        assertEquals("[42]", liste.toString());
        liste.add(86);
        assertEquals("[42,86]", liste.toString());
    }

    @Test
    public void containsTest() {
        liste.add(42);
        liste.add(86);
        liste.add(420);
        liste.add(78);
        liste.add(54);
        liste.add(10);
        liste.add(111);

        //Standard Fall
        assertTrue(liste.contains(420));
        //Randbedingung Anfang der Liste
        assertTrue(liste.contains(42));
        //Randbedingung Ende der Liste
        assertTrue(liste.contains(111));

        //Nicht in der Liste enthalten
        assertFalse(liste.contains(123));
    }

    @Test
    public void removeTest() {
        liste.add(42);
        liste.add(86);
        liste.add(420);
        liste.add(78);
        liste.add(54);
        liste.add(10);
        liste.add(111);

        //Standard Fall
        assertTrue(liste.remove(86));
        //Randfall Anfang der Liste
        assertTrue(liste.remove(42));
        //Randfall Ende der Liste
        assertTrue(liste.remove(111));

        //Nicht in der Liste enthalten
        assertFalse(liste.remove(123));


    }


}
