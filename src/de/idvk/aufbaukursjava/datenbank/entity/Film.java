package de.idvk.aufbaukursjava.datenbank.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Film {
    private int id = -1;
    private String title;
    private int spielzeit; //in Minuten
    private Regie regie;
    private LocalDate veroeffentlichung;

    public Film(String title,
                int spielzeit,
                Regie regie,
                LocalDate veroeffentlichung) {
        this.title = title;
        this.spielzeit = spielzeit;
        this.regie = regie;
        this.veroeffentlichung = veroeffentlichung;
    }

    public Film() {
        this(null, 0, null, null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (this.id == -1) {
            this.id = id;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSpielzeit() {
        return spielzeit;
    }

    public void setSpielzeit(int spielzeit) {
        this.spielzeit = spielzeit;
    }

    public Regie getRegie() {
        return regie;
    }

    public void setRegie(Regie regie) {
        this.regie = regie;
    }

    public LocalDate getVeroeffentlichung() {
        return veroeffentlichung;
    }

    public void setVeroeffentlichung(LocalDate veroeffentlichung) {
        this.veroeffentlichung = veroeffentlichung;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", spielzeit=" + spielzeit +
                ", regie=" + regie +
                ", veroeffentlichung=" + veroeffentlichung +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id == film.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, spielzeit, regie, veroeffentlichung);
    }
}
