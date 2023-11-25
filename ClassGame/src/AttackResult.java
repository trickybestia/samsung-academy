public class AttackResult {
    public static final AttackResult FAILED = new AttackResult(false, false, false);

    public final boolean success, criticalAttack, attackParried;

    public AttackResult(boolean success, boolean criticalAttack, boolean attackParried) {
        this.success = success;
        this.criticalAttack = criticalAttack;
        this.attackParried = attackParried;
    }
}
