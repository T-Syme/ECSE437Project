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

    public void addPlayer(String name) {
        players.add(new Player(name));
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public int getPlayersSize() {
        return players.size();
    }

    public boolean containsPlayer(String newName) {
        for (Player player : this.players) {
            if (player.getPlayerName().equals(newName)) {
                return true;
            }
        }
        return false;
    }
}
