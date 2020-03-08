package cn.xpbootcamp.tennis;

public class WonScore {
    private final Player player;

    public WonScore(Player player) {
        this.player = player;
    }

    public String state() {
        return "Win for " + player.getName();
    }
}
