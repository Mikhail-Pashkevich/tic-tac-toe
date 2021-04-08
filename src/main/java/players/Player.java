package players;

import field.Field;
import field.Value;

import static field.Field.getField;
import static service.Input.nextInt;

public class Player {
    private final Value value;

    public Player(Value value) {
        this.value = value;
    }

    public void move() {
        Field field = getField();
        int i, j;

        while (true) {
            System.out.println("input line and column(from 0 to 2):");
            i = nextInt();
            j = nextInt();

            if (isBelongs(0, 3, i) && isBelongs(0, 3, j) && getField().isEmptyIn(i, j)) {
                break;
            } else {
                System.out.println("incorrect input, please try again");
            }
        }

        field.setValueIn(i, j, this.value);
    }

    private boolean isBelongs(int begin, int end, int value) {
        return begin <= value && value < end;
    }
}