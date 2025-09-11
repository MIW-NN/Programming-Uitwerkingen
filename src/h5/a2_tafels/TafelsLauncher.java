package h5.a2_tafels;

import java.util.Scanner;

/**
 * @author Vincent Velthuizen
 * Druk nette tafels af op het scherm.
 */
public class TafelsLauncher {

    public static void main(String[] args) {
        Scanner toetsenbord = new Scanner(System.in);

//        stap1(toetsenbord);
//        stap2(toetsenbord);
//        stap3(toetsenbord);
        stap4(toetsenbord);
    }

    public static void stap1(Scanner toetsenbord) {
        System.out.print("Welke tafel wilt u afdrukken? ");
        int tafel = toetsenbord.nextInt();

        System.out.println();
        System.out.printf("De tafel van %d:\n", tafel);
        for (int i = 1; i < 11; i++) {
            System.out.print(i * tafel + " ");
        }
        System.out.println();
    }

    public static void stap2(Scanner toetsenbord) {
        System.out.print("Welke tafel wilt u afdrukken? ");
        int tafel = toetsenbord.nextInt();

        System.out.println();
        System.out.printf("De tafel van %d:\n", tafel);
        for (int i = 1; i < 11; i++) {
            System.out.printf("%5d ", i * tafel);
            if (i % 5 == 0) {
                System.out.println();
            }
        }
    }

    public static void stap3(Scanner toetsenbord) {
        System.out.print("Welke tafel wilt u afdrukken? ");
        int tafel = toetsenbord.nextInt();

        System.out.print("Hoeveel getallen wilt u afdrukken? ");
        int aantalGetallen = toetsenbord.nextInt();

        printTafel(tafel, aantalGetallen);
    }

    private static void printTafel(int tafel, int aantalGetallen) {
        System.out.println();
        System.out.printf("De tafel van %d:\n", tafel);
        for (int i = 1; i <= aantalGetallen; i++) {
            System.out.printf("%5d ", i * tafel);
            if (i % 5 == 0) {
                System.out.println();
            }
        }

        if (aantalGetallen % 5 != 0) {
            System.out.println();
        }
    }

    public static void stap4(Scanner toetsenbord) {
        System.out.print("Welke tafel wilt u afdrukken? ");
        int tafel = toetsenbord.nextInt();

        while (tafel != 0) {
            System.out.print("Hoeveel getallen wilt u afdrukken? ");
            int aantalGetallen = toetsenbord.nextInt();

            printTafel(tafel, aantalGetallen);

            System.out.println();
            System.out.print("Welke tafel wilt u afdrukken? ");
            tafel = toetsenbord.nextInt();
        }
    }
}
