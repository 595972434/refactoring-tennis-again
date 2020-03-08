package cn.xpbootcamp.tennis;

import java.util.Arrays;

public class TiedScore {
    private final Player player;
    public TiedScore(Player player) {
        this.player = player;
    }

    private String getScoreName(int score) {
        return Arrays.asList("Love", "Fifteen", "Thirty", "Forty").get(score);
    }

    public String state() {
        return player.getScore() >2 ? "Deuce" : getScoreName(player.getScore()) + '-' + "All";

    }
}
