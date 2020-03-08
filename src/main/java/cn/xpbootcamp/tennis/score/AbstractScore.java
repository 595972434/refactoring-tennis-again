package cn.xpbootcamp.tennis.score;

import cn.xpbootcamp.tennis.Player;

import java.util.Arrays;

public abstract class AbstractScore {
    protected final Player player1;
    protected final Player player2;

    public AbstractScore(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
    public String getScoreName(int score) {
        return Arrays.asList("Love", "Fifteen", "Thirty", "Forty").get(score);
    }
    public abstract boolean isApplied();
    public abstract String state();
}
