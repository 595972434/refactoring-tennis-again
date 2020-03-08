package cn.xpbootcamp.tennis.score;

import cn.xpbootcamp.tennis.Player;
import cn.xpbootcamp.tennis.score.AbstractScore;

public class RegularLandScore extends AbstractScore {

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
