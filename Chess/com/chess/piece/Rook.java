package chess.piece;

import chess.ChessBoard;
import chess.PieceColor;
import chess.Position;

import java.util.ArrayList;
import java.util.List;

public class Rook implements Piece {
    public Position currPosition;
    public PieceColor pieceColor;
    public ChessBoard board;

    public Rook(Position position, PieceColor color, ChessBoard board) {
        this.currPosition = position.clone();
        this.pieceColor = color;
        this.board = board;
    }

    @Override
    public List<Position> validPositions() {
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < ChessBoard.SIZE; i++) {
            if (i != currPosition.i) positions.add(new Position(i, currPosition.j));
            if (i != currPosition.j) positions.add(new Position(currPosition.i, i));
        }
        return positions;
    }
}
