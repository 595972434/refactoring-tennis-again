package cn.xpbootcamp.tennis;

import java.util.Arrays;

public class RegularAgainst {
    private final Player player1;
    private final Player player2;

    public RegularAgainst(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public boolean isApplied() {
        return true;
    }

    public String state() {
        return getScoreName(player1.getScore()) + "-" + getScoreName(player2.getScore());
    }
    private String getScoreName(int score) {
        return Arrays.asList("Love", "Fifteen", "Thirty", "Forty").get(score);
    }
}
