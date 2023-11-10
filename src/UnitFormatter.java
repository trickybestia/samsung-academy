public class UnitFormatter {
    public static String format(Unit unit) {
        if (unit instanceof Knight knight) {
            return String.format(Util.KNIGHT_TO_STRING_FORMAT, knight.getHealth(), knight.getDefense(),
                                 knight.getPower(), knight.getStamina());
        } else if (unit instanceof Wizard wizard) {
            return String.format(Util.WIZARD_TO_STRING_FORMAT, wizard.getHealth(), wizard.getDefense(),
                                 wizard.getPower(), wizard.getMana());
        } else if (unit instanceof Terminator terminator) {
            return String.format(Util.TERMINATOR_TO_STRING_FORMAT, terminator.getHealth(), terminator.getDefense(),
                                 terminator.getPower(), terminator.getAmmo());
        }

        return String.format(Util.UNIT_TO_STRING_FORMAT, unit.getHealth(), unit.getDefense(), unit.getPower());
    }
}
