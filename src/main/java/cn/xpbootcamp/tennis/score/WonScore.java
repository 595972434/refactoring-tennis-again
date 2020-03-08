package cn.xpbootcamp.tennis.score;

import cn.xpbootcamp.tennis.Player;

public class WonScore extends AbstractScore {

    public WonScore(Player player1, Player player2) {
        super(player1, player2);
    }


    public String state() {
        return "Win for " + (player1.hasWonAgainst(player2) ? player1.getName() : player2.getName());
    }

    public boolean isApplied() {
        return player1.hasWonAgainst(player2) || player2.hasWonAgainst(player1);
    }
}
