package cn.xpbootcamp.tennis;

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
            return new TiedScore(player1).state();
        }
        if (player1.hasAdvantageOver(player2)) {
            return new AdvantageScore(player1).state();
        }
        if (player2.hasAdvantageOver(player1)) {
            return new AdvantageScore(player2).state();
        }
        if (player1.hasWonAgainst(player2)) {
            return new WonScore(player1).state();
        }
        if (player2.hasWonAgainst(player1)) {
            return new WonScore(player2).state();
        }
        return new RegularLandScore(player1, player2).state();
    }

}
