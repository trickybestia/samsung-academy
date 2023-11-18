public class Knight extends Unit {
    protected int stamina = 100;

    public Knight() {
        power = 20;
    }

    @Override
    public void onRound() {
        stamina += 10;
    }

    @Override
    public AttackResult attack(Unit target) {
        if (stamina >= 20) {
            stamina -= 20;

            return super.attack(target);
        }

        return AttackResult.FAILED;
    }

    @Override
    public boolean applyDamage(int damage) {
        if (stamina >= 20) {
            stamina -= 20;

            return super.applyDamage(damage / 2);
        }

        return super.applyDamage(damage);
    }

    public int getStamina() {
        return stamina;
    }
}
