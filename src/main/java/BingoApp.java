import java.util.ArrayList;
import java.util.Scanner;

public class BingoApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Bingo!");

        Scanner reader = new Scanner(System.in);
        String nextGame;

        do {
            System.out.println("Starting a new game...");

            String line;
            Game game = new Game();

            while (game.getPlayersSize() < 5) {
                System.out.println("Please enter a player's name and press enter");
                System.out.println("When all players have been added, press enter");

                line = reader.nextLine();

                if (game.containsPlayer(line)) {
                    System.out.println("Names cannot be repeated");
                } else if (line.isEmpty() && game.getPlayersSize() < 2) {
                    System.out.println("There must be at least 2 players (max. 5)");
                } else if (line.isEmpty()) {
                    break;
                } else {
                    game.addPlayer(line);
                }
            }

            System.out.println(game.getPlayers());

            // Main logic
            game.playGame();


            System.out.println("Would you like to play another game? Type \"Y\" to continue, otherwise hit enter");
            try {
                nextGame = reader.nextLine();
            } catch (Exception e) {
                break;
            }

        } while (nextGame.length() > 0 && (nextGame.charAt(0) == 'Y' || nextGame.charAt(0) == 'y'));

        System.out.println("Thanks for playing!");

        reader.close();
    }
}
