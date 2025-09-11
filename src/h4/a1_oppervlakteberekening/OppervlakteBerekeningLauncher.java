package h4.a1_oppervlakteberekening;

import java.util.Scanner;

/**
 * @author Vincent Velthuizen
 * Laat een gebruiker oefenen met het berekenen van het oppervlak van een driehoek.
 */
public class OppervlakteBerekeningLauncher {

    private static final int ONDERGRENS = 2;
    private static final int BOVENGRENS = 10;

    public static void main(String[] args) {
        Scanner toetsenbord = new Scanner(System.in);

        System.out.print("Wil je de oppervlakte van een driehoek uitrekenen?\nDoorgaan (j/n)?: ");
        String doorgaanAntwoord = toetsenbord.next();

        while (!doorgaanAntwoord.equals("n")) {
            int basis = randomGetalTussen(ONDERGRENS, BOVENGRENS);
            int hoogte = randomGetalTussen(ONDERGRENS, BOVENGRENS);

            double correcteAntwoord = berekenOppervlakteDriehoek(basis, hoogte);

            System.out.print("Bereken de oppervlakte van een driehoek met basis " + basis
                    + " en hoogte " + hoogte + ": ");
            double antwoordGebruiker = toetsenbord.nextDouble();

            System.out.println();
            if (correcteAntwoord == antwoordGebruiker) {
                System.out.println("Jouw antwoord is goed!");
            } else {
                System.out.println("Jouw antwoord is niet goed.");
                System.out.println("Het juiste antwoord is " + correcteAntwoord);
            }

            System.out.println();
            System.out.print("Wil je de oppervlakte van een driehoek uitrekenen?\nDoorgaan (j/n)?: ");
            doorgaanAntwoord = toetsenbord.next();
        }

        System.out.println("Het programma wordt nu gestopt.");
    }

    public static double berekenOppervlakteDriehoek(int mpBasis, int mpHoogte) {
        return mpBasis * mpHoogte * 0.5;
    }

    public static int randomGetalTussen(int mpOndergrens, int mpBovengrens) {
        return (int) (Math.random() * (mpBovengrens - mpOndergrens + 1) + mpOndergrens);
    }
}
