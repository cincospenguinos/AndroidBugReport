package com.stoicapps.roll4initiative.shared;

public abstract class RandomizedValue {
    private static final String DICE_ROLL_REGEX = "\\d+d\\d+([+-]\\d+)?";

    abstract int roll();

    public static RandomizedValue fromString(String rollString) {
        if (rollString.matches(DICE_ROLL_REGEX)) {
            String[] pieces = rollString.split("[d+-]");
            boolean hasModifier = pieces.length == 3;

            int rolls = Integer.parseInt(pieces[0]);
            int faces = Integer.parseInt(pieces[1]);
            int modifier = extractModifier(rollString);

            return new DiceRoll(rolls, faces, modifier);
        }

        return new FlatAmount(Integer.parseInt(rollString));
    }

    private static int extractModifier(String rollString) {
        String modifierString = rollString.replaceFirst("\\d+d\\d+", "");

        if (modifierString.isEmpty()) {
            return 0;
        }

        return Integer.parseInt(modifierString);
    }
}
