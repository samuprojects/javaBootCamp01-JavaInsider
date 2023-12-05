package tictactoe.core;

import static java.util.Objects.requireNonNull;
import static tictactoe.core.Board.SIZE;
import static tictactoe.util.ValidationUtils.require;

@SuppressWarnings("ALL")
public record Coord(int i, int j) {
    // relembrando que uma classe record representa a capacidade da classe agrupar informações

    // o construtor de Record é um pouco diferente do normal pois não tem os parenteses e te dá acessos aos parametros já informados anteriormente
    public Coord {
        require(i >= 0 && i < SIZE, "i is out of range"); // utilizado classe utilitária genérica para validar número das coordenadas digitadas
        require(i >= 0 && i < SIZE, "j is out of range");
    }


    public static Coord parse(String text) { // vai transformar o texto digitado pelo usuário num objeto Coord para representar a jogada linha, coluna

        // validação para garantir que o texto não seja nulo
        requireNonNull(text); // se for nulo lança exceção

        String[] tokens = text.split(","); // split permite passar um parametro delimitador para quebrar informação e retornar um array com os pedaços dessa String

        //validação verificar tamanho do tokens
        if (tokens.length != 2) {
            throw new IllegalArgumentException("Invalid Format");
        }

        // validação para caso usuário digite letras ao invés de números nas coordenadas
        try {
            return new Coord(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number");
        }

    }
}
