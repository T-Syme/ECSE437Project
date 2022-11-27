import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardSquareTest {

    private GameBoardSquare gameBoardSquare;
    private static final int VAL = 2;
    private static final boolean COVERED = true;

    @BeforeEach
    void setup() {
        gameBoardSquare = new GameBoardSquare();
    }

    @Test
    void getSetValue() {
        gameBoardSquare.setValue(VAL);
        assertEquals(VAL, gameBoardSquare.getValue());
    }

    @Test
    void getSetCovered() {
        gameBoardSquare.setCovered(COVERED);
        assertEquals(COVERED, gameBoardSquare.isCovered());
    }
}