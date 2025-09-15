package h7.a1_getallenraden;

import java.util.Scanner;

/**
 * @author Vincent Velthuizen
 * Een spelletje waarbij een gebruiker een set getallen moet raden.
 */
public class GetallenRadenLauncher {

    private static final int AANTAL_GETALLEN = 3;
    private static final int ONDERGRENS = 1;
    private static final int BOVENGRENS = 10;

    public static void main(String[] args) {
        int[] teRadengetallen = genereerGetallen();

        boolean goedGeraden = false;
        int aantalPogingen = 0;

        Scanner toetsenbord = new Scanner(System.in);

        while (!goedGeraden) {
            int[] geradenGetallen = vraagOmTeRaden(toetsenbord);
            aantalPogingen++;
            int aantalGoed = bepaalHoeveelGoed(teRadengetallen, geradenGetallen);

            System.out.printf("Aantal correcte getallen = %d\n", aantalGoed);

            goedGeraden = aantalGoed == AANTAL_GETALLEN;
        }

        System.out.println();
        System.out.printf("U heeft %d keer geraden.\n", aantalPogingen);
        System.out.print("De te raden getallen waren: ");

        for (int index = 0; index < teRadengetallen.length; index++) {
            System.out.print(teRadengetallen[index] + " ");
        }
        System.out.println();
    }

    private static int bepaalHoeveelGoed(int[] teRadengetallen, int[] geradenGetallen) {
        int goedGeraden = 0;

        for (int index = 0; index < teRadengetallen.length; index++) {
            if (komtVoorIn(teRadengetallen[index], geradenGetallen)) {
                goedGeraden++;
            }
        }

        return goedGeraden;
    }

    private static int[] vraagOmTeRaden(Scanner toetsenbord) {
        System.out.printf("Geef %d verschillende getallen tussen de %d en %d, gescheiden door spaties: ",
                AANTAL_GETALLEN, ONDERGRENS, BOVENGRENS);

        int[] geradenGetallen = new int[AANTAL_GETALLEN];

        for (int index = 0; index < AANTAL_GETALLEN; index++) {
            geradenGetallen[index] = toetsenbord.nextInt();
        }

        return geradenGetallen;
    }

    public static int[] genereerGetallen() {
        int[] getallen = new int[AANTAL_GETALLEN];

        for (int index = 0; index < getallen.length; index++) {
            int nieuwGetal = randomGetalTussen(ONDERGRENS, BOVENGRENS);

            while (komtVoorIn(nieuwGetal, getallen)) {
                nieuwGetal = randomGetalTussen(ONDERGRENS, BOVENGRENS);
            }

            getallen[index] = nieuwGetal;
        }

        return getallen;
    }

    public static boolean komtVoorIn(int mpZoekgetal, int[] mpLijst) {
        boolean komtVoor = false;

        for (int index = 0; index < mpLijst.length; index++) {
            if (mpLijst[index] == mpZoekgetal) {
                komtVoor = true;
                // als je hier zou willen stoppen dan moet je een while gebruiken,
                // het aantal iteraties is dan immers niet meer voorspelbaar.
            }
        }

        return komtVoor;
    }

    public static int randomGetalTussen(int mpOndergrens, int mpBovengrens) {
        return (int) (Math.random() * (mpBovengrens - mpOndergrens + 1) + mpOndergrens);
    }
}
