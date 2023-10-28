class Main {
    public static void main(String[] args) {
        Unit unit1 = new Wizard("Sasha");
        Unit unit2 = new Unit("Aleksey");

        System.out.println(unit1);
        System.out.println(unit2);

        unit1.attack(unit2);

        System.out.println(unit1);
        System.out.println(unit2);

        unit2.attack(unit1);

        System.out.println(unit1);
        System.out.println(unit2);
    }
}