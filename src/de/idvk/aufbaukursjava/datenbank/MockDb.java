package de.idvk.aufbaukursjava.datenbank;

import de.idvk.aufbaukursjava.datenbank.entity.Film;
import de.idvk.aufbaukursjava.datenbank.entity.Regie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MockDb implements Datenbank {
    private List<Film> filme;
    private List<Regie> regie;

    public MockDb() {
        var r1 = new Regie("Peter Jackson");
        var r2 = new Regie("Stanley Kubrik");
        var r3 = new Regie("James Cameron");
        r1.setId(1);
        r2.setId(2);
        r3.setId(3);

        regie = new ArrayList<>(List.of(r1, r2, r3));

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

        filme = new ArrayList<>(List.of(f1, f2, f3, f4, f5));
    }

    @Override
    public Film createFilm(Film film) {
        filme.sort(Comparator.comparingInt(Film::getId));
        film.setId(filme.get(filme.size() - 1).getId() + 1);
        filme.add(film);
        return film;
    }

    @Override
    public Regie createRegie(Regie regie) {
        this.regie.sort(Comparator.comparingInt(Regie::getId));
        regie.setId(this.regie.get(this.regie.size() - 1).getId() + 1);
        this.regie.add(regie);
        return regie;
    }

    @Override
    public List<Film> readAlleFilme() {
        return filme;
    }

    @Override
    public Film readFilmById(int id) {
        return filme.stream().filter(film -> film.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Regie readRegieById(int id) {
        return this.regie.stream().filter(regie1 -> regie1.getId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean updateFilm(Film film) {
        return true;
    }

    @Override
    public boolean updateRegie(Regie regie) {
        return true;
    }

    @Override
    public boolean deleteFilm(int id) {
        filme = filme.stream().filter(film -> film.getId() != id).collect(Collectors.toList());
        return true;
    }

    @Override
    public boolean deleteRegie(int id) {
        this.regie = this.regie.stream().filter(regie1 -> regie1.getId() != id).collect(Collectors.toList());
        return true;
    }
}
