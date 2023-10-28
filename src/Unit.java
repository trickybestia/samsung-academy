public class Unit {
    protected int health = 100;
    protected int defense = 100;
    protected int power = 10;

    protected float criticalChance = 0.1f;
    protected float parryChance = 0.1f;

    protected String name;

    public Unit(String name) {
        this.name = name;

        Game.playersCount++;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public float getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(float criticalChance) {
        this.criticalChance = criticalChance;
    }

    public float getParryChance() {
        return parryChance;
    }

    public void setParryChance(float parryChance) {
        this.parryChance = parryChance;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "health=" + health +
                ", defense=" + defense +
                ", power=" + power +
                ", criticalChance=" + criticalChance +
                ", parryChance=" + parryChance +
                ", name='" + name + '\'' +
                '}';
    }

    public void attack(Unit target) {
        target.applyDamage(power);
    }

    public void applyDamage(int damage) {
        health -= damage;
    }
}
