import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        PlayerController player1Controller = null, player2Controller = null;

        System.out.print(Util.SELECT_GAME_MODE_FORMAT);

        Scanner scanner = new Scanner(System.in);
        String gameMode = scanner.next();

        switch (gameMode) {
            case "M" -> {
                player1Controller = new ManualPlayerController();
                player2Controller = new ManualPlayerController();
            }
            case "HA" -> {
                player1Controller = new ManualPlayerController();
                player2Controller = new AutoPlayerController();
            }
            case "A" -> {
                player1Controller = new AutoPlayerController();
                player2Controller = new AutoPlayerController();
            }
        }

        Scenary scenary = new Scenary(player1Controller, player2Controller);
        Game game = new Game(scenary);

        game.run();
    }
}
