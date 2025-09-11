package h4.a2_gemiddelde;

import java.util.Scanner;

/**
 * @author Vincent Velthuizen
 * Bereken het gemiddelde van een reeks getallen
 */
public class GemiddeldeLauncher {

    public static void main(String[] args) {
        Scanner toetsenbord = new Scanner(System.in);

        System.out.println("Dit programma berekent het gemiddelde van twee of meer getallen.");

        System.out.print("Geef het eerste getal: ");
        int som = toetsenbord.nextInt();

        System.out.print("Geef het tweede getal: ");
        som += toetsenbord.nextInt();

        int aantalGetallen = 2;

        while(meerGetallen(toetsenbord)) {
            System.out.print("Geef het volgende getal: ");
            som += toetsenbord.nextInt();
            aantalGetallen++;
        }

        double gemiddelde = (double) som / aantalGetallen;

        System.out.println();
        System.out.println("Het gemiddelde van jouw " + aantalGetallen + " getallen is " + gemiddelde + ".");
    }

    private static boolean meerGetallen(Scanner toetsenbord) {
        System.out.println();
        System.out.print("Wil je van meer getallen het gemiddelde bepalen (ja/nee)? ");
        String keuze = toetsenbord.next();
        while (!keuze.equals("ja") && !keuze.equals("nee")) {
            System.out.println("Je moet 'ja' of 'nee' antwoorden.");

            System.out.print("Wil je van meer getallen het gemiddelde bepalen (ja/nee)? ");
            keuze = toetsenbord.next();
        }

        return keuze.equals("ja");
    }

}
