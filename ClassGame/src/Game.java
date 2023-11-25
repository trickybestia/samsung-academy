public class Game {
    public static final int STATE_RUNNING = 0;
    public static final int STATE_PLAYER1_WON = 1;
    public static final int STATE_PLAYER2_WON = 2;

    protected Scenary scenary;
    private Player player1, player2;

    public Game(Scenary scenary) {
        this.scenary = scenary;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void run() {
        while (state() == STATE_RUNNING) {
            scenary.step(this);
        }

        scenary.onEnd(this);
    }

    public int state() {
        if (player1 == null || player2 == null) {
            return STATE_RUNNING;
        }

        if (player1.units.isEmpty()) {
            return STATE_PLAYER1_WON;
        }
        if (player2.units.isEmpty()) {
            return STATE_PLAYER2_WON;
        }

        return STATE_RUNNING;
    }
}
