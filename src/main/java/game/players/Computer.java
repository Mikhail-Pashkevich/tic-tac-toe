package game.players;

import game.field.CheckForTwoElements;
import game.field.Field;
import game.field.Value;

import java.util.Random;

import static game.field.Field.getField;
import static game.field.Value.VALUE_O;
import static game.field.Value.VALUE_X;

public class Computer {
    private final Value value;
    private int i;
    private int j;

    public Computer(Value value) {
        this.value = value;
    }

    public void move() {
        Field field = getField();
        generateIJ();
        field.setValueIn(this.i, this.j, this.value);
    }

    private void generateIJ() {
        CheckForTwoElements check = new CheckForTwoElements();
        if (check.checkFieldForTwo(value)) {
            this.i = check.getI();
            this.j = check.getJ();
        } else {
            Value oppositeValue = value.equals(VALUE_O) ? VALUE_X : VALUE_O;

            if (check.checkFieldForTwo(oppositeValue)) {
                this.i = check.getI();
                this.j = check.getJ();
            } else {
                do {
                    Random random = new Random();
                    this.i = random.nextInt(3);
                    this.j = random.nextInt(3);
                } while (!getField().isEmptyIn(i, j));
            }
        }
    }
}