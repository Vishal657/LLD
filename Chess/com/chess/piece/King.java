package chess.piece;

import chess.*;
import java.util.*;

public class King implements Piece {
    public Position currPosition;
    public PieceColor pieceColor;
    public ChessBoard board;

    public King(Position position, PieceColor color, ChessBoard board) {
        this.currPosition = position.clone();
        this.pieceColor = color;
        this.board = board;
    }

    @Override
    public List<Position> validPositions() {
        List<Position> positions = new ArrayList<>();
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                if (di == 0 && dj == 0) continue;
                int ni = currPosition.i + di;
                int nj = currPosition.j + dj;
                if (ni >= 0 && ni < ChessBoard.SIZE && nj >= 0 && nj < ChessBoard.SIZE)
                    positions.add(new Position(ni, nj));
            }
        }
        return positions;
    }
}