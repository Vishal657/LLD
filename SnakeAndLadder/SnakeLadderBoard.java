import java.util.*;

public class SnakeLadderBoard implements Board{
    List<Player> players;
    Cell[] cells;
    Map<Integer, Integer> jumpMap;
    Dice dice;

    int turn;
    int[] positions;

    SnakeLadderBoard(List<Player> players, int totalCells, List<Jump> jumps, Dice dice) {
        this.players = players;
        this.dice = dice;

        this.turn = 0;
        this.positions = new int[players.size()];
        Arrays.fill(positions, 1);

        this.cells = new Cell[totalCells];
        for (int i = 0; i < totalCells; i++) {
            this.cells[i] = new Cell(i + 1);
        }

        jumpMap = new HashMap<>();
        for(Jump jump: jumps) {
            this.jumpMap.put(jump.start, jump.end);
        }
    }

    int getPosition(int diceVal) {
        int currPosition = positions[turn];
        int newPosition = currPosition + diceVal;

        if(jumpMap.containsKey(newPosition)) {
            System.out.println("There was a jump!!!");
            newPosition = jumpMap.get(newPosition);
        }

        return newPosition;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(players.get(turn).name + " Please take your turn.");
            System.out.println("Roll dice? Please press enter.");
            String input = scanner.nextLine();

            int diceVal = dice.rollDice();
            int newPosition = getPosition(diceVal);

            if(newPosition < cells.length) {
                positions[turn] = newPosition;
            }

            if(newPosition == cells.length) {
                System.out.println("You got " + diceVal + ". You are the winner!!");
                break;
            }

            System.out.println("You got " + diceVal + " your new position is: " + positions[turn] );
            System.out.println("Positions: " + Arrays.toString(positions));

            turn = (turn + 1) % players.size();
        }

        scanner.close();
    }

}
