package de.idvk.aufbaukursjava.datenbank.entity;

import java.util.Objects;

public class Regie {
    private int id = -1;
    private String name;

    public Regie(String name) {
        this.name = name;
    }

    public Regie() {
        this(null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (this.id == -1) {
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Regie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Regie regie = (Regie) o;
        return id == regie.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
