package cn.xpbootcamp.tennis;

import java.util.Arrays;

public class TiedScore extends AbstractScore {

    public TiedScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public boolean isApplied() {
        return player1.isTiedWith(player2);
    }

    @Override
    public String state() {
        return player1.getScore() > 2 ? "Deuce" : getScoreName(player1.getScore()) + "-All";

    }
}
