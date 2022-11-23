import java.util.ArrayList;
import java.util.Scanner;

public class BingoApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Bingo!");

        Scanner reader = new Scanner(System.in);

        char nextGame;

        do {
            System.out.println("Starting a new game...");

            ArrayList<String> names = new ArrayList<>();
            String line;

            while (names.size() < 5) {
                System.out.println("Please enter a player's name and press enter");
                System.out.println("When all players have been added, press enter");
                line = reader.nextLine();
                if (line.isEmpty() && names.size() < 2) {
                    System.out.println("There must be at least 2 players (max. 5)");
                } else if (line.isEmpty()) {
                    break;
                } else {
                    names.add(line);
                }
            }

            System.out.println(names);

            // Main logic



            System.out.println("Would you like to play another game? (Y/N)");
            nextGame = reader.nextLine().charAt(0);

        } while (nextGame == 'Y' || nextGame == 'y');

        System.out.println("Thanks for playing!");

        reader.close();
    }
}
