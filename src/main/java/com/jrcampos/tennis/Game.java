package com.jrcampos.tennis;

import static com.jrcampos.tennis.Constants.PLAYER_1;
import static com.jrcampos.tennis.Constants.PLAYER_2;

/**
 * This class models a normal Game in a Set.
 * A game consists of a sequence of points played with the same player serving, and is won by the first side to
 * have won at least four points with a margin of two points or more over their opponent.
 * */
public class Game {

    /**
     * Array of [pointsCtr, minimum-game-points]
     * is used to check if a player wins a game by winning at least 4 points in total and at least 2 points
     * more than the opponent
     */
    private static final int checkScore[][] = {{4,0}, {5,1}, {6,2}};

    /**
     * holds player points, index=0 is player 1 and index=1 is player 2
     */
    int[] score = {0, 0};

    /**
     * Counter to number of points being played
     */
    int pointsCtr = 0;

    /**
     * Flag to indicate if the game is over
     */
    boolean isGameOver;

    /**
     * Reference to current match
     */
    Match match;

    public Game(Match match) {
        this.match = match;
    }

    public void pointWonByPlayer1() {
        score[PLAYER_1]++;
        pointsCtr++;
        executeRules();
    }

    public void pointWonByPlayer2() {
        score[PLAYER_2]++;
        pointsCtr++;
        executeRules();
    }

    public int[] getScore() {
        return score;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public boolean isStarted() {
        return !(score[PLAYER_1] == 0 && score[PLAYER_2] == 0);
    }

    void executeRules() {
        if (pointsCtr > 6) {
            int diff1 = score[PLAYER_1] - score[PLAYER_2];
            int diff2 = score[PLAYER_2] - score[PLAYER_1];
            if (diff1 == 2 || diff2 == 2) {
                isGameOver = true;
                return;
            }
        } else {
            for (int[] cs: checkScore) {
                if (pointsCtr == cs[0] && (score[PLAYER_1] == cs[1] || score[PLAYER_2] == cs[1])) {
                    isGameOver = true;
                    return;
                }
            }
        }
    }

    /**
     * Implemented methods
     */

    public boolean isTiebreakGame() {
        return false;
    }

    public String getFormattedScore() {
        // 0=0, 1=15, 2=30, 3=40
        if (pointsCtr < 6) {
            return String.format("%s-%s", formatGameScore(score[PLAYER_1]), formatGameScore(score[PLAYER_2]));
        } else if (pointsCtr == 6 || (score[PLAYER_1] == score[PLAYER_2])) {
            return "Deuce";
        } else {
            if (score[PLAYER_1] > score[PLAYER_2]) {
                return String.format("Advantage %s", match.getPlayer1().getName());
            } else {
                return String.format("Advantage %s", match.getPlayer2().getName());
            }
        }
    }

    public String formatGameScore(int pointScore) {
        if (pointScore == 0) {
            return "0";
        } else if (pointScore == 1) {
            return "15";
        } else if (pointScore == 2) {
            return "30";
        } else if (pointScore == 3) {
            return "40";
        } else {
            return "";
        }
    }
}