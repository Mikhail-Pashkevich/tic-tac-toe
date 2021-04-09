package game.service;

import game.field.CheckForWin;
import game.field.Field;
import game.players.Computer;
import game.players.Player;

import static game.field.Field.getField;
import static game.field.Value.VALUE_O;
import static game.field.Value.VALUE_X;

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
                break;
            }
            move++;
        }
        field.cleanField();
    }
}