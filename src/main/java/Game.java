import java.util.ArrayList;
import java.util.Scanner;

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
        for (Player player : players) {
            System.out.println("\n" + player.getPlayerName() + "'s board is:");
            player.getGameBoard().printBoard();
        }

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\nPlease press enter to generate the next Bingo value");
            scanner.nextLine();

            RandomValue value = null;

            try {
                value = generator.getNextValue();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }

            int col = value.getColumn();
            System.out.println("The Bingo value is: " + getBingoColumnLetter(col) + value.getNumber());

            for (Player player : players) {
                GameBoard board = player.getGameBoard();

                for (int row = 0; row < BOARD_SIZE; row++) {
                    if (board.getBoard()[row][col].getValue() == value.getNumber()) {
                        System.out.println(player.getPlayerName() + " has a match!");
                        board.getBoard()[row][col].setCovered(true);
                        break;
                    }
                }

                if (board.checkBoard()) {
                    addWinner(player);
                }

                System.out.println("\n" + player.getPlayerName() + "'s board");
                board.printBoard();
            }

            if (this.winners.size() != 0) {
                break;
            }
        }

        System.out.println("The winners are:");

        for (Player player : winners) {
            System.out.println(player.getPlayerName());
        }
    }

    private String getBingoColumnLetter(int col) {
        switch(col) {
            case 0:
                return "B";
            case 1:
                return "I";
            case 2:
                return "N";
            case 3:
                return "G";
            case 4:
                return "O";
            default:
                return "";
        }
    }
}
