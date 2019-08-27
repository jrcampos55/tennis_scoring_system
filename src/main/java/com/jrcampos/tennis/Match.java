package com.jrcampos.tennis;

import java.util.ArrayList;
import java.util.List;

import static com.jrcampos.tennis.Constants.PLAYER_1;
import static com.jrcampos.tennis.Constants.PLAYER_2;

/**
 *  This class models a Match which has a set and a set has many games.
 */
public class Match {

    /**
     * Holds the set being played
     */
    private List<MatchSet> sets = new ArrayList<MatchSet>();

    /**
     * Reference to the currect set being played
     */
    private MatchSet currentSet;

    /**
     * Player 1 reference
     */
    private Player player1;

    /**
     * Player 2 reference
     */
    private Player player2;

    /**
     * Array that holds the Match Set score for each player, index = 0 (first player), index = 2 (second player)
     */
    private int[] setScore = {0, 0};

    /**
     * Max number of set to be played
     */
    private int maxSet;

    /**
     * Number of sets played in a match
     */
    private int setCtr = 1;

    /**
     * Flag to indicate if match is over
     */
    private boolean isMatchOver;

    public Match(int maxSet, Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentSet = new MatchSet(this);
        sets.add(currentSet);
        this.maxSet = maxSet;
    }

    public void pointWonBy(String player) {
        executeRules(player);

        if (isMatchOver) {
            System.out.println("This match is already over.");
        } else {
            if (player1.getName().equalsIgnoreCase(player)) {
                currentSet.pointWonByPlayer1();
            } else {
                currentSet.pointWonByPlayer2();
            }

        }
    }

    public String score() {
        return currentSet.getFormattedScore();
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    /**
     * Private methods
     */

    private void executeRules(String player) {
        if (currentSet.isSetOver()) {
            if (player1.getName().equals(player)) {
                setScore[PLAYER_1]++;
            } else {
                setScore[PLAYER_2]++;
            }
            isMatchOver = true;
        }
    }
}
