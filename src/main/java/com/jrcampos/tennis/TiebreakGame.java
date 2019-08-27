package com.jrcampos.tennis;

import static com.jrcampos.tennis.Constants.PLAYER_1;
import static com.jrcampos.tennis.Constants.PLAYER_2;

/**
 * This class models a 'Tiebreak' Game in a Set.
 */
public class TiebreakGame extends Game {

    public TiebreakGame(Match match) {
        super(match);
    }

    void executeRules() {
        int diff1 = score[PLAYER_1] - score[PLAYER_2];
        int diff2 = score[PLAYER_2] - score[PLAYER_1];

        if ((score[PLAYER_1] >= 7 && diff1 >= 2) || (score[PLAYER_2] >= 7 && diff2 >= 2)) {
            isGameOver = true;
            return;
        }
    }

    /**
     * Override methods
     */

    @Override
    public String getFormattedScore() {
        return String.format("%s-%s", formatGameScore(score[PLAYER_1]), formatGameScore(score[PLAYER_2]));
    }

    @Override
    public String formatGameScore(int pointScore) {
        return String.valueOf(pointScore);
    }

    @Override
    public boolean isTiebreakGame() {
        return true;
    }

}
