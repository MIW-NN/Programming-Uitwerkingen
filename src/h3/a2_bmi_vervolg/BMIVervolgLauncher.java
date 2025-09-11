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
    private static final String STRING_ONDERGEWICHT = "ondergewicht";
    private static final String STRING_GEZOND_GEWICHT = "gezond gewicht";
    private static final String STRING_OVERGEWICHT = "overgewicht";
    private static final String STRING_OBESITAS = "obesitas";

    public static void main(String[] args) {
        Scanner toetsenbord = new Scanner(System.in);

        int lengteCM = vraagLengteInCm(toetsenbord);
        double gewichtKG = vraagGewichtInKg(toetsenbord);

        double bmi = berekenBMI(lengteCM, gewichtKG);
        String categorie = bepaalCategorie(bmi);

        System.out.println();
        System.out.println("Jouw BMI is: " + bmi + " (" + categorie + ")");
    }

    private static double vraagGewichtInKg(Scanner toetsenbord) {
        System.out.print("Geef je gewicht in kg: ");
        return toetsenbord.nextDouble();
    }

    public static int vraagLengteInCm(Scanner mpToetsenbord) {
        System.out.print("Geef je lengte in cm: ");
        return mpToetsenbord.nextInt();
    }

    public static String bepaalCategorie(double mpBmi) {
        String categorie;

        if (mpBmi < BOVENGRENS_ONDERGEWICHT) {
            categorie = STRING_ONDERGEWICHT;
        } else if (mpBmi < BOVENGRENS_GEZOND_GEWICHT) {
            categorie = STRING_GEZOND_GEWICHT;
        } else if (mpBmi < BOVENGRENS_OVERGEWICHT) {
            categorie = STRING_OVERGEWICHT;
        } else {
            categorie = STRING_OBESITAS;
        }

        return categorie;
    }

    public static double berekenBMI(int mpLengte, double mpGewicht) {
        double lengteM = mpLengte / 100.0;
        double bmi = berekenBMI(lengteM, mpGewicht);
        return rondAf(bmi);
    }

    public static double berekenBMI(double mpLengte, double mpGewicht) {
        return mpGewicht / (mpLengte * mpLengte);
    }

    public static double rondAf(double getal) {
        double factor = 10.0;
        return Math.round(getal * factor) / factor;
    }
}
