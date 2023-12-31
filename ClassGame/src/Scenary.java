import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scenary {
    protected static final int STATE_INPUT_PLAYER1 = 0;
    protected static final int STATE_INPUT_PLAYER2 = 1;
    protected static final int STATE_FIGHT = 2;
    protected static final int PLAYER_UNITS_COUNT = 3;

    protected int state = STATE_INPUT_PLAYER1;
    protected int round;
    protected Scanner scanner;
    protected final PlayerController player1Controller, player2Controller;

    public Scenary(PlayerController player1Controller, PlayerController player2Controller) {
        this.player1Controller = player1Controller;
        this.player2Controller = player2Controller;
        scanner = new Scanner(System.in);
    }

    public void onEnd(Game game) {
        Player winner;
        int winnerNumber;

        if (game.state() == Game.STATE_PLAYER1_WON) {
            winner = game.getPlayer1();
            winnerNumber = 1;
        } else {
            winner = game.getPlayer2();
            winnerNumber = 2;
        }

        System.out.printf(Util.PLAYER_WON_MESSAGE_FORMAT, winner.getName(), winnerNumber);
    }

    public void step(Game game) {
        switch (state) {
            case STATE_INPUT_PLAYER1 -> {
                game.setPlayer1(inputPlayer(1));

                state = STATE_INPUT_PLAYER2;
            }
            case STATE_INPUT_PLAYER2 -> {
                game.setPlayer2(inputPlayer(2));

                state = STATE_FIGHT;
            }
            case STATE_FIGHT -> {
                int playerNumber = round % 2 + 1;

                if (round % 2 == 0 && round != 0) {
                    for (Unit unit : game.getPlayer1().getUnits()) {
                        unit.onRound();
                    }
                    for (Unit unit : game.getPlayer2().getUnits()) {
                        unit.onRound();
                    }
                }

                Player player, enemy;
                PlayerController playerController;

                if (playerNumber == 1) {
                    player = game.getPlayer1();
                    enemy = game.getPlayer2();
                    playerController = player1Controller;
                } else {
                    player = game.getPlayer2();
                    enemy = game.getPlayer1();
                    playerController = player2Controller;
                }

                fight(game, player, enemy, playerNumber, playerController);

                round++;
            }
        }
    }

    protected Player inputPlayer(int playerNumber) {
        System.out.printf(Util.INPUT_PLAYER_INPUT_NAME_FORMAT, playerNumber);

        String name = scanner.nextLine();

        System.out.print(Util.INPUT_PLAYER_INPUT_UNITS_FORMAT);

        ArrayList<Unit> units = new ArrayList<>();

        for (int i = 0; i != PLAYER_UNITS_COUNT; i++) {
            String unitName = scanner.next();
            Unit unit = null;

            switch (unitName) {
                case "W" -> unit = new Wizard();
                case "K" -> unit = new Knight();
                case "T" -> unit = new Terminator();
            }

            units.add(unit);
        }

        scanner.nextLine();

        return new Player(name, units);
    }

    protected void fight(Game game, Player player, Player enemy, int playerNumber, PlayerController playerController) {
        System.out.printf(Util.FIGHT_ROUND_MESSAGE_FORMAT, round + 1, player.getName(), playerNumber);
        printUnits(player.getUnits());

        for (int i = 0; i != player.getUnits().size() && game.state() == Game.STATE_RUNNING; i++) {
            System.out.printf(Util.FIGHT_SELECTED_UNIT_NUMBER_FORMAT + " ", i + 1);
            System.out.printf(Util.FIGHT_ENEMY_UNIT_SELECTION_FORMAT);
            printUnits(enemy.getUnits());

            int enemyUnitIndex = playerController.selectAttackTarget(player, enemy, i);
            Unit enemyUnit = enemy.getUnits().get(enemyUnitIndex);

            printAttackResult(player.getUnits().get(i).attack(enemyUnit));

            if (enemyUnit.isDead()) {
                enemy.getUnits().remove(enemyUnitIndex);
            }

            if (player.getUnits().get(i).isDead()) {
                player.getUnits().remove(i);
            }
        }
    }

    protected void printUnits(List<Unit> units) {
        for (int i = 0; i != units.size(); i++) {
            System.out.printf("(%d) %s%n", i + 1, UnitFormatter.format(units.get(i)));
        }
    }

    protected void printAttackResult(AttackResult attackResult) {
        ArrayList<String> messages = new ArrayList<>();

        if (attackResult.success) {
            messages.add(Util.SUCCESSFUL_ATTACK_FORMAT);
        } else {
            messages.add(Util.FAILED_ATTACK_FORMAT);
        }

        if (attackResult.criticalAttack) {
            messages.add(Util.CRITICAL_ATTACK_FORMAT);
        }

        if (attackResult.attackParried) {
            messages.add(Util.ATTACK_PARRIED_FORMAT);
        }

        System.out.println(String.join(" ", messages));
    }
}
