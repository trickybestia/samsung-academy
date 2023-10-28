public class Wizard extends Unit {
    protected int mana = 100;

    public Wizard(String name) {
        super(name);

        power = 25;
        defense = 80;
    }

    @Override
    public void attack(Unit target) {
        if (mana >= 10) {
            super.attack(target);

            mana -= 10;
        }
    }

    @Override
    public String toString() {
        return "Wizard{" +
                "mana=" + mana +
                ", health=" + health +
                ", defense=" + defense +
                ", power=" + power +
                ", criticalChance=" + criticalChance +
                ", parryChance=" + parryChance +
                ", name='" + name + '\'' +
                '}';
    }
}
