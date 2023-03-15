package de.idvk.aufbaukursjava.restauranteins;

public class Restaurant {
    private static String name = "Mein Restaurant";
    private static Gast gast;
    private static final Gericht[] speisekarte =
            {
                    new Vorspeise("Suppe", 5.5),
                    new Hauptspeise("Arabiata", 8.42),
                    new Dessert("Tiramisu", 6.66)
            };

    public static void main(String[] args) throws InterruptedException {
        init();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Hallo " + gast.getName() + "!");
            System.out.println("Was möchtest du heute bestellen?");
            for (int i = 1; i <= speisekarte.length; i++) {
                System.out.println(i + ": " + speisekarte[i - 1]);
            }
            int wahl = scanner.nextInt();

            switch (wahl) {
                case 1:
                case 2:
                case 3:
                    gast.bestellen(speisekarte[wahl - 1]);
                    speisekarte[wahl - 1].kochen();
                    System.out.println("Lass es dir schmecken!");
                    break;
                default:
                    System.out.println("Da ist leider etwas schief gelaufen.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Bitte Zahlen eingeben.");
        }

    }

    private static void init() {
        System.out.println("Willkommen in "+name);
        gast = new Gast("Fat Mike");
    }


}
