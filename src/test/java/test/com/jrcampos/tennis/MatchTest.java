package test.com.jrcampos.tennis;

import com.jrcampos.tennis.Match;
import com.jrcampos.tennis.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatchTest {

    int MAX_SET = 1;
    String PLYR_1 = "player 1";
    String PLYR_2 = "player 2";
    String P_1 = "1";
    String P_2 = "2";

    Player player1 = new Player(PLYR_1);
    Player player2 = new Player(PLYR_2);

    Match match = new Match(MAX_SET, player1, player2);

    @Before
    public void setUp() throws Exception {

        match.pointWonBy(PLYR_1); // 0-0, 15-0
        match.pointWonBy(PLYR_1); // 0-0, 30-0
        match.pointWonBy(PLYR_1); // 0-0, 40-0
        match.pointWonBy(PLYR_1); // 1-0

        match.pointWonBy(PLYR_1); // 1-0, 15-0
        match.pointWonBy(PLYR_1); // 1-0, 30-0
        match.pointWonBy(PLYR_1); // 1-0, 40-0
        match.pointWonBy(PLYR_1); // 2-0

        match.pointWonBy(PLYR_1); // 2-0, 15-0
        match.pointWonBy(PLYR_1); // 2-0, 30-0
        match.pointWonBy(PLYR_1); // 2-0, 40-0
        match.pointWonBy(PLYR_1); // 3-0

        match.pointWonBy(PLYR_1); // 3-0, 15-0
        match.pointWonBy(PLYR_1); // 3-0, 30-0
        match.pointWonBy(PLYR_1); // 3-0, 40-0
        match.pointWonBy(PLYR_1); // 4-0

        match.pointWonBy(PLYR_1); // 4-0, 15-0
        match.pointWonBy(PLYR_1); // 4-0, 30-0
        match.pointWonBy(PLYR_1); // 4-0, 40-0
        match.pointWonBy(PLYR_1); // 5-0

        match.pointWonBy(PLYR_2); // 5-0, 0-15
        match.pointWonBy(PLYR_2); // 5-0, 0-30
        match.pointWonBy(PLYR_2); // 5-0, 0-40
        match.pointWonBy(PLYR_2); // 5-1

        match.pointWonBy(PLYR_2); // 5-1, 0-15
        match.pointWonBy(PLYR_2); // 5-1, 0-30
        match.pointWonBy(PLYR_2); // 5-1, 0-40
        match.pointWonBy(PLYR_2); // 5-2

        match.pointWonBy(PLYR_2); // 5-2, 0-15
        match.pointWonBy(PLYR_2); // 5-2, 0-30
        match.pointWonBy(PLYR_2); // 5-2, 0-40
        match.pointWonBy(PLYR_2); // 5-3

        match.pointWonBy(PLYR_2); // 5-3, 0-15
        match.pointWonBy(PLYR_2); // 5-3, 0-30
        match.pointWonBy(PLYR_2); // 5-3, 0-40
        match.pointWonBy(PLYR_2); // 5-4

        match.pointWonBy(PLYR_2); // 5-4, 0-15
        match.pointWonBy(PLYR_2); // 5-4, 0-30
        match.pointWonBy(PLYR_2); // 5-4, 0-40
        match.pointWonBy(PLYR_2); // 5-5

        match.pointWonBy(PLYR_2); // 5-5, 0-15
        match.pointWonBy(PLYR_2); // 5-5, 0-30
        match.pointWonBy(PLYR_2); // 5-5, 0-40
        match.pointWonBy(PLYR_2); // 5-6

        match.pointWonBy(PLYR_1); // 5-6, 15-0
        match.pointWonBy(PLYR_1); // 5-6, 30-0
        match.pointWonBy(PLYR_1); // 5-6, 40-0
        match.pointWonBy(PLYR_1); // 6-6

        match.pointWonBy(PLYR_1); // 6-6, 1-0
        match.pointWonBy(PLYR_1); // 6-6, 2-0
        match.pointWonBy(PLYR_1); // 6-6, 3-0
        match.pointWonBy(PLYR_1); // 6-6, 4-0
        match.pointWonBy(PLYR_1); // 6-6, 5-0
        match.pointWonBy(PLYR_1); // 6-6, 6-0
        match.pointWonBy(PLYR_2); // 6-6, 6-1
        match.pointWonBy(PLYR_2); // 6-6, 6-2
        match.pointWonBy(PLYR_2); // 6-6, 6-3
        match.pointWonBy(PLYR_2); // 6-6, 6-4
        match.pointWonBy(PLYR_2); // 6-6, 6-5
        match.pointWonBy(PLYR_2); // 6-6, 6-6
    }

    @Test
    public void player1LeadsSetPoint() throws Exception {
        match.pointWonBy(PLYR_1);
        assertEquals("6-6, 7-6", match.score());
    }

    @Test
    public void player2LeadsSetPoint() throws Exception {
        match.pointWonBy(PLYR_2);
        assertEquals("6-6, 6-7", match.score());
    }

    @Test
    public void getPlayer1() {
        assertEquals(match.getPlayer1().getName(), PLYR_1);
    }

    @Test
    public void getPlayer2() {
        assertEquals(match.getPlayer2().getName(), PLYR_2);
    }

    @Test
    public void player1Leads() throws Exception {

        Match match = new Match(MAX_SET, player1, player2);
        match.pointWonBy(PLYR_1); // 0-0, 15-0
        match.pointWonBy(PLYR_1); // 0-0, 30-0
        match.pointWonBy(PLYR_1); // 0-0, 40-0
        match.pointWonBy(PLYR_1); // 1-0

        match.pointWonBy(PLYR_1); // 1-0, 15-0
        match.pointWonBy(PLYR_1); // 1-0, 30-0
        match.pointWonBy(PLYR_1); // 1-0, 40-0
        match.pointWonBy(PLYR_2); // 1-0, 40-15
        assertEquals("1-0, 40-15", match.score());
        match.pointWonBy(PLYR_1); // 2-0
        assertEquals("2-0", match.score());
    }
}