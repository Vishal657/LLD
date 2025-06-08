package chess.piece;

import chess.*;

import java.util.*;

public class Queen implements Piece {
    public Position currPosition;
    public PieceColor pieceColor;
    public ChessBoard board;

    public Queen(Position position, PieceColor color, ChessBoard board) {
        this.currPosition = position.clone();
        this.pieceColor = color;
        this.board = board;
    }

    @Override
    public List<Position> validPositions() {
        List<Position> positions = new ArrayList<>();
        positions.addAll(new Rook(currPosition, pieceColor, board).validPositions());
        positions.addAll(new Bishop(currPosition, pieceColor, board).validPositions());
        return positions;
    }
}
