package h3.a1_methodes;

import java.util.Scanner;

/**
 * @author Vincent Velthuizen
 * Oefenen met het schrijven van methodes.
 */
public class MethodesLauncher {

    public static void main(String[] args) {
        // 3.1.1 Sterrenrij
        toonSterrenRij();

        // 3.1.2 Sterrenvierkant
        toonSterrenVierkant();

        Scanner toetsenbord = new Scanner(System.in);

        // 3.1.3 Herhaal woord
        System.out.print("Welk woord wil je vijf keer zien? ");
        String woord = toetsenbord.next();
        toonWoordVijfKeer(woord);

        // 3.1.4 Wisselgeld
        System.out.print("Hoeveel moet je betalen? ");
        double teBetalen = toetsenbord.nextDouble();

        System.out.print("Hoeveel heb je gegeven? ");
        double betaald = toetsenbord.nextDouble();

        double wisselgeld = berekenWisselgeld(teBetalen, betaald);
        System.out.println("Wisselgeld: " + wisselgeld);

        // 3.1.5 Eerlijk delen
        eerlijkDelen(toetsenbord);

        // 3.1.6 Wisselgeld gevorderd
        wisselgeldGevorderd(toetsenbord);
    }

    public static void toonSterrenRij() {
        System.out.println(" * * * *");
    }

    public static void toonSterrenVierkant() {
        toonSterrenRij();
        toonSterrenRij();
        toonSterrenRij();
        toonSterrenRij();
    }

    public static void toonWoordVijfKeer(String mpWoord) {
        System.out.println(mpWoord + mpWoord + mpWoord + mpWoord + mpWoord);
    }

    public static double berekenWisselgeld(double mpTeBetalen, double mpBetaald) {
        return mpBetaald - mpTeBetalen;
    }

    public static void eerlijkDelen(Scanner mpToetsenbord) {
        System.out.print("Hoeveel euromunten wil je verdelen? ");
        int aantalMunten = mpToetsenbord.nextInt();

        System.out.print("Met hoeveel personen? ");
        int aantalPersonen = mpToetsenbord.nextInt();

        int iederKrijgt = aantalMunten / aantalPersonen;
        int rest = aantalMunten % aantalPersonen;

        System.out.println();
        System.out.println("Als je " + aantalMunten + " euromunten verdeelt over " + aantalPersonen + " mensen");
        System.out.println("krijgt ieder " + iederKrijgt + " munten en blijven er " + rest + " over.");
    }

    public static void wisselgeldGevorderd(Scanner mpToetsenbord) {
        System.out.print("Hoeveel moet je betalen? ");
        double teBetalen = mpToetsenbord.nextDouble();

        System.out.print("Hoeveel heb je gegeven? ");
        double betaald = mpToetsenbord.nextDouble();

        teBetalen = rondAfOpVijfCent(teBetalen);
        double wisselgeld = berekenWisselgeld(teBetalen, betaald);

        System.out.println();
        System.out.println("Je krijgt " + wisselgeld + " terug.");
    }

    private static double rondAfOpVijfCent(double bedrag) {
        return Math.round(bedrag * 20) / 20.0;
    }
}
