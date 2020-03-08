package cn.xpbootcamp.tennis.score;

import cn.xpbootcamp.tennis.Player;

public class AdvantageScore extends AbstractScore {
    public AdvantageScore(Player player1, Player player2) {
        super(player1, player2);
    }

    public boolean isApplied() {
        return player1.hasAdvantageOver(player2) || player2.hasAdvantageOver(player1);
    }

    public String state() {
        return "Advantage " + (player1.hasAdvantageOver(player2) ? player1.getName() : player2.getName());
    }
}
