public class Terminator extends Unit {
    protected int ammo = 2;

    public Terminator() {
        power = 40;
        defense = 80;
    }

    @Override
    public AttackResult attack(Unit target) {
        if (ammo >= 1) {
            ammo--;

            return super.attack(target);
        }

        return AttackResult.FAILED;
    }

    public int getAmmo() {
        return ammo;
    }
}
