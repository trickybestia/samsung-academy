public abstract class Unit {
    protected int health = 100;
    protected int defense = 100;
    protected int power = 10;
    protected float criticalAttackChance = 0.1f;
    protected float attackParryChance = 0.1f;

    public boolean isDead() {
        return health == 0;
    }

    public AttackResult attack(Unit target) {
        boolean criticalAttack = Util.randomBoolean(criticalAttackChance);
        boolean attackParried = target.applyDamage(power);

        if (attackParried) {
            target.attack(this);
        }

        return new AttackResult(true, criticalAttack, attackParried);
    }

    public boolean applyDamage(int damage) {
        boolean attackParried = Util.randomBoolean(attackParryChance);

        if (!attackParried) {
            health = Math.max(0, health - damage);
        }

        return attackParried;
    }

    public int getHealth() {
        return health;
    }

    public int getDefense() {
        return defense;
    }

    public int getPower() {
        return power;
    }

    public float getCriticalAttackChance() {
        return criticalAttackChance;
    }

    public float getAttackParryChance() {
        return attackParryChance;
    }
}
