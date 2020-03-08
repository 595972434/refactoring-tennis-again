package cn.xpbootcamp.tennis;

import java.util.Arrays;

public class TennisGameImpl {
    private Player player1;
    private Player player2;

    public TennisGameImpl(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName()))
            player1.wonPoint();
        else
            player2.wonPoint();
    }

    public String getScore() {
        if (player1.isTiedWith(player2)) {
            return player1.getScore() > 2 ? "Deuce" : getScoreName(player1.getScore()) + "-All";
        }
        if (player1.isAdvantageWith(player2)) {
            return "Advantage " + player1.getName();
        }
        if (player2.isAdvantageWith(player1)) {
            return "Advantage " + player2.getName();
        }
        if (player1.isWonWith(player2)) {
            return "Win for " + player1.getName();
        }
        if (player2.isWonWith(player1)) {
            return "Win for " + player2.getName();
        }
        return getScoreName(player1.getScore()) + "-" + getScoreName(player2.getScore());

    }

    private String getScoreName(int score) {
        return Arrays.asList("Love", "Fifteen", "Thirty", "Forty").get(score);
    }
}
