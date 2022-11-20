public class GameBoard {
    private static final int boardSize = 5;

    /**
     * These string values, GREEN and RESET, were retrieved from the following source:
     * https://www.geeksforgeeks.org/how-to-print-colored-text-in-java-console/
     * Data accessed: November 20th, 2022
     */
    private static final String GREEN = "\u001B[32m";
    private static final String RESET = "\u001B[0m";

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

    /**
     * Prints Bingo game board in a grid
     */
    public void printBoard() {
        printRowLines();
        System.out.println("|  B  |  I  |  N  |  G  |  O  |");
        printRowLines();
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {

                //Prints X for free square
                if (row == boardSize / 2 && col == boardSize / 2) {
                    System.out.print("|  " + GREEN + "X" + RESET + "  ");
                }
                else {
                    //Adds one less space for numbers with two digits
                    if (this.board[row][col].getValue() > 9) {
                        System.out.print("| " + getSquareValueColoured(this.board[row][col]) + "  ");
                    }
                    else {
                        System.out.print("|  " + getSquareValueColoured(this.board[row][col]) + "  ");
                    }
                }
            }
            System.out.println("|");
            printRowLines();
        }
    }

    /**
     * Helper method which prints dashed lines to be placed between the rows of the Bingo game board.
     */
    private void printRowLines() {
        for (int i = 0; i < boardSize; i++) {
            System.out.print("------");
        }
        System.out.println("-");
    }

    /**
     * Gets the value of the game board square which is coloured green if the square has been covered
     * @param square
     * @return String
     */
    private String getSquareValueColoured(GameBoardSquare square) {
        if (square.isCovered()) {
            return (GREEN + square.getValue() + RESET);
        }
        else {
            return Integer.toString(square.getValue());
        }
    }
}
