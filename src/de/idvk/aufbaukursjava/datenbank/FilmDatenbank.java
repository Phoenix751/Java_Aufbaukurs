package de.idvk.aufbaukursjava.datenbank;

import de.idvk.aufbaukursjava.datenbank.entity.Film;
import de.idvk.aufbaukursjava.datenbank.entity.Regie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class FilmDatenbank implements Datenbank {

    private String url = "";

    public FilmDatenbank(String url) {
        this.url = url;
    }

    public FilmDatenbank() {

    }

    private Connection openConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }


    @Override
    public Film createFilm(Film film) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Regie createRegie(Regie regie) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Film> readAlleFilme() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Film readFilmById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Regie readRegieById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean updateFilm(Film film) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean updateRegie(Regie regie) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean deleteFilm(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean deleteRegie(int id) {
        throw new UnsupportedOperationException();
    }
}
