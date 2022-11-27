import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomValueTest {

    private RandomValue randomValue;
    private static final int COL = 2;
    private static final int NUM = 2;

    @BeforeEach
    void setup() {
        randomValue = new RandomValue(COL, NUM);
    }

    @Test
    void getColumn() {
        assertEquals(COL, randomValue.getColumn());
    }

    @Test
    void getNumber() {
        assertEquals(NUM, randomValue.getNumber());
    }
}