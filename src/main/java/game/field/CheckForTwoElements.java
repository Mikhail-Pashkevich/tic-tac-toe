package game.field;

import lombok.Getter;

import static game.field.Field.getField;

@Getter
public class CheckForTwoElements {
    private int i;
    private int j;


    public boolean checkFieldForTwo(Value value) {
        return checkColumnTwoElement(value) || checkLineTwoElement(value) || checkDiagonalTwoElement(value);
    }

    private void setNegativeIJ() {
        this.i = -1;
        this.j = -1;
    }

    private boolean checkColumnTwoElement(Value value) {
        Field field = getField();
        setNegativeIJ();

        for (int j = 0; j < field.getSize(); j++) {
            if (field.isValueIn(0, j, value) && field.isValueIn(1, j, value) && field.isEmptyIn(2, j)) {
                this.i = 0;
                this.j = j;
                return true;
            }
            if (field.isValueIn(0, j, value) && field.isEmptyIn(1, j) && field.isValueIn(2, j, value)) {
                this.i = 1;
                this.j = j;
                return true;
            }
            if (field.isEmptyIn(0, j) && field.isValueIn(1, j, value) && field.isValueIn(2, j, value)) {
                this.i = 2;
                this.j = j;
                return true;
            }
        }

        return false;
    }

    private boolean checkLineTwoElement(Value value) {
        Field field = getField();
        setNegativeIJ();

        for (int i = 0; i < field.getSize(); i++) {
            if (field.isValueIn(i, 0, value) && field.isValueIn(i, 1, value) && field.isEmptyIn(i, 2)) {
                this.i = i;
                this.j = 2;
                return true;
            }
            if (field.isValueIn(i, 0, value) && field.isEmptyIn(i, 1) && field.isValueIn(i, 2, value)) {
                this.i = i;
                this.j = 1;
                return true;
            }
            if (field.isEmptyIn(i, 0) && field.isValueIn(i, 1, value) && field.isValueIn(i, 2, value)) {
                this.i = i;
                this.j = 0;
                return true;
            }
        }

        return false;
    }

    private boolean checkDiagonalTwoElement(Value value) {
        Field field = getField();
        setNegativeIJ();

        if (field.isValueIn(0, 0, value) && field.isValueIn(1, 1, value) && field.isEmptyIn(2, 2)) {
            this.i = 2;
            this.j = 2;
            return true;
        }
        if (field.isValueIn(0, 0, value) && field.isEmptyIn(1, 1) && field.isValueIn(2, 2, value)) {
            this.i = 1;
            this.j = 1;
            return true;
        }
        if (field.isEmptyIn(0, 0) && field.isValueIn(1, 1, value) && field.isValueIn(2, 2, value)) {
            this.i = 0;
            this.j = 0;
            return true;
        }
        if (field.isValueIn(0, 2, value) && field.isValueIn(1, 1, value) && field.isEmptyIn(2, 0)) {
            this.i = 2;
            this.j = 2;
            return true;
        }
        if (field.isValueIn(0, 2, value) && field.isEmptyIn(1, 1) && field.isValueIn(2, 0, value)) {
            this.i = 1;
            this.j = 1;
            return true;
        }
        if (field.isEmptyIn(0, 2) && field.isValueIn(1, 1, value) && field.isValueIn(2, 0, value)) {
            this.i = 0;
            this.j = 0;
            return true;
        }

        return false;
    }
}