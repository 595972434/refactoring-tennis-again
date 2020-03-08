package cn.xpbootcamp.tennis;

import java.util.Arrays;

public class TennisGameImpl {
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGameImpl(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        if (isTiedScore()) {
            return player1Score > 2 ? "Deuce" : getScoreName(player1Score) + "-All";
        } else if (isAtLeastOneUpto4Point()) {
            if (isPlayer1Advantage()) {
                return "Advantage " + player1Name;
            }
            if (isPlayer2Advantage()) {
                return "Advantage " + player2Name;
            }
            if (isPlayer1Won()) {
                return "Win for " + player1Name;
            }
            if (isPlayer2Won()) {
                return "Win for " + player2Name;
            }
        } else {
            return getScoreName(player1Score) + "-" + getScoreName(player2Score);
        }
        return "";
    }

    private boolean isPlayer2Won() {
        return player2Score - player1Score >= 2;

    }

    private boolean isPlayer1Won() {
        return player1Score - player2Score >= 2;
    }

    private boolean isPlayer2Advantage() {
        return player2Score - player1Score == 1;
    }

    private boolean isPlayer1Advantage() {
        return player1Score - player2Score == 1;
    }

    private boolean isAtLeastOneUpto4Point() {
        return player1Score >= 4 || player2Score >= 4;
    }

    private boolean isTiedScore() {
        return player1Score == player2Score;
    }

    private String getScoreName(int score) {
        return Arrays.asList("Love", "Fifteen", "Thirty", "Forty").get(score);
    }
}
