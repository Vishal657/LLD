package chess;

import chess.piece.*;

import java.util.List;

public class ChessBoard {
    public static final int SIZE = 8;
    public Cell[][] cells;
    public List<Player> players;
    public boolean whiteTurn;

    public ChessBoard(List<Player> players) {
        this.players = players;
        this.whiteTurn = true;
        this.cells = new Cell[SIZE][SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = new Cell(new Position(i, j), null);
            }
        }

        setupPieces(PieceColor.WHITE, 7, 6);
        setupPieces(PieceColor.BLACK, 0, 1);
    }

    private void setupPieces(PieceColor color, int backRow, int pawnRow) {
        cells[backRow][0].piece = new Rook(new Position(backRow, 0), color, this);
        cells[backRow][1].piece = new Knight(new Position(backRow, 1), color, this);
        cells[backRow][2].piece = new Bishop(new Position(backRow, 2), color, this);
        cells[backRow][3].piece = new Queen(new Position(backRow, 3), color, this);
        cells[backRow][4].piece = new King(new Position(backRow, 4), color, this);
        cells[backRow][5].piece = new Bishop(new Position(backRow, 5), color, this);
        cells[backRow][6].piece = new Knight(new Position(backRow, 6), color, this);
        cells[backRow][7].piece = new Rook(new Position(backRow, 7), color, this);

        for (int j = 0; j < SIZE; j++) {
            cells[pawnRow][j].piece = new Pawn(new Position(pawnRow, j), color, this);
        }
    }

    public Piece getPieceAt(Position position) {
        return cells[position.i][position.j].piece;
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Piece piece = cells[i][j].piece;
                System.out.print((piece == null ? "--" : getPieceSymbol(piece)) + " ");
            }
            System.out.println();
        }
    }

    private String getPieceSymbol(Piece piece) {
        String name = piece.getClass().getSimpleName().substring(0, 2).toUpperCase();
        if (piece instanceof King) name = "K";
        else if (piece instanceof Queen) name = "Q";
        else if (piece instanceof Bishop) name = "B";
        else if (piece instanceof Knight) name = "N";
        else if (piece instanceof Rook) name = "R";
        else if (piece instanceof Pawn) name = "P";

        if (piece instanceof Pawn pawn && pawn.pieceColor == PieceColor.BLACK) return name.toLowerCase();
        if (piece instanceof Rook rook && rook.pieceColor == PieceColor.BLACK) return name.toLowerCase();
        if (piece instanceof Knight knight && knight.pieceColor == PieceColor.BLACK) return name.toLowerCase();
        if (piece instanceof Bishop bishop && bishop.pieceColor == PieceColor.BLACK) return name.toLowerCase();
        if (piece instanceof Queen queen && queen.pieceColor == PieceColor.BLACK) return name.toLowerCase();
        if (piece instanceof King king && king.pieceColor == PieceColor.BLACK) return name.toLowerCase();

        return name;
    }
}
