package h5.a1_loops;

import java.util.Scanner;

/**
 * @author Vincent Velthuizen
 * Verschillende kleine oefeningen met loops
 */
public class LoopsLauncher {

    public static void main(String[] args) {
        // 5.1.1 Sterrenrij
//        toonRijSterren(8);

        // 5.1.2 Sterrenvierkant
//        toonSterrenVierkant(4);

        // 5.1.3 Karakterrij
        Scanner toetsenbord = new Scanner(System.in);
//        karakterRij(toetsenbord);

        // 5.1.4 Optellen tot aan 1000
//        tellenTotAanDuizend();

        // 5.1.5 Optellen tot aan een bovengrens
        optellenTotAanEenBovengrens(toetsenbord);
    }

    public static void toonRijSterren(int mpAantal) {
        for (int iterator = 0; iterator < mpAantal; iterator++) {
            System.out.print(" * ");
        }
        System.out.println();
    }

    public static void toonSterrenVierkant(int mpAantal) {
        for (int iterator = 0; iterator < mpAantal; iterator++) {
            toonRijSterren(mpAantal);
        }
    }

    public static void toonCharRij(char mpKarakter, int mpAantal) {
        for (int iterator = 0; iterator < mpAantal; iterator++) {
            System.out.print(mpKarakter);
        }
        System.out.println();
    }

    public static void karakterRij(Scanner toetsenbord) {
        System.out.print("Welk karakter wil je dit keer gebruiken? ");
        char karakter = toetsenbord.next().charAt(0);

        System.out.print("Hoe vaak wil je het zien? ");
        int aantal = toetsenbord.nextInt();

        toonCharRij(karakter, aantal);
    }

    public static void tellenTotAanDuizend() {
        int teller = 1;
        int som = 0;

        while (som < 1000) {
            System.out.printf("%3d + %4d = %4d\n", teller, som, som + teller);
            som += teller;
            teller++;
        }

        System.out.printf("%3d + %4d = %4d\n", teller, som, som + teller);

//        44 +  946 =  990
//        45 +  990 = 1035
//        46 + 1035 = 1081
        // dus 44 is net onder de 1000, 45 is net er overheen, en 46 is de eindstand van teller...
        // voor deze opdracht is het antwoord dus 45 (teller - 1)
        // voor de volgende opdracht is het antwoord teller - 2 (in dit geval 44).
    }

    public static int telAantalTeSommerenGetallen(int mpGrens) {
        int teller = 1;
        int som = 0;

        while (som < mpGrens) {
            som += teller;
            teller++;
        }

        return teller - 2;
    }

    public static void optellenTotAanEenBovengrens(Scanner toetsenbord) {
        System.out.print("Tot hoeveel moeten we optellen? ");
        int grens = toetsenbord.nextInt();
        int aantalGetallenTotGrens = telAantalTeSommerenGetallen(grens);
        System.out.printf("De eerste %d getallen bij elkaar zijn net geen %d.\n", aantalGetallenTotGrens, grens);
    }
}
