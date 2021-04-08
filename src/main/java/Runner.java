import game.Multiplayer;
import game.Singleplayer;
import service.Input;

public class Runner {
    public static void main(String[] args) {

        while (true) {
            System.out.print("""
                    1 - player1(X) vs player2(O);
                    2 - player(X) vs computer(O)
                    3 - rules
                    0 - exit
                    Your choose:""");
            switch (Input.nextInt()) {
                case 1:
                    new Multiplayer().start();
                    break;
                case 2:
                    new Singleplayer().start();
                    break;
                case 3:
                    System.out.println(rules());
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }

    public static String rules() {
        return """
                                    Game rules
                    Players take turns placing signs on the free squares 
                of the field (one is always X, the other is always O).
                    The first one who lined up 3 of his pieces vertically,
                horizontally, or diagonally wins the game.
                    The first move is made by the player who puts X.
                                    About the game
                TIC-TAC—TOE is a logical game between two opponents on a 
                square field. One of the players plays X, the second — O.
                """;
    }
}