package field;

import lombok.Getter;

import static field.Field.getField;

@Getter
public class CheckForWin {
    public boolean checkFieldForWin(Value value) {
        return checkColumns(value) || checkLines(value) || checkDiagonals(value);
    }

    private boolean checkColumns(Value value) {
        Field field = getField();
        boolean flag = true;

        // choose column
        for (int j = 0; j < field.getArray().length; j++) {
            flag = true;
            // run through all elements
            for (int i = 0; i < field.getArray().length; i++) {
                if (field.getArray()[i][j] != value) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    private boolean checkLines(Value value) {
        Field field = getField();
        boolean flag = true;

        // choose line
        for (int i = 0; i < field.getArray().length; i++) {
            flag = true;
            // run through all elements
            for (int j = 0; j < field.getArray().length; j++) {
                if (field.getArray()[i][j] != value) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    private boolean checkDiagonals(Value value) {
        Field field = getField();

        // check the main diagonal
        for (int i = 0; i < field.getArray().length; i++) {
            if (field.getArray()[i][i] != value) {
                // check the side diagonal
                i = 0;
                for (int j = field.getArray().length - 1; j >= 0; j--, i++) {
                    if (field.getArray()[i][j] != value) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}