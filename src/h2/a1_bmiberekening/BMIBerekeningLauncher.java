package h2.a1_bmiberekening;

import java.util.Scanner;

/**
 * @author Vincent Velthuizen
 * Vraag om de benodigde gegevens van de gebruiker en bereken de BMI.
 */
public class BMIBerekeningLauncher {

    private static final double ONDERGRENS_GEZOND_GEWICHT = 18.5;
    private static final double BOVENGRENS_GEZOND_GEWICHT = 25.0;
    private static final double CM_NAAR_METER_FACTOR = 100.0;

    public static void main(String[] args) {
        Scanner toetsenbord = new Scanner(System.in);

        System.out.print("Geef je lengte in cm: ");
        int lengteCM = toetsenbord.nextInt();
        double lengteM = lengteCM / CM_NAAR_METER_FACTOR;

        System.out.print("Geef je gewicht in kg: ");
        double gewichtKG = toetsenbord.nextDouble();

        double bmi = gewichtKG / (lengteM * lengteM);

        System.out.println();
        System.out.println("Jouw BMI is: " + bmi);

        if (bmi > ONDERGRENS_GEZOND_GEWICHT && bmi <= BOVENGRENS_GEZOND_GEWICHT) {
            System.out.println();
            System.out.println("Dit BMI wordt gezien als gezond, goed bezig!");
        }
    }

}
