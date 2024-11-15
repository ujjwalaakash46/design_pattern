package LLD.TicTacToe.model;

public class Cell {

    private Piece piece;

    public Cell() {
        this.piece = Piece.EMPTY;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
