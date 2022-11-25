public class Player {
    private String playerName;
    private int numOfWins;
    private GameBoard gameBoard;

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Player(String playerName) {
        this.playerName = playerName;
        this.numOfWins = 0;
        this.gameBoard = new GameBoard();
    }

    public String getPlayerName() {
        return playerName;
    }
}
