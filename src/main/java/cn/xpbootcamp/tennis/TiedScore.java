package cn.xpbootcamp.tennis;

import java.util.Arrays;

public class TiedScore {
    private final Player player1;
    private final Player player2;

    public TiedScore(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public boolean isApplied() {
        return player1.isTiedWith(player2);
    }

    public String state() {
        return player1.getScore() > 2 ? "Deuce" : getScoreName(player1.getScore()) + "-All";

    }

    private String getScoreName(int score) {
        return Arrays.asList("Love", "Fifteen", "Thirty", "Forty").get(score);
    }
}
