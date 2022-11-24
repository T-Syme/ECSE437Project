import java.util.ArrayList;

public class Game {
    private Player winner;
    private ArrayList<Player> players;

    public Game() {
        players = new ArrayList<Player>();
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public int getPlayersSize() {
        return players.size();
    }
}
