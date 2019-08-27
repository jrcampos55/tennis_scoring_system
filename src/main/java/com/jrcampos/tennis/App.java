package com.jrcampos.tennis;

import java.util.Scanner;

/**
 * Sample App executable class.
 */
public class App {

    public static void main1(String[] args) {
        int MAX_SET = 1;
        String PLYR_1 = "player 1";
        String PLYR_2 = "player 2";
        String P_1 = "1";
        String P_2 = "2";

        Player player1 = new Player(PLYR_1);
        Player player2 = new Player(PLYR_2);

        Match match = new Match(MAX_SET, player1, player2);

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
        System.out.println(match.score());

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
        match.pointWonBy(PLYR_1); // 6-6, 7-6
        match.pointWonBy(PLYR_1); // 7-6
        System.out.println(match.score());
    }

    public static void main(String[] args) {
        int MAX_SET = 1;
        String PLYR_1 = "player 1";
        String PLYR_2 = "player 2";
        String P_1 = "1";
        String P_2 = "2";

        Player player1 = new Player(PLYR_1);
        Player player2 = new Player(PLYR_2);

        Match match = new Match(MAX_SET, player1, player2);

        Scanner scanner = new Scanner(System.in);

        while(true) {
            // auto close scanner
            System.out.print("Enter either 1 or 2 (1 for player 1 or 2 for player 2) : ");

            String input = scanner.next();  // Read user input

            if (input.trim().equalsIgnoreCase(P_1)) {
                match.pointWonBy(PLYR_1);
            } else if (input.trim().equalsIgnoreCase(P_2)) {
                match.pointWonBy(PLYR_2);
            } else {
                System.out.println("--------------IGNORED--------------");
            }
            System.out.println("Score :: " + match.score());
        }

    }
}
