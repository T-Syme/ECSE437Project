public class Player {
    private final String playerName;
    private final GameBoard gameBoard;

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
