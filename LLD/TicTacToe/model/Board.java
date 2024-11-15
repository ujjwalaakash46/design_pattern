package LLD.TicTacToe.model;

import java.util.stream.IntStream;

public class Board {

    private final Cell[][] grid;
    private final int size;

    public Board(int boardSize){
        this.size=boardSize;
        grid = new Cell[size][size];

        IntStream.range(0, size).forEach(row->{
            IntStream.range(0, size).forEach(col->{
                grid[row][col] = new Cell();
            });
        });

    }

    public boolean isFull() {
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                if (cell.getPiece() == Piece.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean makeMove(int row, int col, Piece piece) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            return false; // Invalid move
        }
        Cell cell = grid[row][col];
        if (cell.getPiece() != Piece.EMPTY) {
            return false; // Cell already occupied
        }
        cell.setPiece(piece);
        return true;
    }

    public void printBoard() {
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                System.out.print("| " + cell.getPiece() + " ");
            }
            System.out.println("|");
        }
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public int getSize() {
        return size;
    }
}
