package main.java;

public class Player {
    private String playerName;
    private int numOfWins;

    public Player(String playerName) {
        this.playerName = playerName;
        this.numOfWins = 0;
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
