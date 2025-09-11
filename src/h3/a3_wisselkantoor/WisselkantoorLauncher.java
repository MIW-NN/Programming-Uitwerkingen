package h3.a3_wisselkantoor;

import java.util.Scanner;

/**
 * @author Vincent Velthuizen
 * Reken een te wisselen hoeveelheid euro's om naar verschillende valuta.
 */
public class WisselkantoorLauncher {

    private static final double TRANSACTIEKOSTEN_PERCENTAGE = 1.5;
    private static final int MINIMALE_TRANSACTIEKOSTEN = 2;
    private static final int MAXIMALE_TRANSACTIEKOSTEN = 15;
    private static final double KOERS_EURO_DOLLAR = 1.23843;
    private static final double KOERS_EURO_POND = 0.88459;
    private static final double KOERS_EURO_YEN = 134.64711;

    public static void main(String[] args) {
        Scanner toetsenbord = new Scanner(System.in);

        System.out.print("In te wisselen bedrag (alleen gehele getallen): ");
        int teWisselenBedrag = toetsenbord.nextInt();

        int transactiekosten = berekenTransactiekosten(teWisselenBedrag);
        teWisselenBedrag -= transactiekosten;

        System.out.println();
        System.out.println("De transactiekosten bedragen " + transactiekosten + " euro.");
        System.out.println("We rekenen daarom " + teWisselenBedrag + " voor u oms.");

        System.out.println();
        wisselEnToon(teWisselenBedrag, "dollar");
        wisselEnToon(teWisselenBedrag, "pond");
        wisselEnToon(teWisselenBedrag, "yen");
    }

    private static int berekenTransactiekosten(int teWisselenBedrag) {
        int transactiekosten = (int) Math.round(teWisselenBedrag * (TRANSACTIEKOSTEN_PERCENTAGE / 100.0));

        transactiekosten = Math.max(transactiekosten, MINIMALE_TRANSACTIEKOSTEN);
        transactiekosten = Math.min(transactiekosten, MAXIMALE_TRANSACTIEKOSTEN);

        return transactiekosten;
    }

    public static void wisselEnToon(int bedrag, String valuta) {
        double koers;
        
        switch (valuta) {
            case "dollar":
                koers = KOERS_EURO_DOLLAR;
                break;
            case "pond":
                koers = KOERS_EURO_POND;
                break;
            case "yen":
                koers = KOERS_EURO_YEN;
                break;
            default:
                koers = 0.0; // wat is een goede default hier?
                // door 0 te kiezen geven we als resultaat bij ons krijg je 0 van een valuta die we niet kennen
                // dat lijkt me geen gekke keuze.
        }
        
        wisselEnToon(bedrag, valuta, koers);
    }

    private static void wisselEnToon(int bedrag, String valuta, double koers) {

//        double omgerekendeBedrag = rondAf(bedrag * koers); // versie voor 3.3.1
        int omgerekendeBedrag = (int) (bedrag * koers);
        System.out.println("U krijg hiervoor " + omgerekendeBedrag + " " + valuta + ". (koers " + koers + ")");
    }

    public static double rondAf(double getal) { // nodig voor 3.3.1
        double factor = 100.0;
        return Math.round(getal * factor) / factor;
    }

}
