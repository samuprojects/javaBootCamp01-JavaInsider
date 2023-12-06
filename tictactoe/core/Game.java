package tictactoe.core;

import tictactoe.io.Input;
import tictactoe.io.Output;

@SuppressWarnings("ALL")
public class Game {

    private final Board board = new Board();
    private final Players players = new Players();

    public void start() {

        Symbol winner = null; // variável criada para armazenar informação da checagem se há vencedor ou não

        // primeira versão do loop do jogo
        while (winner == null) { // alterado para loop enquanto não tiver um ganhador, ou seja, enquanto winner for null
            Output.writeNewLine();
            Output.write(board); // mostra o tabuleiro em branco
            winner = play(players.next()); // players.next é o proximo símbolo do jogador na jogada
        }

        Output.write(String.format("%s is the winner!", winner));

    }

    private Symbol play(Symbol symbol) { // método com validação só prossegue quando jogada válida
        while (true){
            try {
                String play = Input.read(String.format("'%s' Play =>", symbol));
                Coord coord = Coord.parse(play);
                return board.update(symbol, coord); // alterado para checagem do vencedor ou continuidade do jogo
            } catch (RuntimeException e){
                Output.write("ERROR: " + e.getMessage());
            }
        }
    }

    /*
    * resposta de uma pergunta de amigos no fórum sobre alterações dos métodos update (Board), play e start
    * O Symbol é retorno de quem ganhou, então após atualização (update), o símbolo do
    * jogador que ganhou é retornado pelo método update, e se o retorno for null significa que
    * ninguém ganhou. Com essa mudança, o método play passou a receber o retorno do método
    * update e consequentemente o método start passou a conhecer também esse retorno, pois o
    * método play é chamado nele. Com esse retorno do símbolo do jogador que ganhou em mãos,
    * foi possível alterar o while (true) para while (winner == null) a fim de identificar o jogador
    * vencedor para encerrar o loop do jogo, pois o while (true) deixava o jogo num loop infinito!
     * */
}
