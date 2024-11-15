package LLD.TicTacToe.model;

public enum Piece {
    X("X"),
    O("O"),
    EMPTY("-");

    private final String display; // Custom display character for each piece

    Piece(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }

    @Override
    public String toString() {
        return display; // Default display behavior
    }

}
