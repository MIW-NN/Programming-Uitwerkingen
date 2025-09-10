package h1.a2_leeftijdsberekening;

import java.util.Scanner;

/**
 * @author Vincent Velthuizen
 * Bereken iemands leeftijd en geef een groet.
 */
public class LeeftijdberekeningLauncher {
    private static final int HUIDIGE_JAAR = 2025;

    public static void main(String[] args) {
        Scanner toetsenbord = new Scanner(System.in);

        System.out.print("Hoe heet je? ");
        String naam = toetsenbord.nextLine();

        System.out.print("Wat is je geboortejaar? ");
        int geboortejaar = toetsenbord.nextInt();

        int leeftijd = HUIDIGE_JAAR - geboortejaar;

        System.out.println();
        System.out.println("Beste " + naam + ", eind " + HUIDIGE_JAAR + " zal je leeftijd " + leeftijd + " zijn.");
    }
}
