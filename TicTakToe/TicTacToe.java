import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicTacToe {

    List<Player> players;
    int playerInx;
    Board board;

    public TicTacToe(Board board) {
        this.board = board;
        this.playerInx = 0;
        players = new ArrayList<>(board.maxPlayersAllowed());
    }

    public void addPlayers(String name) {
        if (playerInx == board.maxPlayersAllowed()) {
            System.out.println("Cannot add any more players");
        } else {
            players.add(new Player(board.getShapeForPlayer(playerInx), name));
            playerInx++;
        }
    }

    private Player getPlayerFromShape(Shape shape) {
        Optional<Player> player = players.stream().filter(p -> p.shape.equals(shape)).findFirst();
        if(player.isPresent()) {
            return player.get();
        }
        return null;
    }

    public void playGame() {
        if(players.isEmpty()) {
            System.out.println("Please add players.");
            return;
        }
        while (true) {
            Player player = getPlayerFromShape(board.getCurrentTurnShape());
            System.out.println("Player " + player.name + " take your turn.");
            System.out.println("Current board");
            board.showBoard();

            int[] position = board.getPositionForNewShapeFromUser();
            board.insertShapeAtPosition(position);

            System.out.println("Current board");
            board.showBoard();

            Shape winnerShape = board.getWinnerShape();
            if(winnerShape != null) {
                // give winner
                Player winnerPlayer = getPlayerFromShape(winnerShape);
                if(winnerPlayer != null) {
                    System.out.println("Winner is player " + winnerPlayer.name);
                } else {
                    System.out.println("Should have not came here.");
                }
                break;
            }

            if(board.gameDraw()) {
                System.out.println("Game Draw!!");
                break;
            }
        }
    }


    // Driver code
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(new Board2Player());
        ticTacToe.addPlayers("p1");
        ticTacToe.addPlayers("p2");

        ticTacToe.playGame();
    }

}
