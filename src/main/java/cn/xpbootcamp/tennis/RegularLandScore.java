package cn.xpbootcamp.tennis;

public class RegularLandScore extends AbstractScore{

    public RegularLandScore(Player player1, Player player2) {
        super(player1, player2);
    }

    public String state() {
        return getScoreName(player1.getScore()) + '-' + getScoreName(player2.getScore());
    }

    public boolean isApplied() {
        return true;
    }
}
