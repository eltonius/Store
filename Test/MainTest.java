import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {


    @Test
    void checkToSeeIf_firstLetterToUpperCase_Works() {


        String testInput = "teSTer";

        String testResult = Main.firstLetterToUppercase(testInput);

        assertEquals("Tester", testResult);
    }

    @Test
    void checkingIfFirstLetterChanges(){

        String testInput = "test";

        String testResult = Main.firstLetterToUppercase(testInput);

        assertEquals("Test", testResult);

    }
}
