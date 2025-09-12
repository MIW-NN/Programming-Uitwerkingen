package h6.a1_arrays;

import java.util.Scanner;

/**
 * @author Vincent Velthuizen
 * Meerdere oefeningen met arrays.
 */
public class ArraysLauncher {

    private static final int ONDERGRENS = 1;

    public static void main(String[] args) {
        Scanner toetsenbord = new Scanner(System.in);

        int[] getallenRij = arrayVanWillekeurigeGetallen(toetsenbord);

        System.out.println();

        System.out.printf("De som is: %d\n", somVanRij(getallenRij));

        System.out.printf("Het gemiddelde is: %s\n", gemiddeldeVanRij(getallenRij));

        System.out.printf("Het kleinste element in de rij is: %d\n", minimum(getallenRij));

        int voorkomensVan = 42;
        System.out.printf("Het getal %d komt %d keer voor in de rij\n",
                voorkomensVan, aantalVoorkomens(getallenRij, voorkomensVan));

        System.out.println();
        toonVoorkomens();
    }

    public static void toonVoorkomens() {
        int[] getallenRij = maakRijWillekeurigeGetallen(1000, 50);
        int[] voorkomens = telVoorkomens(getallenRij, 50);

        System.out.println("Overzicht van voorkomens van getallen in rij:");
        for (int index = 0; index < voorkomens.length; index++) {
            System.out.printf("Getal %2d komt %d voor.\n", index + 1, voorkomens[index]);
        }
    }

    public static int[] telVoorkomens(int[] mpRij, int grootsteGetal) {
        int[] aantalVoorkomingen = new int[grootsteGetal];

        for (int index = 0; index < mpRij.length; index++) {
            aantalVoorkomingen[mpRij[index] - 1]++;
        }

        return aantalVoorkomingen;
    }

    public static int aantalVoorkomens(int[] mpRij, int mpGetal) {
        int aantalVoorkomingen = 0;

        for (int index = 0; index < mpRij.length; index++) {
            if (mpRij[index] == mpGetal) {
                aantalVoorkomingen++;
            }
        }

        return aantalVoorkomingen;
    }

    public static int minimum(int[] mpRij) {
        int minimum = mpRij[0];

        for (int index = 1; index < mpRij.length; index++) {
            if (mpRij[index] < minimum) {
                minimum = mpRij[index];
            }
        }

        return minimum;
    }

    public static double gemiddeldeVanRij(int[] mpRij) {
        return (double) somVanRij(mpRij) / mpRij.length;
    }

    public static int somVanRij(int[] mpRij) {
        int som = 0;

        for (int index = 0; index < mpRij.length; index++) {
            som += mpRij[index];
        }

        return som;
    }

    private static int[] arrayVanWillekeurigeGetallen(Scanner toetsenbord) {
        System.out.print("Hoeveel getallen wil je genereren? ");
        int aantalGetallen = toetsenbord.nextInt();

        System.out.print("Wat is het grootste getal dat mag voorkomen? ");
        int maximumGetal = toetsenbord.nextInt();

        int[] rijGetallen = maakRijWillekeurigeGetallen(aantalGetallen, maximumGetal);

        System.out.print("Dit zijn de getallen: ");
        toonRijGetallen(rijGetallen);

        return rijGetallen;
    }

    public static void toonRijGetallen(int[] mpRijGetallen) {
        for (int index = 0; index < mpRijGetallen.length; index++) {
            System.out.print(mpRijGetallen[index] + " ");
        }
        System.out.println();
    }

    public static int[] maakRijWillekeurigeGetallen(int mpAantal, int mpMaximum) {
        int[] rijGetallen = new int[mpAantal];

        for (int index = 0; index < mpAantal; index++) {
            rijGetallen[index] = randomGetalTussen(ONDERGRENS, mpMaximum);
        }

        return rijGetallen;
    }

    public static int randomGetalTussen(int mpOndergrens, int mpBovengrens) {
        return (int) (Math.random() * (mpBovengrens - mpOndergrens + 1) + mpOndergrens);
    }
}
