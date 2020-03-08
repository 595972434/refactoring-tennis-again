package cn.xpbootcamp.tennis;

public class TennisGameImpl {
    private int player1Score1 = 0;
    private int player2Score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGameImpl(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName))
            player1Score1 += 1;
        else
            player2Score2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (player1Score1 == player2Score2) {
            switch (player1Score1) {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else if (player1Score1 >= 4 || player2Score2 >= 4) {
            int minusResult = player1Score1 - player2Score2;
            if (minusResult == 1) score = "Advantage " + player1Name;
            else if (minusResult == -1) score = "Advantage " + player2Name;
            else if (minusResult >= 2) score = "Win for " + player1Name;
            else score = "Win for " + player2Name;
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = player1Score1;
                else {
                    score += "-";
                    tempScore = player2Score2;
                }
                switch (tempScore) {
                    case 0:
                        score += "Love";
                        break;
                    case 1:
                        score += "Fifteen";
                        break;
                    case 2:
                        score += "Thirty";
                        break;
                    case 3:
                        score += "Forty";
                        break;
                }
            }
        }
        return score;
    }
}
