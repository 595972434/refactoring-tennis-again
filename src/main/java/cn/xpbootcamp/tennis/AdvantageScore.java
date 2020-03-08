package cn.xpbootcamp.tennis;

public class AdvantageScore {
    private final Player player1;
    private final Player player2;

    public AdvantageScore(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public boolean isApplied() {
        return player1.isAdvantageWith(player2) || player2.isAdvantageWith(player1);
    }

    public String state() {
        return "Advantage " + (player1.isAdvantageWith(player2) ? player1.getName() : player2.getName());
    }
}
