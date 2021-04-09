package game.service;

import game.field.CheckForWin;
import game.field.Field;
import game.players.Player;

import static game.field.Field.getField;
import static game.field.Value.VALUE_O;
import static game.field.Value.VALUE_X;

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
                break;
            }
            move++;
        }
        field.cleanField();
    }
}
