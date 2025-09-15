package h6.a2_tentamencijfers;

import java.util.Scanner;

/**
 * @author Vincent Velthuizen
 * Verzamel tentamencijfers en doe er statistiek op.
 */
public class TentamencijfersLauncher {
    private static final double GRENS_VOLDOENDE = 5.5;

    public static void main(String[] args) {
        Scanner toetsenbord = new Scanner(System.in);

        int aantalCijfers = vraagAantalCijfers(toetsenbord);

        System.out.println();
        double[] cijfers = vraagOmCijfers(toetsenbord, aantalCijfers);

        System.out.println();
        System.out.printf("Aantal cijfers   : %2d\n", cijfers.length);
        System.out.printf("Gemiddelde cijfer: %4.1f\n", krijgGemiddelde(cijfers));
        System.out.printf("Aantal voldoendes: %2d\n", krijgAantalVoldoendes(cijfers));
        System.out.printf("Hoogste cijfer   : %4.1f\n", krijgHoogsteCijfer(cijfers));
    }

    private static double krijgHoogsteCijfer(double[] cijfers) {
        double maximum = cijfers[0];

        for (int index = 1; index < cijfers.length; index++) {
            if (cijfers[index] > maximum) {
                maximum = cijfers[index];
            }
        }

        return maximum;
    }

    private static int krijgAantalVoldoendes(double[] cijfers) {
        int aantalVoldoendes = 0;

        for (int index = 0; index < cijfers.length; index++) {
            if (cijfers[index] >= GRENS_VOLDOENDE) {
                aantalVoldoendes++;
            }
        }

        return aantalVoldoendes;
    }

    private static double berekenTotaal(double[] cijfers) {
        double totaal = 0;

        for (int index = 0; index < cijfers.length; index++) {
            totaal += cijfers[index];
        }

        return totaal;
    }

    private static double krijgGemiddelde(double[] cijfers) {
        return berekenTotaal(cijfers) / cijfers.length;
    }

    private static double[] vraagOmCijfers(Scanner toetsenbord, int aantalCijfers) {
        double[] cijfers = new double[aantalCijfers];

        for (int student = 0; student < aantalCijfers; student++) {
            System.out.printf("Cijfer student %2d: ", student + 1);
            cijfers[student] = toetsenbord.nextDouble();
        }

        return cijfers;
    }

    private static int vraagAantalCijfers(Scanner toetsenbord) {
        System.out.print("Hoeveel cijfers wilt u invoeren? ");
        int aantalCijfers = toetsenbord.nextInt();

        while (aantalCijfers <= 0) {
            System.out.println("\tAantal cijfers moet groter zijn dan 0.");

            System.out.print("Hoeveel cijfers wilt u invoeren? ");
            aantalCijfers = toetsenbord.nextInt();
        }

        return aantalCijfers;
    }
}
