import java.util.ArrayList;

public class Game {
    private static final int BOARD_SIZE = 5;

    private ArrayList<Player> winners;
    private ArrayList<Player> players;

    public Game() {
        winners = new ArrayList<>();
        players = new ArrayList<Player>();
    }

    public void addWinner(Player player) {
        winners.add(player);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public int getPlayersSize() {
        return players.size();
    }

    public void playGame() {
        RandomGenerator generator = new RandomGenerator();
        while (true) {
            RandomValue value = null;
            try {
                value = generator.getNextValue();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }

            for (Player player : players) {
                GameBoard board = player.getGameBoard();
                int col = value.getColumn();

                for (int row = 0; row < BOARD_SIZE; row++) {
                    if (board.getBoard()[row][col].getValue() == value.getNumber()) {
                        board.getBoard()[row][col].setCovered(true);
                    }
                }

                if (board.checkBoard()) {
                    addWinner(player);
                }

                System.out.println(player.getPlayerName() + "'s board\n");
                board.printBoard();
            }

            if (this.winners.size() != 0) {
                break;
            }
        }
    }
}
