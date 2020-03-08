package cn.xpbootcamp.tennis;

import java.util.ArrayList;
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
        if (player1.getName().equals(playerName))
            player1.wonPoint();
        else
            player2.wonPoint();
    }

    public String getScore() {
        return generatePossibleScore().stream()
                .filter(AbstractScore::isApplied)
                .findFirst().orElse(new EmptyScore(player1, player2))
                .state();
    }

    private List<AbstractScore> generatePossibleScore(){
        return  Arrays.asList(
                new TiedScore(player1, player2),
                new AdvantageScore(player1, player2),
                new WonScore(player1, player2),
                new RegularLandScore(player1, player2)
        );
    }

}
