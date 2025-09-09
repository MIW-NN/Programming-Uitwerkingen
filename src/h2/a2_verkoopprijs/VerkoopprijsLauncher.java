package h2.a2_verkoopprijs;

import java.util.Scanner;

/**
 * @author Vincent Velthuizen
 * Bereken de verkoopprijs van een artikel op basis van de inkoopprijs, winstmarge en het btw-tarief.
 */
public class VerkoopprijsLauncher {

    private static final int BTW_TARIEF_VRIJGESTELD = 0;
    private static final int BTW_TARIEF_HOOG = 21;
    private static final int BTW_TARIEF_LAAG = 9;

    public static void main(String[] args) {
        Scanner toetsenbord = new Scanner(System.in);

        System.out.print("Inkoopprijs: ");
        double inkoopprijs = toetsenbord.nextDouble();

        System.out.print("Winstmarge (in %): ");
        double winstmarge = toetsenbord.nextDouble();
        double winstmargeFactor = winstmarge / 100.0;

        double prijsExclusiefBtw = inkoopprijs * (1 + winstmargeFactor);

        System.out.println();
        System.out.println("Verkoopprijs exclusief btw: " + prijsExclusiefBtw);

        System.out.println();
        System.out.println("""
                Onder welk btw-tarief valt het product?
                \t0 Vrijgesteld
                \t1 Hoog
                \t2 Laag""");
        System.out.print("Geef je keuze: ");

        int btwKeuze = toetsenbord.nextInt();
        int btwTarief;

        switch (btwKeuze) {
            case 1:
                btwTarief = BTW_TARIEF_HOOG;
                break;
            case 2:
                btwTarief = BTW_TARIEF_LAAG;
                break;
            case 0:
            default:
                btwTarief = BTW_TARIEF_VRIJGESTELD;
        }

        double verkoopprijs = prijsExclusiefBtw * (1 + btwTarief / 100.0);

        System.out.println();
        System.out.println("Verkoopprijs inclusief " + btwTarief + "% btw: " + verkoopprijs);
    }

}
