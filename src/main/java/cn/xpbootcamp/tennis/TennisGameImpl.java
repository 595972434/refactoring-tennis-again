package cn.xpbootcamp.tennis;

import cn.xpbootcamp.tennis.score.AbstractScore;
import cn.xpbootcamp.tennis.score.AdvantageScore;
import cn.xpbootcamp.tennis.score.EmptyScore;
import cn.xpbootcamp.tennis.score.RegularAgainstScore;
import cn.xpbootcamp.tennis.score.TiedScore;
import cn.xpbootcamp.tennis.score.WonScore;

import java.util.Arrays;
import java.util.List;

public class TennisGameImpl {
    private Player player1;
    private Player player2;

    public TennisGameImpl(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName()))
            player1.wonPoint();
        else
            player2.wonPoint();
    }

    public String getScore() {
        return generateScore().stream()
                .filter(AbstractScore::isApplied)
                .findFirst()
                .orElse(new EmptyScore(player1, player2))
                .state();

    }
    private List<AbstractScore> generateScore(){
        return Arrays.asList(
                new TiedScore(player1, player2),
                new AdvantageScore(player1, player2),
                new WonScore(player1, player2),
                new RegularAgainstScore(player1, player2)
        );
    }
}
