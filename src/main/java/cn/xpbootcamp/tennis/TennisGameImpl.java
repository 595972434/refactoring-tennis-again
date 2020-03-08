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
        if (isTiedScore()) {
            return player1.getScore() > 2 ? "Deuce" : getScoreName(player1.getScore()) + "-All";
        }
        if (isPlayer1Advantage()) {
            return "Advantage " + player1.getName();
        }
        if (isPlayer2Advantage()) {
            return "Advantage " + player2.getName();
        }
        if (isPlayer1Won()) {
            return "Win for " + player1.getName();
        }
        if (isPlayer2Won()) {
            return "Win for " + player2.getName();
        }
        return getScoreName(player1.getScore()) + "-" + getScoreName(player2.getScore());

    }

    private boolean isPlayer2Won() {
        return isAtLeastOneUpto4Point() && player2.getScore() - player1.getScore() >= 2;

    }

    private boolean isPlayer1Won() {
        return isAtLeastOneUpto4Point() && player1.getScore() - player2.getScore() >= 2;
    }

    private boolean isPlayer2Advantage() {
        return isAtLeastOneUpto4Point() && player2.getScore() - player1.getScore() == 1;
    }

    private boolean isPlayer1Advantage() {
        return isAtLeastOneUpto4Point() && player1.getScore() - player2.getScore() == 1;
    }

    private boolean isAtLeastOneUpto4Point() {
        return player1.getScore() >= 4 || player2.getScore() >= 4;
    }

    private boolean isTiedScore() {
        return player1.getScore() == player2.getScore();
    }

    private String getScoreName(int score) {
        return Arrays.asList("Love", "Fifteen", "Thirty", "Forty").get(score);
    }
}
