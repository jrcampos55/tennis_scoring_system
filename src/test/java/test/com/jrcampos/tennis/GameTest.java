package test.com.jrcampos.tennis;

import com.jrcampos.tennis.Game;
import com.jrcampos.tennis.Match;
import com.jrcampos.tennis.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    int MAX_SET = 1;
    String PLYR_1 = "player 1";
    String PLYR_2 = "player 2";
    String P_1 = "1";
    String P_2 = "2";

    Player player1 = new Player(PLYR_1);
    Player player2 = new Player(PLYR_2);

    Match match = new Match(MAX_SET, player1, player2);
    Game game = new Game(match);

    @Test
    public void pointWonByPlayer1() {
        game.pointWonByPlayer1(); // 15-0
        assertEquals("15-0", game.getFormattedScore());
    }

    @Test
    public void pointWonByPlayer2() {
        game.pointWonByPlayer2(); // 15-15
        assertEquals("0-15", game.getFormattedScore());
    }

    @Test
    public void getScore() {
        game.pointWonByPlayer1(); // 15-0
        game.pointWonByPlayer2(); // 15-0
        assertEquals(1, game.getScore()[0]);
        assertEquals(1, game.getScore()[1]);
    }

    @Test
    public void isGameOver() {
        game.pointWonByPlayer1(); // 15-0
        assertEquals(false, game.isGameOver());
    }

    @Test
    public void isStarted() {
        game.pointWonByPlayer1(); // 15-0
        game.pointWonByPlayer1(); // 15-0
        game.pointWonByPlayer2(); // 15-0
        assertEquals(true, game.isStarted());
    }

    @Test
    public void isTiebreakGame() {
        assertEquals(false, game.isTiebreakGame());
    }

    @Test
    public void getFormattedScore() {
        game.pointWonByPlayer1(); // 15-0
        game.pointWonByPlayer2(); // 15-0
        assertEquals("15-15", game.getFormattedScore());
    }

    @Test
    public void formatGameScore() {
        game.pointWonByPlayer1(); // 15-0
        game.pointWonByPlayer1(); // 30-0
        game.pointWonByPlayer1(); // 40-0
        assertEquals(Integer.toString(40), game.formatGameScore(3));
    }

}