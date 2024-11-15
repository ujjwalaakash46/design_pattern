package LLD.TicTacToe;

import LLD.TicTacToe.model.Board;
import LLD.TicTacToe.model.Piece;
import LLD.TicTacToe.model.Player;

import java.util.*;

public class TicTacToe {
    private Deque<Player> players;
    private Board board;

    public TicTacToe(int size, List<Player> playerList){
        board = new Board(size);
        players = new LinkedList<>(playerList);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            board.printBoard();

            // Get the current player from the queue
            Player currentPlayer = players.poll();
            assert currentPlayer != null;
            System.out.println(currentPlayer.name() + "'s turn. Enter row and column: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board.makeMove(row, col, currentPlayer.piece())) {
                if (checkWin(row, col, currentPlayer.piece())) {
                    board.printBoard();
                    System.out.println(currentPlayer.name() + " wins!");
                    break;
                }
                if (board.isFull()) {
                    board.printBoard();
                    System.out.println("It's a draw!");
                    break;
                }
                // Add the player back to the queue for the next turn
                players.add(currentPlayer);
            } else {
                System.out.println("Invalid move! Try again.");
                players.addFirst(currentPlayer); // Re-add player without skipping their turn
            }
        }
    }

    private boolean checkWin(int row, int col, Piece piece) {
        if (checkRow(row, piece)) {
            return true;
        }

        // Check the column
        if (checkColumn(col, piece)) {
            return true;
        }

        // Check the main diagonal (top-left to bottom-right)
        if (row == col && checkMainDiagonal(piece)) {
            return true;
        }

        // Check the anti-diagonal (top-right to bottom-left)
        if (row + col == board.getSize() - 1 && checkAntiDiagonal(piece)) {
            return true;
        }

        return false; // No win condition met
    }

    private boolean checkRow(int row, Piece piece) {
        for (int col = 0; col < board.getSize(); col++) {
            if (board.getGrid()[row][col].getPiece() != piece) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int col, Piece piece) {
        for (int row = 0; row < board.getSize(); row++) {
            if (board.getGrid()[row][col].getPiece() != piece) {
                return false;
            }
        }
        return true;
    }

    private boolean checkMainDiagonal(Piece piece) {
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getGrid()[i][i].getPiece() != piece) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAntiDiagonal(Piece piece) {
        int size = board.getSize();
        for (int i = 0; i < size; i++) {
            if (board.getGrid()[i][size - 1 - i].getPiece() != piece) {
                return false;
            }
        }
        return true;
    }
}