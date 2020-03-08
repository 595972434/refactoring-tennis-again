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
        if (player1.getName().equals(playerName))
            player1.wonPoint();
        else
            player2.wonPoint();
    }

    public String getScore() {
        if (isTied()) {
            return scoreForTied();
        }
        if (isPlayer1Advantage()) {
            return scoreForAdvantage(player1.getName());
        }
        if (isPlayer2Advantage()) {
            return scoreForAdvantage(player2.getName());
        }
        if (isPlayer1Win()) {
            return scoreForWin(player1.getName());
        }
        if (isPlayer2Win()) {
            return scoreForWin(player2.getName());
        }
        return scoreForBothBelow4Point();
    }

    private String scoreForBothBelow4Point() {
        return getScoreName(player1.getScore()) + '-' + getScoreName(player2.getScore());
    }

    private String scoreForWin(String playerName) {
        return "Win for " + playerName;
    }

    private String scoreForAdvantage(String playerName) {
        return "Advantage " + playerName;
    }

    private boolean isPlayer2Win() {
        return isAtLeastOneScoreAbove4Points() && player2.getScore() - player1.getScore() >=2;
    }

    private boolean isPlayer1Win() {
        return isAtLeastOneScoreAbove4Points() && player1.getScore() - player2.getScore() >= 2;
    }

    private boolean isPlayer2Advantage() {
        return isAtLeastOneScoreAbove4Points() && player1.getScore() - player2.getScore() == -1;
    }

    private boolean isPlayer1Advantage() {
        return isAtLeastOneScoreAbove4Points() && player1.getScore() - player2.getScore() == 1;
    }

    private String scoreForTied() {
        String score;
        score = player1.getScore() >2 ? "Deuce" : getScoreName(player1.getScore()) + '-' + "All";
        return score;
    }

    private boolean isAtLeastOneScoreAbove4Points() {
        return player1.getScore() >= 4 || player2.getScore() >= 4;
    }

    private boolean isTied() {
        return player1.getScore() == player2.getScore();
    }

    private String getScoreName(int score) {
        return Arrays.asList("Love", "Fifteen", "Thirty", "Forty").get(score);
    }

}
