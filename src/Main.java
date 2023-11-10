class Main {
    public static void main(String[] args) {
        Scenary scenary = new Scenary();
        Game game = new Game(scenary);

        game.run();
    }
}
