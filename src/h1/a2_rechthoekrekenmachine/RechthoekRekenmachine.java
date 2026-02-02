package h1.a2_rechthoekrekenmachine;

import java.util.Scanner;

/**
 * @author Vincent Velthuizen
 * Bereken informatie over een rechthoek.
 */
public class RechthoekRekenmachine {

    public static void main(String[] args) {
        Scanner toetsenbord = new Scanner(System.in);

        System.out.println("=== Rechthoek Rekenmachine ===\n");

        System.out.print("Wat is de lengte van de rechthoek (in cm)? ");
        double lengte = toetsenbord.nextDouble();
        System.out.print("Wat is de breedte van de rechthoek (in cm)? ");
        double breedte = toetsenbord.nextDouble();

        double oppervlakte = lengte * breedte;
        double omtrek = 2 * (lengte + breedte);

        System.out.println();
        System.out.println("Resultaten:\n-----------");
        System.out.println("Lengte:      " + lengte + " cm");
        System.out.println("Breedte:     " + breedte + " cm");
        System.out.println("Oppervlakte: " + oppervlakte + " cm²");
        System.out.println("Omtrek:      " + omtrek + " cm");
    }

}
