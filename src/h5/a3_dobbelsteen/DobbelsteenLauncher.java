package h5.a3_dobbelsteen;

import java.util.Scanner;

/**
 * @author Vincent Velthuizen
 * Gooi en toon een dobbelsteen tot er 6 wordt gegooid.
 */
public class DobbelsteenLauncher {

    private static final int HOOGSTE_WORP_DOBBELSTEEN = 6;

    public static void main(String[] args) {
        Scanner toetsenbord = new Scanner(System.in);

        System.out.print("Welk karakter moet ik gebruiken voor het oog? ");
        char oog = toetsenbord.next().charAt(0);

        int worp;
        do {
            worp = werpDobbelsteen();
            System.out.println();

            // Ik toon de dobbelsteen dus steeds twee keer om te laten zien dat beide methoden gelijk zijn.
            toonDobbelsteenV1(worp, oog);
            toonDobbelsteenV2(worp, (char) (oog + 1));
        } while (worp != 6);
    }

    public static int werpDobbelsteen() {
        // we nemen aan dat alle dobbelstenen bij 1 beginnen.
        return (int) (Math.random() * HOOGSTE_WORP_DOBBELSTEEN) + 1;
    }

    public static void toonDobbelsteenV1(int mpWorp, char mpOog) {
        switch (mpWorp) {
            case 1:
                System.out.printf("\n %c\n", mpOog);
                break;
            case 2:
                System.out.printf("%c\n\n  %c", mpOog, mpOog);
                break;
            case 3:
                System.out.printf("%c\n %c\n  %c", mpOog, mpOog, mpOog);
                break;
            case 4:
                System.out.printf("%c %c\n\n%c %c", mpOog, mpOog, mpOog, mpOog);
                break;
            case 5:
                System.out.printf("%c %c\n %c\n%c %c", mpOog, mpOog, mpOog, mpOog, mpOog);
                break;
            case 6:
                System.out.printf("%c %c\n%c %c\n%c %c", mpOog, mpOog, mpOog, mpOog, mpOog, mpOog);
                break;
            default:
                System.out.println("Er is iets fout gegaan.");
        }
        System.out.println();
    }

    public static void toonDobbelsteenV2(int mpWorp, char mpOog) {
        String dobbelsteen;

        switch (mpWorp) {
            case 1:
                dobbelsteen = "\n #\n";
                break;
            case 2:
                dobbelsteen = "#\n\n  #";
                break;
            case 3:
                dobbelsteen = "#\n #\n  #";
                break;
            case 4:
                dobbelsteen = "# #\n\n# #";
                break;
            case 5:
                dobbelsteen = "# #\n #\n# #";
                break;
            case 6:
                dobbelsteen = "# #\n# #\n# #";
                break;
            default:
                dobbelsteen = "Er is iets fout gegaan. Je gooide: " + mpWorp;
        }

        System.out.println(dobbelsteen.replace('#', mpOog));
    }
}
