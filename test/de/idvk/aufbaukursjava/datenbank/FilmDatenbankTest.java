package de.idvk.aufbaukursjava.datenbank;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class FilmDatenbankTest {
    private static String url = "jdbc:sqlite:/home/bk051934/Projects/Aufbaukurs_Java/FilmDatenbankTest.sqlite";
    private static Datenbank db;

    @BeforeAll
    public static void prepare() throws SQLException {
        db = new FilmDatenbank(url);
    }

    @BeforeEach
    public void beforeEach() throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        connection.prepareStatement("DELETE FROM Film").execute();
        connection.prepareStatement("DELETE FROM Regie").execute();
        connection.prepareStatement("UPDATE sqlite_sequence SET seq=0").execute();
        connection.close();

        var r1 = new Regie("Peter Jackson");
        var r2 = new Regie("Stanley Kubrik");
        var r3 = new Regie("James Cameron");
        r1.setId(1);
        r2.setId(2);
        r3.setId(3);

        var regie = new ArrayList<>(List.of(r1, r2, r3));

        var f1 = new Film("Der Herr der Ringe: Die Gefährten", 218, r1, LocalDate.parse("2001-12-10"));
        var f2 = new Film("Full Metal Jacket", 116, r2, LocalDate.parse("1987-06-26"));
        var f3 = new Film("Shining", 143, r2, LocalDate.parse("1980-05-23"));
        var f4 = new Film("A Clockwork Orange", 131, r2, LocalDate.parse("1972-03-23"));
        var f5 = new Film("Avatar", 178, r3, LocalDate.parse("2009-12-17"));

        f1.setId(1);
        f2.setId(2);
        f3.setId(3);
        f4.setId(4);
        f5.setId(5);

        var filme = new ArrayList<>(List.of(f1, f2, f3, f4, f5));

        regie.forEach(db::createRegie);
        filme.forEach(db::createFilm);

    }


    @Test
    public void readFilmById() {
        Film f = db.readFilmById(1);
        assertEquals(1, f.getId());
        assertEquals(
                "Film{id=1, title='Der Herr der Ringe: Die Gefährten', spielzeit=218, regie=Regie{id=1, name='Peter Jackson'}, veroeffentlichung=2001-12-10}",
                f.toString()
                    );
    }

    @Test
    public void readRegieById() {
        Regie r = db.readRegieById(2);
        assertEquals(2, r.getId());
        assertEquals("Regie{id=2, name='Stanley Kubrik'}", r.toString());
    }

    @Test
    public void readAlleFilme() {
        List<Film> alle = db.readAlleFilme();
        assertEquals(5, alle.size());
        assertEquals(
                "Film{id=5, title='Avatar', spielzeit=178, regie=Regie{id=3, name='James Cameron'}, veroeffentlichung=2009-12-17}",
                alle.get(4).toString()
                    );
    }

    @Test
    public void createFilm() {
        Regie r = db.readRegieById(1);
        Film neuerFilm = new Film("Der Hobbit: Eine unerwartete Reise", 182, r, LocalDate.parse("2012-11-28"));
        db.createFilm(neuerFilm);
        assertNotEquals(-1, neuerFilm.getId());
    }

    @Test
    public void createRegie() {
        Regie neueRegie = new Regie("Steven Spielberg");
        db.createRegie(neueRegie);
        assertNotEquals(-1, neueRegie.getId());
    }

    @Test
    public void updateFilm() {
        Film film = db.readFilmById(2);
        int neueSpielzeit = (int) (Math.random() * 100);
        film.setSpielzeit(neueSpielzeit);
        assertTrue(db.updateFilm(film));

        film = db.readFilmById(2);
        assertEquals(neueSpielzeit, film.getSpielzeit());

    }

    @Test
    public void updateRegie() {
        String[] names = {"Hans", "Peter", "Mike"};
        int index = new Random().nextInt(names.length);
        Regie regie = db.readRegieById(2);
        regie.setName(names[index]);
        assertTrue(db.updateRegie(regie));

        regie = db.readRegieById(2);
        assertEquals(names[index], regie.getName());

    }

    @Test
    public void deleteFilm() {
        db.deleteFilm(2);
        assertNull(db.readFilmById(2));
    }

    @Test
    public void deleteRegie() {
        db.deleteFilm(1);
        db.deleteRegie(1);
        assertNull(db.readRegieById(1));
    }


}
