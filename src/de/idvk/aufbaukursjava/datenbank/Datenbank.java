package de.idvk.aufbaukursjava.datenbank;

import de.idvk.aufbaukursjava.datenbank.entity.Film;
import de.idvk.aufbaukursjava.datenbank.entity.Regie;

import java.util.List;

/**
 * Das interface Datenbank.
 */
public interface Datenbank {

    /**
     * CRUD Methode Create
     * Persistiert einen {@link Film} in der Datenbank.
     *
     * @param film zu persistierender {@link Film}
     * @return {@link Film} mit der korrekten Datenbank ID
     */

    Film createFilm(Film film);

    /**
     * CRUD Methode Create
     * Persistiert eine {@link Regie} in der Datenbank.
     *
     * @param regie zu persistierende {@link Regie}
     * @return {@link Regie} mit der korrekten Datenbank ID
     */
    Regie createRegie(Regie regie);

    /**
     * CRUD Methode Read
     * Liest alle {@link Film} aus der Datenbank.
     *
     * @return {@link List} aller {@link Film}
     */

    List<Film> readAlleFilme();

    /**
     * CRUD Methode Read
     * Liest einen einzelnen {@link Film} aus der Datenbank.
     *
     * @param id ID des gesuchten Films
     * @return {@link Film} oder {@code  null} falls es keinen Film mit der gesuchten ID gibt.
     */
    Film readFilmById(int id);

    /**
     * CRUD Methode Read
     * Liest eine einzelne {@link Regie} aus der Datenbank.
     *
     * @param id ID der gesuchten Regie
     * @return {@link Regie} oder {@code null} falls es keinen Film mit der gesuchten ID gibt.
     */
    Regie readRegieById(int id);

    /**
     * CRUD Methode Update
     * Aktualisiere einen bereits persistenten {@link Film}.
     *
     * @param film bereits persistenter {@link Film}
     * @return {@code true} wenn die Operation erfolgreich war {@code false} wenn nicht
     */

    boolean updateFilm(Film film);

    /**
     * CRUD Methode Update
     * Aktualisiere eine bereits persistente {@link Regie}.
     *
     * @param regie bereits persistente {@link Regie}
     * @return {@code true} wenn die Operation erfolgreich war {@code false} wenn nicht
     */
    boolean updateRegie(Regie regie);

    /**
     * CRUD Methode Delete
     * Löscht einen {@link Film} aus der Datenbank.
     *
     * @param id ID des zu löschenden {@link Film}
     * @return {@code true} wenn die Operation erfolgreich war {@code false} wenn nicht
     */

    boolean deleteFilm(int id);

    /**
     * CRUD Methode Delete
     * Löscht eine {@link Regie} aus der Datenbank.
     *
     * @param id ID der zu löschenden Regie
     * @return {@code true} wenn die Operation erfolgreich war {@code false} wenn nicht
     */
    boolean deleteRegie(int id);

}
