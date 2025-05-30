import java.util.ArrayList;
import java.util.List;

public class Driver {

    static Board initGame() {
        List<Player> players = List.of(
                new Player("A", 1),
                new Player("B", 1)
        );
        Dice oneDice = new OneDice();
        List<Jump> jumps = List.of(
                new Jump(2, 4),
                new Jump(3, 6)
        );
        Board snakeLadder = new SnakeLadderBoard(players, 10, jumps, oneDice);
        return snakeLadder;
    }

    public static void main(String[] args) {
        Board board = initGame();
        board.playGame();
    }

}
