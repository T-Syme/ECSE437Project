import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;
    private Player player;
    private static final String name = "Someone";

    @BeforeEach
    void setup() {
        game = new Game();
        player = new Player(name);
    }

    @Test
    void getWinners() {
        assertEquals(new ArrayList<>(), game.getWinners());
    }

    @Test
    void addWinner() {
        game.addWinner(player);
        assertEquals(1, game.getWinners().size());
        assertEquals(player, game.getWinners().get(0));
    }

    @Test
    void getPlayers() {
        assertEquals(new ArrayList<>(), game.getPlayers());
    }

    @Test
    void addPlayer() {
        game.addPlayer(player.getPlayerName());
        assertEquals(game.getPlayers().size(), 1);
        assertEquals(player.getPlayerName(), game.getPlayers().get(0).getPlayerName());
    }

    @Test
    void getPlayersSize() {
        game.addPlayer(player.getPlayerName());
        assertEquals(1, game.getPlayersSize());
    }

    @Test
    void containsPlayer() {
        game.addPlayer(player.getPlayerName());
        assertTrue(game.containsPlayer(player.getPlayerName()));
    }

    @Test
    void containsPlayerWithoutPlayer() {
        assertFalse(game.containsPlayer(player.getPlayerName()));
    }

    @Test
    void getBingoColumnLetter() {
        assertEquals("B", game.getBingoColumnLetter(0));
        assertEquals("I", game.getBingoColumnLetter(1));
        assertEquals("N", game.getBingoColumnLetter(2));
        assertEquals("G", game.getBingoColumnLetter(3));
        assertEquals("O", game.getBingoColumnLetter(4));
        assertEquals("", game.getBingoColumnLetter(5));
    }


}