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
        if (player1.isTiedWith(player2)) {
            return scoreForTied();
        }
        if (player1.hasAdvantageOver(player2)) {
            return scoreForAdvantage(player1.getName());
        }
        if (player2.hasAdvantageOver(player1)) {
            return scoreForAdvantage(player2.getName());
        }
        if (player1.hasWonAgainst(player2)) {
            return scoreForWin(player1.getName());
        }
        if (player2.hasWonAgainst(player1)) {
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


    private String scoreForTied() {
        String score;
        score = player1.getScore() >2 ? "Deuce" : getScoreName(player1.getScore()) + '-' + "All";
        return score;
    }

    private String getScoreName(int score) {
        return Arrays.asList("Love", "Fifteen", "Thirty", "Forty").get(score);
    }

}
