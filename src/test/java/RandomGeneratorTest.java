
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomGeneratorTest {

    private static final int MIN_VAL = 1;
    private static final int MAX_VAL = 75;
    private static final int COLUMNS = 5;
    private RandomGenerator randomGenerator;

    @BeforeEach
    void setup() {
        this.randomGenerator = new RandomGenerator();
    }

    /**
     * Method: getNextNumber()
     * Verify that it always returns valid int
     */
    @Test
    void testGetNextNumber() {
        try {
            for (int i = MIN_VAL; i <= MAX_VAL; i++) {
                int val = randomGenerator.getNextNumber();
                assertTrue(val >= MIN_VAL);
                assertTrue(val <= MAX_VAL);
            }
        } catch (Exception e) {
            fail("getNextNumber() unexpectedly did not get another number");
        }
    }

    /**
     * Method: getNextNumber()
     * Verify that it throws an exception after calling it too many times
     */
    @Test
    void testGetNextNumber_NoMoreNumbers() {
        try {
            for (int i = MIN_VAL; i <= MAX_VAL + 1; i++) {
                randomGenerator.getNextNumber();
            }
            fail("getNextNumber() did not raise an exception when it should have");
        } catch (Exception e) {
            assertEquals("No more numbers", e.getMessage());
        }
    }

    /**
     * Method: getNextValue()
     * Verify that it always returns valid RandomValue with a column and number
     */
    @Test
    void testGetNextValue() {
        try {
            for (int i = MIN_VAL; i <= MAX_VAL * COLUMNS; i++) {
                RandomValue randomValue = randomGenerator.getNextValue();
                assertTrue(randomValue.getColumn() >= 0);
                assertTrue(randomValue.getColumn() < COLUMNS);
                assertTrue(randomValue.getNumber() >= MIN_VAL);
                assertTrue(randomValue.getNumber() <= MAX_VAL);
            }
        } catch (Exception e) {
            fail("getNextValue() unexpectedly did not get another number");
        }
    }

    /**
     * Method: getNextValue()
     * Verify that it throws an exception after calling it too many times
     */
    @Test
    void testGetNextValue_NoMoreValues() {
        try {
            for (int i = MIN_VAL; i <= MAX_VAL * COLUMNS + 1; i++) {
                randomGenerator.getNextValue();
            }
            fail("getNextValue() did not raise an exception when it should have");
        } catch (Exception e) {
            assertEquals("No more values", e.getMessage());
        }
    }

}
