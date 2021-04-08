package game;

import field.CheckForWin;
import field.Field;
import players.Player;

import static field.Field.getField;
import static field.Value.VALUE_O;
import static field.Value.VALUE_X;

public class Multiplayer {
    public void start() {
        CheckForWin check = new CheckForWin();
        Player player1 = new Player(VALUE_X);
        Player player2 = new Player(VALUE_O);
        Field field = getField();

        field.showField();
        int move = 0;
        while (true) {
            player1.move();
            field.showField();
            if (check.checkFieldForWin(VALUE_X)) {
                System.out.println("player1 win!");
                field.cleanField();
                break;
            }
            move++;
            if (move >= 9) {
                System.out.println("none win!");
                break;
            }


            player2.move();
            field.showField();
            if (check.checkFieldForWin(VALUE_O)) {
                System.out.println("player2 win!");
                field.cleanField();
                break;
            }
            move++;
        }
    }
}
