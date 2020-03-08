package cn.xpbootcamp.tennis;

public class EmptyScore extends AbstractScore {
    public EmptyScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public boolean isApplied() {
        return true;
    }

    @Override
    public String state() {
        return "";
    }
}
