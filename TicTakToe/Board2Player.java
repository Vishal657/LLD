import java.util.List;
import java.util.Scanner;

public class Board2Player implements Board {

    Cell2Player[][] gameboard;

    int shapeTurn;

    List<Shape2Player> shapeList;

    int totalShapes = 2;

    Board2Player() {
        gameboard = new Cell2Player[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameboard[i][j] = new Cell2Player(i, j);
            }
        }

        shapeTurn = 0;
        shapeList = List.of(Shape2Player.X, Shape2Player.O);
    }

    private void moveTurn() {
        shapeTurn = (shapeTurn + 1) % totalShapes;
    }

    @Override
    public int[] getPositionForNewShapeFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your position in form of x,y");
        String input = scanner.nextLine();
        Integer x = null, y = null;
        try {
            String[] parts = input.trim().split(",");
            if (parts.length != 2) {
                throw new IllegalArgumentException("Input must be in the form x,y");
            }

            x = Integer.parseInt(parts[0].trim());
            y = Integer.parseInt(parts[1].trim());

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please enter integers.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        if (x == null || y == null) {
            return null;
        }
        return new int[]{x, y};
    }

    @Override
    public void insertShapeAtPosition(int[] position) {
        if(gameboard[position[0]][position[1]].shape == null) {
            gameboard[position[0]][position[1]].shape = shapeList.get(shapeTurn);
            moveTurn();
        } else {
            System.out.println("Position already taken please select other position.");
        }
    }

    @Override
    public void showBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(gameboard[i][j] + "   ");
            }
            System.out.println();
        }
    }

    private boolean checkShapeIsWinner(Shape2Player shape) {
        for (int i = 0; i < 3; i++) {
            // checking rows
            boolean flag = false;
            for (int j = 0; j < 3; j++) {
                if (gameboard[i][j].shape == null || !gameboard[i][j].shape.equals(shape)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) return true;

            // checking column
            flag = false;
            for (int j = 0; j < 3; j++) {
                if (gameboard[j][i].shape == null || !gameboard[j][i].shape.equals(shape)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) return true;
        }

        // check diagonal left to right
        boolean flag = false;
        for (int i = 0; i < 3; i++) {
            if (gameboard[i][i].shape == null || !gameboard[i][i].shape.equals(shape)) {
                flag = true;
                break;
            }
        }
        if (!flag) return true;

        // check diagonal right to left
        flag = false;
        for (int i = 0; i < 3; i++) {
            if (gameboard[i][2 - i].shape == null || !gameboard[i][2 - i].shape.equals(shape)) {
                flag = true;
                break;
            }
        }
        if (!flag) return true;

        return false;
    }

    @Override
    public Shape2Player getWinnerShape() {
        for (Shape2Player shape2Player : shapeList) {
            if (checkShapeIsWinner(shape2Player)) {
                return shape2Player;
            }
        }
        return null;
    }

    @Override
    public boolean gameDraw() {
        if (getWinnerShape() != null) {      // we have a winner
            return false;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameboard[i][j].shape == null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int maxPlayersAllowed() {
        return totalShapes;
    }

    @Override
    public Shape getShapeForPlayer(int idx) {
        if(idx >= shapeList.size()) {
            return null;
        }
        return shapeList.get(idx);
    }

    @Override
    public Shape getCurrentTurnShape() {
        return shapeList.get(shapeTurn);
    }
}
