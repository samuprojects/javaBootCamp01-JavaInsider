package tictactoe.core;

@SuppressWarnings("ALL")
public class Game {

    private final Board board = new Board();
    private final Players players = new Players();

    public void start(){
        System.out.println("Jogo iniciado");

        // testando troca de jogadores
        System.out.println(players.next());
        System.out.println(players.next());
        System.out.println(players.next());
        System.out.println(players.next());
    }
}
