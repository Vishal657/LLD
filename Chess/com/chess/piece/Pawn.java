package chess.piece;

import chess.ChessBoard;
import chess.PieceColor;
import chess.Position;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements Piece {
    public Position currPosition;
    public Position initialPosition;
    public PieceColor pieceColor;
    public ChessBoard board;

    public Pawn(Position initialPosition, PieceColor pieceColor, ChessBoard board) {
        currPosition = initialPosition.clone();
        this.initialPosition = initialPosition.clone();
        this.pieceColor = pieceColor;
        this.board = board;
    }

    @Override
    public List<Position> validPositions() {
        List<Position> positions = new ArrayList<>();
        int direction = pieceColor == PieceColor.WHITE ? -1 : 1;
        int newRow = currPosition.i + direction;
        if (newRow >= 0 && newRow < ChessBoard.SIZE) {
            positions.add(new Position(newRow, currPosition.j));
        }
        return positions;
    }

    private boolean movedOnce() {
        return !initialPosition.equals(currPosition);
    }
}