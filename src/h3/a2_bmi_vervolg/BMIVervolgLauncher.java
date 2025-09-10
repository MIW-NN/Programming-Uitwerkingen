package h3.a2_bmi_vervolg;

import java.util.Scanner;

/**
 * @author Vincent Velthuizen
 * Bereken de BMI van de gebruiker en geef er feedback op.
 */
public class BMIVervolgLauncher {

    private static final double BOVENGRENS_ONDERGEWICHT = 18.5;
    private static final double BOVENGRENS_GEZOND_GEWICHT = 25.0;
    private static final double BOVENGRENS_OVERGEWICHT = 30.0;

    public static void main(String[] args) {
        Scanner toetsenbord = new Scanner(System.in);

        System.out.print("Geef je lengte in cm: ");
        int lengteCM = toetsenbord.nextInt();

        System.out.print("Geef je gewicht in kg: ");
        double gewichtKG = toetsenbord.nextDouble();

        double bmi = berekenBMI(lengteCM, gewichtKG);
        String categorie = bepaalCategorie(bmi);

        System.out.println("Jouw BMI is: " + bmi + " (" + categorie + ")");
    }

    public static String bepaalCategorie(double mpBmi) {
        if (mpBmi < BOVENGRENS_ONDERGEWICHT) {
            return "ondergewicht";
        } else if (mpBmi < BOVENGRENS_GEZOND_GEWICHT) {
            return "gezond gewicht";
        } else if (mpBmi < BOVENGRENS_OVERGEWICHT) {
            return "overgewicht";
        } else {
            return "obesitas";
        }
    }

    public static double berekenBMI(int mpLengte, double mpGewicht) {
        double lengteM = mpLengte / 100.0;
        double bmi = mpGewicht / (lengteM * lengteM);
        return rondAf(bmi);
    }

    public static double rondAf(double getal) {
        double factor = 10.0;
        return Math.round(getal * factor) / factor;
    }
}
