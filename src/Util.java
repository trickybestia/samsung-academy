public class Util {
    public static final String SELECT_GAME_MODE_FORMAT = "Выберите режим игры (M, HA, A): ";

    public static final String INPUT_PLAYER_INPUT_NAME_FORMAT = "Игрок %d, введите своё имя: ";
    public static final String INPUT_PLAYER_INPUT_UNITS_FORMAT = "Введите 3 героев за которых вы будете играть (W, K, T): ";

    public static final String UNIT_TO_STRING_FORMAT = "U Здоровье: %d Сила: %d";
    public static final String KNIGHT_TO_STRING_FORMAT = "K Здоровье: %d Сила: %d Выносливость: %d";
    public static final String WIZARD_TO_STRING_FORMAT = "W Здоровье: %d Сила: %d Мана: %d";
    public static final String TERMINATOR_TO_STRING_FORMAT = "T Здоровье: %d Сила: %d Патроны: %d";

    public static final String FIGHT_ROUND_MESSAGE_FORMAT = "Раунд %d. Ходит %s (игрок %d). Ваши герои:%n";
    public static final String FIGHT_SELECTED_UNIT_NUMBER_FORMAT = "Вы атакуете героем %d.";
    public static final String FIGHT_ENEMY_UNIT_SELECTION_FORMAT = "Выберите героя противника, которого будете атаковать:%n";

    public static final String FAILED_ATTACK_FORMAT = "Не удалось нанести удар!";
    public static final String SUCCESSFUL_ATTACK_FORMAT = "Удар нанесён!";
    public static final String CRITICAL_ATTACK_FORMAT = "Критический удар!!!";
    public static final String ATTACK_PARRIED_FORMAT = "Удар отбит!";


    public static final String PLAYER_WON_MESSAGE_FORMAT = "Поздравляем! %s (игрок %d) победил!%n";

    public static boolean randomBoolean(float trueProbability) {
        return Math.random() < trueProbability;
    }
}
