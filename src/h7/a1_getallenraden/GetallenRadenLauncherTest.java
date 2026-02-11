package h7.a1_getallenraden;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vincent Velthuizen
 */
class GetallenRadenLauncherTest {

    @Test
    void randomGetalTest() {
        // Arrange
        int ondergrens = 1;
        int bovengrens = 3;

        // Act
        int gegenereerdGetal = GetallenRadenLauncher.randomGetalTussen(ondergrens, bovengrens);

        // Assert
        assertTrue(gegenereerdGetal >= ondergrens);
        assertTrue(gegenereerdGetal <= bovengrens);
    }

    @Test
    @DisplayName("komt voor in geeft true als het getal voorkomt")
    void komtVoorInGeeftTrueAlsHetGetalVoorkomt() {
        int zoekGetal = 42;
        int[] lijst = {3, 7, 21, 42, 73};

        boolean komtVoor = GetallenRadenLauncher.komtVoorIn(zoekGetal, lijst);

        assertTrue(komtVoor);
    }

    @Test
    @DisplayName("komt voor in geeft false als het getal niet voorkomt")
    void komtVoorInGeeftFalseAlsHetGetalNietVoorkomt() {
        int zoekGetal = 42;
        int[] lijst = {3, 7, 21, 73};

        boolean komtVoor = GetallenRadenLauncher.komtVoorIn(zoekGetal, lijst);

        assertFalse(komtVoor);
    }

}