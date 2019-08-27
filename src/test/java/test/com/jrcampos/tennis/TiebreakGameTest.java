package test.com.jrcampos.tennis;

import com.jrcampos.tennis.Game;
import com.jrcampos.tennis.Match;
import com.jrcampos.tennis.Player;
import com.jrcampos.tennis.TiebreakGame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TiebreakGameTest {

    int MAX_SET = 1;
    String PLYR_1 = "player 1";
    String PLYR_2 = "player 2";
    String P_1 = "1";
    String P_2 = "2";

    Player player1 = new Player(PLYR_1);
    Player player2 = new Player(PLYR_2);

    Match match = new Match(MAX_SET, player1, player2);
    TiebreakGame game = new TiebreakGame(match);

    @Test
    public void getFormattedScore() {
        game.pointWonByPlayer1(); // 15-0
        game.pointWonByPlayer2(); // 15-0
        assertEquals("1-1", game.getFormattedScore());
    }

    @Test
    public void formatGameScore() {
    }

    @Test
    public void isTiebreakGame() {
    }
}