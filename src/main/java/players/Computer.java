package players;

import field.CheckForTwoElements;
import field.Field;
import field.Value;

import java.util.Random;

import static field.Field.getField;
import static field.Value.VALUE_O;
import static field.Value.VALUE_X;

public class Computer {
    private int i;
    private int j;
    private Value value;

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
            Value oppositeValue = value.equals(VALUE_O) ? VALUE_O : VALUE_X;

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