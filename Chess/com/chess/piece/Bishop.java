package chess.piece;

import chess.*;
import java.util.*;

public class Bishop implements Piece {
    public Position currPosition;
    public PieceColor pieceColor;
    public ChessBoard board;

    public Bishop(Position position, PieceColor color, ChessBoard board) {
        this.currPosition = position.clone();
        this.pieceColor = color;
        this.board = board;
    }

    @Override
    public List<Position> validPositions() {
        List<Position> positions = new ArrayList<>();
        for (int d = 1; d < ChessBoard.SIZE; d++) {
            for (int[] dir : new int[][]{{d, d}, {d, -d}, {-d, d}, {-d, -d}}) {
                int newI = currPosition.i + dir[0];
                int newJ = currPosition.j + dir[1];
                if (newI >= 0 && newI < ChessBoard.SIZE && newJ >= 0 && newJ < ChessBoard.SIZE)
                    positions.add(new Position(newI, newJ));
            }
        }
        return positions;
    }
}