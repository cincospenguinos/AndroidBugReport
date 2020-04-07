package com.stoicapps.roll4initiative.shared;

public abstract class RandomizedValue {
    private static final String DICE_ROLL_REGEX = "\\d+d\\d+([+-]\\d+)?";

    abstract int roll();

    public static RandomizedValue fromString(String rollString) {
        if (rollString.matches(DICE_ROLL_REGEX)) {
            String[] pieces = rollString.split("[d+-]");
            boolean isModifierNegative = rollString.contains("-");
            boolean hasModifier = pieces.length == 3;

            int rolls = Integer.parseInt(pieces[0]);
            int faces = Integer.parseInt(pieces[1]);

            if (hasModifier) {
                int modifier = Integer.parseInt(pieces[2]);

                if (isModifierNegative) {
                    modifier = -modifier;
                }

                return new DiceRoll(rolls, faces, modifier);
            }

            return new DiceRoll(rolls, faces, 0);
        }

        return new FlatAmount(Integer.parseInt(rollString));
    }
}
