import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameBoardTest {
    private GameBoardSquare board[][];
    private static final int boardSize = 5;

    @BeforeEach
    void setup() {
        this.board = new GameBoard().getBoard();
    }

    @Test
    void testGameBoard() {
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                if (row == 2 && col == 2) {
                    assertTrue(board[row][col].isCovered());
                }

                else {
                    assertFalse(board[row][col].isCovered());
                }
            }
        }

    }
}
