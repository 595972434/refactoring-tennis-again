package cn.xpbootcamp.tennis;

public class WonScore {
    public WonScore(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    private final Player player1;
    private final Player player2;

    public boolean isApplied() {
        return player1.isWonWith(player2) || player2.isWonWith(player1);
    }

    public String state() {
        return "Win for " + (player1.isWonWith(player2) ? player1.getName() : player2.getName());
    }
}
