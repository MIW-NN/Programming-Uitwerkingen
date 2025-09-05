package h1.a2_leeftijdsberekening;

import java.util.Scanner;

/**
 * @author Vincent Velthuizen
 * Bereken iemands leeftijd en geef een groet.
 */
public class LeeftijdsberekeningLauncher {

    public static void main(String[] args) {
        Scanner toetsenbord = new Scanner(System.in);

        System.out.print("Hoe heet je? ");
        String naam = toetsenbord.nextLine();

        System.out.print("Wat is je geboortejaar? ");
        int geboortejaar = toetsenbord.nextInt();

        int huidigeJaar = 2025;
        int leeftijd = huidigeJaar - geboortejaar;

        System.out.println();
        System.out.println("Beste " + naam + ", eind " + huidigeJaar + " zal je leeftijd " + leeftijd + " jaar zijn.");
    }
}
