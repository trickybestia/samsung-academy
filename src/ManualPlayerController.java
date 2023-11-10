import java.util.Scanner;

public class ManualPlayerController extends PlayerController {
    protected final Scanner scanner;

    public ManualPlayerController() {
        scanner = new Scanner(System.in);
    }

    @Override
    public int selectAttackTarget(Player player, Player enemy, int attackingUnitIndex) {
        return scanner.nextInt() - 1;
    }
}
