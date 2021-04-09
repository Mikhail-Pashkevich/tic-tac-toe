package game.field;

import lombok.Getter;

import static game.field.Field.getField;

@Getter
public class CheckForWin {
    public boolean checkFieldForWin(Value value) {
        return checkColumns(value) || checkLines(value) || checkDiagonals(value);
    }

    private boolean checkColumns(Value value) {
        Field field = getField();

        // choose column
        for (int j = 0; j < field.getSize(); j++) {
            boolean isWin = true;
            // run through all elements
            for (int i = 0; i < field.getSize(); i++) {
                if (!field.isValueIn(i, j, value)) {
                    isWin = false;
                    break;
                }
            }
            if (isWin) {
                return true;
            }
        }
        return false;
    }

    private boolean checkLines(Value value) {
        Field field = getField();

        // choose line
        for (int i = 0; i < field.getSize(); i++) {
            boolean isWin = true;
            // run through all elements
            for (int j = 0; j < field.getSize(); j++) {
                if (!field.isValueIn(i, j, value)) {
                    isWin = false;
                    break;
                }
            }
            if (isWin) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(Value value) {
        Field field = getField();

        // check the main diagonal
        for (int i = 0; i < field.getSize(); i++) {
            if (!field.isValueIn(i, i, value)) {
                // check the side diagonal
                i = 0;
                for (int j = field.getSize() - 1; j >= 0; j--, i++) {
                    if (!field.isValueIn(i, j, value)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}