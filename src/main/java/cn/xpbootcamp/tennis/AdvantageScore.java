package cn.xpbootcamp.tennis;

public class AdvantageScore {
    private final Player player;

    public AdvantageScore(Player player) {
        this.player = player;
    }

    public String state() {
        return "Advantage " + player.getName();
    }
}
