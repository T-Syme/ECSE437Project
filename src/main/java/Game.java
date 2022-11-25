import Exceptions.RandomGeneratorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static final int BOARD_SIZE = 5;

    private final ArrayList<Player> winners;
    private final ArrayList<Player> players;

    public Game() {
        winners = new ArrayList<>();
        players = new ArrayList<>();
    }

    public void addWinner(Player player) {
        winners.add(player);
    }

    public void addPlayer(String name) {
        players.add(new Player(name));
    }

    public List<Player> getPlayers() {
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
    
    public void playGame(Scanner scanner) {
        RandomGenerator generator = new RandomGenerator();
        for (Player player : players) {
            System.out.println("\n" + player.getPlayerName() + "'s board is:");
            player.getGameBoard().printBoard();
        }

        while (!this.winners.isEmpty()) {

            System.out.println("\nPlease press enter to generate the next Bingo value");
            scanner.nextLine();

            RandomValue value;

            try {
                value = generator.getNextValue();
            } catch (RandomGeneratorException e) {
                System.out.println(e.getMessage());
                return;
            }

            int col = value.getColumn();
            System.out.println("The Bingo value is: " + getBingoColumnLetter(col) + value.getNumber());

            for (Player player : players) {
                GameBoard board = player.getGameBoard();

                for (int row = 0; row < BOARD_SIZE; row++) {
                    if (board.getBoard()[row][col].getValue() == value.getNumber()) {
                        System.out.println("\n" + player.getPlayerName() + " has a match!");
                        board.getBoard()[row][col].setCovered(true);
                        break;
                    }
                }

                checkWin(board, player);

                System.out.println("\n" + player.getPlayerName() + "'s board");
                board.printBoard();
            }
        }

        System.out.println("\nThe winners are:");

        for (Player player : winners) {
            System.out.println(player.getPlayerName());
        }
    }

    private void checkWin(GameBoard board, Player player) {
        if (board.checkBoard()) {
            addWinner(player);
        }
    }

    private String getBingoColumnLetter(int col) {
        return switch (col) {
            case 0 -> "B";
            case 1 -> "I";
            case 2 -> "N";
            case 3 -> "G";
            case 4 -> "O";
            default -> "";
        };
    }
}
