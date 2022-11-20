public class Player {
    private String playerName;
    private int numOfWins;
    private GameBoard gameBoard;

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Player(String playerName) {
        this.playerName = playerName;
        this.numOfWins = 0;
        this.gameBoard = new GameBoard();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getNumOfWins() {
        return numOfWins;
    }

    public void setNumOfWins(int numOfWins) {
        this.numOfWins = numOfWins;
    }
}
