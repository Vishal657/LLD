package chess.piece;

import chess.Position;

import java.util.List;

public interface Piece {

    List<Position> validPositions();

}
