package cn.xpbootcamp.tennis.score;

import cn.xpbootcamp.tennis.Player;

public class WonScore extends AbstractScore {
    public WonScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public boolean isApplied() {
        return player1.isWonWith(player2) || player2.isWonWith(player1);
    }

    @Override
    public String state() {
        return "Win for " + (player1.isWonWith(player2) ? player1.getName() : player2.getName());
    }
}
