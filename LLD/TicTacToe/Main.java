package LLD.TicTacToe;

import LLD.TicTacToe.model.Piece;
import LLD.TicTacToe.model.Player;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player("p1", Piece.X);

        Player player2 = new Player("p2", Piece.O);

        TicTacToe game = new TicTacToe(3, List.of(player1, player2));

        game.start();
    }
}
