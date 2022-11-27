import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;
    private static final String NAME = "Someone";

    @BeforeEach
    void setup() {
        player = new Player(NAME);
    }

    @Test
    void getGameBoard() {
        assertNotNull(this.player.getGameBoard());
    }

    @Test
    void getPlayerName() {
        assertEquals(NAME, this.player.getPlayerName());
    }
}