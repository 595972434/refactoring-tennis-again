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
            return showTiedScore();
        }
        if (player1.isAdvantageWith(player2)) {
            return showAdvantageScore(player1);
        }
        if (player2.isAdvantageWith(player1)) {
            return showAdvantageScore(player2);
        }
        if (player1.isWonWith(player2)) {
            return showWonScore(player1);
        }
        if (player2.isWonWith(player1)) {
            return showWonScore(player2);
        }
        return showRegularAgainst(player1, player2);

    }

    private String showRegularAgainst(Player player1, Player player2) {
        return getScoreName(player1.getScore()) + "-" + getScoreName(player2.getScore());
    }

    private String showWonScore(Player player) {
        return "Win for " + player.getName();
    }

    private String showAdvantageScore(Player player) {
        return "Advantage " + player.getName();
    }

    private String showTiedScore() {
        return player1.getScore() > 2 ? "Deuce" : getScoreName(player1.getScore()) + "-All";
    }

    private String getScoreName(int score) {
        return Arrays.asList("Love", "Fifteen", "Thirty", "Forty").get(score);
    }
}
