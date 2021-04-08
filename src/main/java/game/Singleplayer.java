package game;

import field.CheckForWin;
import field.Field;
import players.Computer;
import players.Player;

import static field.Field.getField;
import static field.Value.VALUE_O;
import static field.Value.VALUE_X;

public class Singleplayer {
    public void start() {
        CheckForWin check = new CheckForWin();
        Player player = new Player(VALUE_X);
        Computer computer = new Computer(VALUE_O);
        Field field = getField();

        field.showField();
        int move = 0;
        while (true) {
            player.move();
            field.showField();
            if (check.checkFieldForWin(VALUE_X)) {
                System.out.println("you win!");
                field.cleanField();
                break;
            }
            move++;
            if (move >= 9) {
                System.out.println("none win!");
                break;
            }


            computer.move();
            field.showField();
            if (check.checkFieldForWin(VALUE_O)) {
                System.out.println("computer win!");
                field.cleanField();
                break;
            }
            move++;
        }
    }
}