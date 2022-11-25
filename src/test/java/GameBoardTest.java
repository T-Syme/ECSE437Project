import exceptions.RandomGeneratorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameBoardTest {
    private GameBoard gameBoard;
    private GameBoardSquare[][] board;
    private static final int BOARD_SIZE = 5;

    @Mock
    RandomGenerator generator;

    @BeforeEach
    void setup() {
        this.gameBoard = new GameBoard();
    }

    @Test
    void testSetUpGameBoard() throws RandomGeneratorException {
        when(generator.getNextNumber()).thenReturn(1);
        this.gameBoard.setGenerator(generator);
        this.gameBoard.setUpGameBoard();
        this.board = this.gameBoard.getBoard();

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (row == BOARD_SIZE / 2 && col == BOARD_SIZE / 2) {
                    assertTrue(board[row][col].isCovered());
                }
                else {
                    assertFalse(board[row][col].isCovered());
                }
            }
        }
    }

    /**
     * Method: checkBoard()
     * Verify that it finds a win in a row
     */
    @Test
    void testCheckBoardRow() throws RandomGeneratorException {
        when(generator.getNextNumber()).thenReturn(1);
        this.gameBoard.setGenerator(generator);
        this.gameBoard.setUpGameBoard();
        this.board = this.gameBoard.getBoard();

        for (int col = 0; col < BOARD_SIZE; col++) {
            this.board[0][col].setCovered(true);
        }
        assertTrue(this.gameBoard.checkBoard());
    }

    /**
     * Method: checkBoard()
     * Verify that it finds a win in a column
     */
    @Test
    void testCheckBoardCol() throws RandomGeneratorException {
        when(generator.getNextNumber()).thenReturn(1);
        this.gameBoard.setGenerator(generator);
        this.gameBoard.setUpGameBoard();
        this.board = this.gameBoard.getBoard();

        for (int row = 0; row < BOARD_SIZE; row++) {
            this.board[row][0].setCovered(true);
        }
        assertTrue(this.gameBoard.checkBoard());
    }

    /**
     * Method: checkBoard()
     * Verify that it finds a win in a diagonal (1)
     */
    @Test
    void testCheckBoardDiagonal1() throws RandomGeneratorException {
        when(generator.getNextNumber()).thenReturn(1);
        this.gameBoard.setGenerator(generator);
        this.gameBoard.setUpGameBoard();
        this.board = this.gameBoard.getBoard();

        for (int i = 0; i < BOARD_SIZE; i++) {
            this.board[i][i].setCovered(true);
        }
        assertTrue(this.gameBoard.checkBoard());
    }

    /**
     * Method: checkBoard()
     * Verify that it finds a win in a diagonal (2)
     */
    @Test
    void testCheckBoardDiagonal2() throws RandomGeneratorException {
        when(generator.getNextNumber()).thenReturn(1);
        this.gameBoard.setGenerator(generator);
        this.gameBoard.setUpGameBoard();
        this.board = this.gameBoard.getBoard();
        for (int i = 0; i < BOARD_SIZE; i++) {
            this.board[i][BOARD_SIZE - 1 - i].setCovered(true);
        }
        assertTrue(this.gameBoard.checkBoard());
    }

    /**
     * Method: checkBoard()
     * Verify that it does not find a win
     */
    @Test
    void testCheckBoardNoWin() throws RandomGeneratorException {
        when(generator.getNextNumber()).thenReturn(1);
        this.gameBoard.setGenerator(generator);
        this.gameBoard.setUpGameBoard();
        this.board = this.gameBoard.getBoard();
        assertFalse(this.gameBoard.checkBoard());
    }
}
