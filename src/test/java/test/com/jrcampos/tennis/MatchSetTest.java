package test.com.jrcampos.tennis;

import com.jrcampos.tennis.Match;
import com.jrcampos.tennis.MatchSet;
import com.jrcampos.tennis.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatchSetTest {

    int MAX_SET = 1;
    String PLYR_1 = "player 1";
    String PLYR_2 = "player 2";
    String P_1 = "1";
    String P_2 = "2";

    Player player1 = new Player(PLYR_1);
    Player player2 = new Player(PLYR_2);

    Match match = new Match(MAX_SET, player1, player2);
    MatchSet matchSet = new MatchSet(match);

    @Test
    public void pointWonByPlayer1() {
        matchSet.pointWonByPlayer1(); // 0-0, 15-0
        matchSet.pointWonByPlayer1(); // 0-0, 30-0
        matchSet.pointWonByPlayer1(); // 0-0, 40-0
        assertEquals("0-0, 40-0", matchSet.getFormattedScore());
    }

    @Test
    public void pointWonByPlayer2() {
        matchSet.pointWonByPlayer1(); // 0-0, 15-0
        matchSet.pointWonByPlayer1(); // 0-0, 30-0
        matchSet.pointWonByPlayer1(); // 0-0, 40-0
        matchSet.pointWonByPlayer2(); // 0-0, 40-15
        matchSet.pointWonByPlayer2(); // 0-0, 40-30
        assertEquals("0-0, 40-30", matchSet.getFormattedScore());
    }

    @Test
    public void deuce() {
        matchSet.pointWonByPlayer1(); // 0-0, 15-0
        matchSet.pointWonByPlayer1(); // 0-0, 30-0
        matchSet.pointWonByPlayer1(); // 0-0, 40-0
        matchSet.pointWonByPlayer2(); // 0-0, 15-15
        matchSet.pointWonByPlayer2(); // 0-0, 40-30
        matchSet.pointWonByPlayer2(); // 0-0, Deuce
        assertEquals("0-0, Deuce", matchSet.getFormattedScore());
    }

    @Test
    public void getFormattedScore() {
        matchSet.pointWonByPlayer2(); // 0-0, 0-15
        assertEquals("0-0, 0-15", matchSet.getFormattedScore());
    }

    @Test
    public void getScore() {
        matchSet.pointWonByPlayer2(); // 0-0, 0-15
        matchSet.pointWonByPlayer2(); // 0-0, 0-30
        matchSet.pointWonByPlayer2(); // 0-0, 0-40
        matchSet.pointWonByPlayer2(); // 0-1
        assertEquals(0, matchSet.getScore()[0]);
        assertEquals(1, matchSet.getScore()[1]);
    }

    @Test
    public void isSetOver() {

        matchSet.pointWonByPlayer1(); // 0-0, 15-0
        matchSet.pointWonByPlayer1(); // 0-0, 30-0
        matchSet.pointWonByPlayer1(); // 0-0, 40-0
        matchSet.pointWonByPlayer1(); // 1-0

        matchSet.pointWonByPlayer1(); // 1-0, 15-0
        matchSet.pointWonByPlayer1(); // 1-0, 30-0
        matchSet.pointWonByPlayer1(); // 1-0, 40-0
        matchSet.pointWonByPlayer1(); // 2-0

        matchSet.pointWonByPlayer1(); // 2-0, 15-0
        matchSet.pointWonByPlayer1(); // 2-0, 30-0
        matchSet.pointWonByPlayer1(); // 2-0, 40-0
        matchSet.pointWonByPlayer1(); // 3-0

        matchSet.pointWonByPlayer1(); // 3-0, 15-0
        matchSet.pointWonByPlayer1(); // 3-0, 30-0
        matchSet.pointWonByPlayer1(); // 3-0, 40-0
        matchSet.pointWonByPlayer1(); // 4-0

        matchSet.pointWonByPlayer1(); // 4-0, 15-0
        matchSet.pointWonByPlayer1(); // 4-0, 30-0
        matchSet.pointWonByPlayer1(); // 4-0, 40-0
        matchSet.pointWonByPlayer1(); // 5-0

        matchSet.pointWonByPlayer2(); // 5-0, 0-15
        matchSet.pointWonByPlayer2(); // 5-0, 0-30
        matchSet.pointWonByPlayer2(); // 5-0, 0-40
        matchSet.pointWonByPlayer2(); // 5-1

        matchSet.pointWonByPlayer2(); // 5-1, 0-15
        matchSet.pointWonByPlayer2(); // 5-1, 0-30
        matchSet.pointWonByPlayer2(); // 5-1, 0-40
        matchSet.pointWonByPlayer2(); // 5-2

        matchSet.pointWonByPlayer2(); // 5-2, 0-15
        matchSet.pointWonByPlayer2(); // 5-2, 0-30
        matchSet.pointWonByPlayer2(); // 5-2, 0-40
        matchSet.pointWonByPlayer2(); // 5-3

        matchSet.pointWonByPlayer2(); // 5-3, 0-15
        matchSet.pointWonByPlayer2(); // 5-3, 0-30
        matchSet.pointWonByPlayer2(); // 5-3, 0-40
        matchSet.pointWonByPlayer2(); // 5-4

        matchSet.pointWonByPlayer2(); // 5-4, 0-15
        matchSet.pointWonByPlayer2(); // 5-4, 0-30
        matchSet.pointWonByPlayer2(); // 5-4, 0-40
        matchSet.pointWonByPlayer2(); // 5-5

        matchSet.pointWonByPlayer2(); // 5-5, 0-15
        matchSet.pointWonByPlayer2(); // 5-5, 0-30
        matchSet.pointWonByPlayer2(); // 5-5, 0-40
        matchSet.pointWonByPlayer2(); // 5-6

        matchSet.pointWonByPlayer1(); // 5-6, 15-0
        matchSet.pointWonByPlayer1(); // 5-6, 30-0
        matchSet.pointWonByPlayer1(); // 5-6, 40-0
        matchSet.pointWonByPlayer1(); // 6-6

        matchSet.pointWonByPlayer1(); // 6-6, 1-0
        matchSet.pointWonByPlayer1(); // 6-6, 2-0
        matchSet.pointWonByPlayer1(); // 6-6, 3-0
        matchSet.pointWonByPlayer1(); // 6-6, 4-0
        matchSet.pointWonByPlayer1(); // 6-6, 5-0
        matchSet.pointWonByPlayer1(); // 6-6, 6-0
        matchSet.pointWonByPlayer2(); // 6-6, 6-1
        matchSet.pointWonByPlayer2(); // 6-6, 6-2
        matchSet.pointWonByPlayer2(); // 6-6, 6-3
        matchSet.pointWonByPlayer2(); // 6-6, 6-4
        matchSet.pointWonByPlayer2(); // 6-6, 6-5
        matchSet.pointWonByPlayer2(); // 6-6, 6-6
        matchSet.pointWonByPlayer2(); // 6-6, 6-7
        assertEquals(false, matchSet.isSetOver());
        matchSet.pointWonByPlayer2(); // 6-6, 6-8
        assertEquals("6-7", matchSet.getFormattedScore());
        assertEquals(true, matchSet.isSetOver());
    }
}