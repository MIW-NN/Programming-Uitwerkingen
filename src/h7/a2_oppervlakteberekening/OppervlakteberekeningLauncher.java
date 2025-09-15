package h7.a2_oppervlakteberekening;

import java.util.Scanner;

/**
 * @author Vincent Velthuizen
 * Stel de gebruiker in staat de oppervlakte van verschillende figuren uit te rekenen.
 */
public class OppervlakteberekeningLauncher {

    public static void main(String[] args) {
        Scanner toetsenbord = new Scanner(System.in);

        int figuurKeuze;

        do {
            System.out.println("Van welke figuur wil je de oppervlakte uit laten rekenen?");
            System.out.print("(cirkel = 1; rechthoek = 2; vierkant = 3; driehoek = 4; stoppen = 0): ");
            figuurKeuze = toetsenbord.nextInt();

            System.out.println();
            switch (figuurKeuze) {
                case 1:
                    berekenOppervlakteCirkel(toetsenbord);
                    break;
                case 2:
                    berekenOppervlakteRechthoek(toetsenbord);
                    break;
                case 3:
                    berekenOppervlakteVierkant(toetsenbord);
                    break;
                case 4:
                    berekenOppervlakteDriehoek(toetsenbord);
                    break;
            }
        } while (figuurKeuze != 0);

        System.out.println("Het programma wordt nu gestopt.");
    }

    private static void berekenOppervlakteDriehoek(Scanner toetsenbord) {
        double basis = vraagOmEigenschap("basis", toetsenbord);
        double hoogte = vraagOmEigenschap("hoogte", toetsenbord);

        double oppervlakte = hoogte * basis * 0.5;

        toonOppervlakteVanFiguur("driehoek", oppervlakte);
    }

    private static void berekenOppervlakteVierkant(Scanner toetsenbord) {
        double zijde = vraagOmEigenschap("zijde", toetsenbord);

        double oppervlakte = zijde * zijde;

        toonOppervlakteVanFiguur("vierkant", oppervlakte);
    }

    private static void berekenOppervlakteRechthoek(Scanner toetsenbord) {
        double hoogte = vraagOmEigenschap("hoogte", toetsenbord);
        double breedte = vraagOmEigenschap("breedte", toetsenbord);

        double oppervlakte = hoogte * breedte;

        toonOppervlakteVanFiguur("rechthoek", oppervlakte);
    }

    private static void berekenOppervlakteCirkel(Scanner toetsenbord) {
        double straal = vraagOmEigenschap("straal", toetsenbord);
        double oppervlakte = Math.PI * straal * straal;

        toonOppervlakteVanFiguur("cirkel", oppervlakte);
    }

    private static void toonOppervlakteVanFiguur(String figuurNaam, double oppervlakte) {
        System.out.printf("\nDe oppervlakte van jouw %s is %s vierkante centimeter.\n\n", figuurNaam, oppervlakte);
    }

    private static double vraagOmEigenschap(String eigenschap, Scanner toetsenbord) {
        System.out.printf("Wat is de %s in centimeters? ", eigenschap);
        return toetsenbord.nextDouble();
    }
}
