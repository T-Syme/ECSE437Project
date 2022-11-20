public class GameBoard {
    private static final int boardSize = 5;
    private GameBoardSquare board[][];

    /**
     * Generates a 5x5 bingo game board.
     * Each square in the board corresponds to a number from 1 to 75, except the middle square which is a free slot.
     */
    public GameBoard() {
        board = new GameBoardSquare[boardSize][boardSize];
        RandomGenerator iterator = new RandomGenerator();

        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                board[row][col] = new GameBoardSquare();

                if (row == 3 && col == 3) {
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
