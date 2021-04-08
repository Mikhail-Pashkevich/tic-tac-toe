package field;

import lombok.Getter;

import static field.Value.VALUE_EMPTY;

public class Field {
    private static Field field;
    private final Value[][] array;
    @Getter
    private final int size;

    private Field(int size) {
        this.size = size;
        array = new Value[size][size];
        cleanField();
    }

    public static Field getField() {
        if (field == null) {
            field = new Field(3);
        }
        return field;
    }

    public void cleanField() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = VALUE_EMPTY;
            }
        }
    }

    public void showField() {
        System.out.println(
                "  " + array[0][0].getValue() + "  |  " + array[0][1].getValue() + "  |  " + array[0][2].getValue() + "\n" +
                        "-----------------\n" +
                        "  " + array[1][0].getValue() + "  |  " + array[1][1].getValue() + "  |  " + array[1][2].getValue() + "\n" +
                        "-----------------\n" +
                        "  " + array[2][0].getValue() + "  |  " + array[2][1].getValue() + "  |  " + array[2][2].getValue() + "\n");
    }

    public void setValueIn(int i, int j, Value value) {
        array[i][j] = value;
    }

    public boolean isEmptyIn(int i, int j) {
        return array[i][j].equals(VALUE_EMPTY);
    }

    public boolean isValueIn(int i, int j, Value value) {
        return array[i][j].equals(value);
    }
}
