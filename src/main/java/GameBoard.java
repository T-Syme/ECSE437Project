public class GameBoard {
    private static final int BOARD_SIZE = 5;
    private GameBoardSquare board[][];

    /**
     * Generates a 5x5 bingo game board.
     * Each square in the board corresponds to a number from 1 to 75, except the middle square which is a free slot.
     */
    public GameBoard() {
        board = new GameBoardSquare[BOARD_SIZE][BOARD_SIZE];
        RandomGenerator iterator = new RandomGenerator();

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                board[row][col] = new GameBoardSquare();

                if (row == BOARD_SIZE / 2 && col == BOARD_SIZE / 2) {
                    board[row][col].setCovered(true);
                }

                else {
                    try {
                        board[row][col].setValue(iterator.getNextNumber());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
            }
        }
    }

    public GameBoardSquare[][] getBoard() {
        return board;
    }
}
