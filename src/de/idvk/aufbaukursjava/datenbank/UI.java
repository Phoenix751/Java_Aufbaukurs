package de.idvk.aufbaukursjava.datenbank;

import de.idvk.aufbaukursjava.datenbank.entity.Film;
import de.idvk.aufbaukursjava.datenbank.entity.Regie;

import java.time.LocalDate;
import java.util.Scanner;

public class UI {
    private final Datenbank datenbank;

    private boolean run = true;

    //TODO von Mockdb zu FilmDatenbank ändern
    public UI() {
        datenbank = new MockDb();
    }

    public void uiStarten() {
        System.out.println("Willkommen bei der Filmdatenbank. Was möchten Sie tun?");
        Scanner scanner = new Scanner(System.in);
        int auswahl = 0;
        String input;

        while (run) {
            printMenu();
            try {
                auswahl = Integer.parseInt(scanner.nextLine());


                switch (auswahl) {
                    case 1: //Read
                        for (Film film : datenbank.readAlleFilme()) {
                            System.out.println(film);
                        }
                        break;

                    case 2: //Create
                        printFilmOrRegie();
                        auswahl = Integer.parseInt(scanner.nextLine());
                        switch (auswahl) {
                            case 1:
                                Film neuerFilm = new Film();
                                System.out.println("Titel?");

                                neuerFilm.setTitle(scanner.nextLine());

                                System.out.println("Spielzeit in Minuten?");
                                neuerFilm.setSpielzeit(Integer.parseInt(scanner.nextLine()));

                                System.out.println("Regie_id?");
                                neuerFilm.setRegie(datenbank.readRegieById(Integer.parseInt(scanner.nextLine())));

                                System.out.println("Veröffentlicht? (yyyy-MM-dd)");
                                neuerFilm.setVeroeffentlichung(LocalDate.parse(scanner.nextLine()));

                                datenbank.createFilm(neuerFilm);
                                break;
                            case 2:
                                Regie neueRegie = new Regie();
                                System.out.println("Name?");
                                neueRegie.setName(scanner.nextLine());

                                datenbank.createRegie(neueRegie);
                                break;
                            default:
                                System.out.println("Eingabe nicht verstanden.");

                        }
                        break;
                    case 3: //Update
                        printFilmOrRegie();
                        auswahl = Integer.parseInt(scanner.nextLine());
                        switch (auswahl) {
                            case 1:
                                System.out.println("Welchen Film wollen Sie updaten? (ID)");
                                auswahl = Integer.parseInt(scanner.nextLine());
                                Film updateFilm = datenbank.readFilmById(auswahl);

                                System.out.println("Neuer Titel?");
                                input = scanner.nextLine();
                                updateFilm.setTitle(input.isBlank() ? updateFilm.getTitle() : input);

                                System.out.println("Neue Spielzeit in Minuten?");
                                input = scanner.nextLine();
                                updateFilm.setSpielzeit(input.isBlank() ? updateFilm.getSpielzeit() : Integer.parseInt(
                                        input));

                                System.out.println("Neue Regie_id?");
                                input = scanner.nextLine();
                                updateFilm.setRegie(input.isBlank() ? updateFilm.getRegie() : datenbank.readRegieById(
                                        Integer.parseInt(input)));

                                System.out.println("Neues Veröffentlichungsdatum?");
                                input = scanner.nextLine();
                                updateFilm.setVeroeffentlichung(input.isBlank() ? updateFilm.getVeroeffentlichung() : LocalDate.parse(
                                        input));

                                datenbank.updateFilm(updateFilm);
                                break;
                            case 2:
                                System.out.println("Welche Regie wollen Sie updaten? (ID)");
                                auswahl = Integer.parseInt(scanner.nextLine());
                                Regie updateRegie = datenbank.readRegieById(auswahl);

                                System.out.println("Neuer Name?");
                                input = scanner.nextLine();
                                updateRegie.setName(input.isBlank() ? updateRegie.getName() : input);

                                datenbank.updateRegie(updateRegie);
                                break;
                            default:
                                System.out.println("Eingabe nicht verstanden.");
                        }
                        break;
                    case 4: //Delete
                        printFilmOrRegie();
                        auswahl = Integer.parseInt(scanner.nextLine());
                        switch (auswahl) {
                            case 1:
                                System.out.println("Welchen Film wollen Sie löschen? (ID)");
                                auswahl = Integer.parseInt(scanner.nextLine());
                                datenbank.deleteFilm(auswahl);
                                break;
                            case 2:
                                System.out.println("Welche Regie wollen Sie löschen? (ID)");
                                auswahl = Integer.parseInt(scanner.nextLine());
                                datenbank.deleteRegie(auswahl);
                                break;
                            default:
                        }
                        break;
                    case 5:
                        run = false;
                        break;
                    default:
                        System.out.println("Eingabe nicht verstanden.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Fehlerhafter Input!");
            }
        }

        scanner.close();
    }

    private void printMenu() {
        System.out.print("1: Filme anzeigen\n2: Create\n3: Update\n4: Delete\n5: Exit\nIhre Auswahl [1-5]: ");
    }

    private void printFilmOrRegie() {
        System.out.print("1: Filme\n2: Regie\nIhre Auswahl [1-2]: ");
    }

}
