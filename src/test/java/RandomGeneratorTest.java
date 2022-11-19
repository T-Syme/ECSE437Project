
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomGeneratorTest {

    private static final int minVal = 1;
    private static final int maxVal = 99;
    private RandomGenerator randomGenerator;

    @BeforeEach
    void setup() {
        this.randomGenerator = new RandomGenerator();
    }

    /**
     * Method: getNext()
     * Verify that it always returns valid int
     */
    @Test
    void testGetNext() {
        try {
            for (int i = minVal; i <= maxVal; i++) {
                int val = randomGenerator.getNext();
                assertTrue(val >= minVal);
                assertTrue(val <= maxVal);
            }
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Method: getNext()
     * Verify that it throws an exception after calling it too many times
     */
    @Test
    void testGetNext_NoMoreValues() {
        try {
            for (int i = minVal; i <= maxVal + 1; i++) {
                randomGenerator.getNext();
            }
            fail();
        } catch (Exception e) {
            assertEquals("No more values", e.getMessage());
        }
    }

}
