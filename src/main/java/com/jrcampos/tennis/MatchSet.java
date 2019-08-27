package com.jrcampos.tennis;

import static com.jrcampos.tennis.Constants.PLAYER_1;
import static com.jrcampos.tennis.Constants.PLAYER_2;

/**
 * A tennis match has a set.
 */
public class MatchSet {

    /**
     * Array of [gameCtr, minimum-set-points]
     * is used to check if a player wins a set by winning at least 6 games and at least 2 games more than the opponent
     */
    private static final int checkScore[][] = {{6,0}, {7,1}, {8,2}, {9,3}, {10,4}};

    /**
     * The current game being played
     */
    private Game currentGame;

    /**
     * Array that holds the Set score for each player, index = 0 (first player), index = 2 (second player)
     */
    private int[] score = {0, 0};

    /**
     * Number of games played in a set
     */
    private int gameCtr = 0;

    /**
     * Flag to indicate if Set is over
     */
    private boolean isSetOver;

    /**
     * Reference to current match
     */
    private Match match;

    public MatchSet(Match match) {
        this.match = match;
        currentGame = new Game(match);
    }

    /**
     * This method indicates a player 1 winning a point
      */
    public void pointWonByPlayer1() {
        currentGame.pointWonByPlayer1();
        evaluateScore(PLAYER_1);
    }

    /**
     * This method indicates a player 2 winning a point
     */
    public void pointWonByPlayer2() {
        currentGame.pointWonByPlayer2();
        evaluateScore(PLAYER_2);
    }

    /**
     * Returns the current set score followed by (if the set is not yet completed) the current game score
     *
     * @return formatted score
     */
    public String getFormattedScore() {
        if (isSetOver) {
            return String.format("%s-%s", score[PLAYER_1], score[PLAYER_2]);
        } else {
            if (currentGame.isStarted()) {
                return String.format("%s-%s, %s", score[PLAYER_1], score[PLAYER_2], currentGame.getFormattedScore());
            } else {
                return String.format("%s-%s", score[PLAYER_1], score[PLAYER_2]);
            }
        }
    }

    /**
     * Return set score
     * @return holder of set score [index=0 for player 1, index=1 for player 2
     */
    public int[] getScore() {
        return score;
    }

    /**
     * Indicates if Set is over
     *
     * @return flag that indicates the set is over
     */
    public boolean isSetOver() {
        return isSetOver;
    }

    /**
     * Private methods
     */

    private void evaluateScore(int player) {

        if (currentGame.isGameOver()) {
            score[player]++;
            gameCtr++;

            if (currentGame.isTiebreakGame()) {
                isSetOver = true;
            } else  if (gameCtr > 10) {
                int diff1 = score[PLAYER_1] - score[PLAYER_2];
                int diff2 = score[PLAYER_2] - score[PLAYER_1];
                if (diff1 == 2 || diff2 == 2) {
                    isSetOver = true;
                }
            } else {
                for (int[] cs: checkScore) {
                    if (gameCtr == cs[0] && (score[PLAYER_1] == cs[1] || score[PLAYER_2] == cs[1])) {
                        isSetOver = true;
                    }
                }
            }

            if (!isSetOver) {
                if (score[PLAYER_1] == 6 && score[PLAYER_2] == 6) {
                    currentGame = new TiebreakGame(match);
                } else {
                    currentGame = new Game(match);
                }
            }
        }

    }
}