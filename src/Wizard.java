public class Wizard extends Unit {
    protected int mana = 100;

    public Wizard() {
        power = 25;
        defense = 40;
    }

    @Override
    public void onRound() {
        mana += 4;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public AttackResult attack(Unit target) {
        if (mana >= 10) {
            mana -= 10;

            return super.attack(target);
        }

        return AttackResult.FAILED;
    }
}
