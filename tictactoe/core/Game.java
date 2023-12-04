package tictactoe.core;

@SuppressWarnings("ALL")
public class Game {

    private final Board board = new Board();
    private final Players players = new Players();

    public void start() {

        // teste impressão do tabuleiro
        System.out.println(board);

    }
}
