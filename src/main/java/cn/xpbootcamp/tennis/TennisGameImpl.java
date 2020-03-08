package cn.xpbootcamp.tennis;

import java.util.Arrays;

public class TennisGameImpl {
    private int player1Score = 0;
    private int play2Score = 0;
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
            play2Score += 1;
    }

    public String getScore() {
        String score;
        if (player1Score == play2Score) {
            score = player1Score > 2 ? "Deuce" : getScoreName(player1Score) + "-All";
        } else if (player1Score >= 4 || play2Score >= 4) {
            int minusResult = player1Score - play2Score;
            if (minusResult == 1) score = "Advantage " + player1Name;
            else if (minusResult == -1) score = "Advantage " + player2Name;
            else if (minusResult >= 2) score = "Win for " + player1Name;
            else score = "Win for " + player2Name;
        } else {
            score = getScoreName(player1Score) + "-" + getScoreName(play2Score);
        }
        return score;
    }

    private String getScoreName(int score) {
        return Arrays.asList("Love", "Fifteen", "Thirty", "Forty").get(score);
    }
}
