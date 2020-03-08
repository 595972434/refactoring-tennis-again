package cn.xpbootcamp.tennis.score;

import cn.xpbootcamp.tennis.Player;

public class RegularAgainstScore extends AbstractScore {

    public RegularAgainstScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public boolean isApplied() {
        return true;
    }

    @Override
    public String state() {
        return getScoreName(player1.getScore()) + "-" + getScoreName(player2.getScore());
    }

}
