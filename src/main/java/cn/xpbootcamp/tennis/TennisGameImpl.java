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
        if (player1Name.equals(playerName))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        if (isTied()) {
            return scoreForTied();
        }
        if (isPlayer1Advantage()) {
            return scoreForAdvantage(player1Name);
        }
        if (isPlayer2Advantage()) {
            return scoreForAdvantage(player2Name);
        }
        if (isPlayer1Win()) {
            return scoreForWin(player1Name);
        }
        if (isPlayer2Win()) {
            return scoreForWin(player2Name);
        }
        return scoreForBothBelow4Point();
    }

    private String scoreForBothBelow4Point() {
        return getScoreName(player1Score) + '-' + getScoreName(player2Score);
    }

    private String scoreForWin(String playerName) {
        return "Win for " + playerName;
    }

    private String scoreForAdvantage(String playerName) {
        return "Advantage " + playerName;
    }

    private boolean isPlayer2Win() {
        return isAtLeastOneScoreAbove4Points() && player2Score - player1Score >=2;
    }

    private boolean isPlayer1Win() {
        return isAtLeastOneScoreAbove4Points() && player1Score - player2Score >= 2;
    }

    private boolean isPlayer2Advantage() {
        return isAtLeastOneScoreAbove4Points() && player1Score - player2Score == -1;
    }

    private boolean isPlayer1Advantage() {
        return isAtLeastOneScoreAbove4Points() && player1Score - player2Score == 1;
    }

    private String scoreForTied() {
        String score;
        score = player1Score >2 ? "Deuce" : getScoreName(player1Score) + '-' + "All";
        return score;
    }

    private boolean isAtLeastOneScoreAbove4Points() {
        return player1Score >= 4 || player2Score >= 4;
    }

    private boolean isTied() {
        return player1Score == player2Score;
    }

    private String getScoreName(int score) {
        return Arrays.asList("Love", "Fifteen", "Thirty", "Forty").get(score);
    }

}
