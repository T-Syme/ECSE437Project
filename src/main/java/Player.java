public class Player {
    private String playerName;
    private GameBoard gameBoard;

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Player(String playerName) {
        this.playerName = playerName;
        this.gameBoard = new GameBoard();
    }

    public String getPlayerName() {
        return playerName;
    }
}
