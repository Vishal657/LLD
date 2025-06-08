package chess.piece;

import chess.*;
import java.util.*;

public class Knight implements Piece {
    public Position currPosition;
    public PieceColor pieceColor;
    public ChessBoard board;

    public Knight(Position position, PieceColor color, ChessBoard board) {
        this.currPosition = position.clone();
        this.pieceColor = color;
        this.board = board;
    }

    @Override
    public List<Position> validPositions() {
        List<Position> positions = new ArrayList<>();
        int[][] moves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        for (int[] move : moves) {
            int newI = currPosition.i + move[0];
            int newJ = currPosition.j + move[1];
            if (newI >= 0 && newI < ChessBoard.SIZE && newJ >= 0 && newJ < ChessBoard.SIZE)
                positions.add(new Position(newI, newJ));
        }
        return positions;
    }
}