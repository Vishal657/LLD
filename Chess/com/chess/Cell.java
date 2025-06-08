package chess;

import chess.piece.Piece;

public class Cell {

    Position position;
    Piece piece;

    public Cell(Position position, Piece piece) {
        this.piece = piece;
        this.position = position;
    }

}
