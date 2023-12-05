package tictactoe.core;

import static java.util.Objects.requireNonNull;

@SuppressWarnings("ALL")
public record Coord(int i, int j) {
    // relembrando que uma classe record representa a capacidade da classe agrupar informações

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
