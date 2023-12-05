package tictactoe.core;

import tictactoe.io.Input;
import tictactoe.io.Output;

@SuppressWarnings("ALL")
public class Game {

    private final Board board = new Board();
    private final Players players = new Players();

    public void start() {



        // primeira versão do loop do jogo
        while (true) {
            Output.writeNewLine();
            Output.write(board); // mostra o tabuleiro em branco
            play(players.next()); // players.next é o proximo símbolo do jogador na jogada



        }

    }

    private void play(Symbol symbol) { // método com validação só prossegue quando jogada válida
        while (true){
            try {
                String play = Input.read(String.format("'%s' Play =>", symbol));
                Coord coord = Coord.parse(play);
                board.update(symbol, coord);
                break;
            } catch (RuntimeException e){
                Output.write("ERROR: " + e.getMessage());
            }
        }

    }
}
