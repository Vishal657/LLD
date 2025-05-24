public interface Board {

    int[] getPositionForNewShapeFromUser();

    void insertShapeAtPosition(int[] position);

    void showBoard();

    Shape2Player getWinnerShape();

    boolean gameDraw();

    int maxPlayersAllowed();

    Shape getShapeForPlayer(int idx);

    Shape getCurrentTurnShape();

}
