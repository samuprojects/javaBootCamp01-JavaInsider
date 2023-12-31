package tictactoe.core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

import static java.util.Objects.requireNonNull;

@SuppressWarnings("ALL")
public class Board {

    // o tabuleiro é representado por uma matriz de 3 x 3
    public static final int SIZE = 3;

    private final Symbol[][] matrix = new Symbol[SIZE][SIZE];

    // tabuleiro deve iniciar vazio com símbolo do NONE
    public Board() {
        for (Symbol[] symbols : matrix) {
            Arrays.fill(symbols, Symbol.NONE);// método que preenche o array os índices do array com alguma coisa
        }
    }

    // sobrescrita do toString para mostrar de um jeito personalizado o tabuleiro conforme comentário a seguir
    /*
     * X | X | X
     * ---------
     * X | X | X
     * ---------
     * X | X | X
     *
     * pode usar o StringBuilder (com append) ou Print / Println (com o PrintWriter)
     * */
    @Override
    public String toString() {
        StringWriter sw = new StringWriter();
        PrintWriter out = new PrintWriter(sw);

        for (int i = 0; i < SIZE; i++) {

            boolean first = true;
            for (int j = 0; j < SIZE; j++) {
                if (!first) {
                    out.print(" | "); // acrescenta separador com pipe onde não seja o primeiro símbolo à esquerda
                }

                out.print(matrix[i][j]);
                first = false; // para imprimir o pipe após os demais símbolos

            }
            out.println(); // quebra linha no formato do jogo

            if (i + 1 < SIZE) { // lógica para não imprimir quando for a última linha com símbolos
                for (int j = 0; j < SIZE; j++) {
                    out.print("---"); // impressão linha separadora após a quebra da linha
                }
                out.println(); // quebra linha para ficar abaixo dos símbolos
            }
        }

        return sw.toString();
    }

    public Symbol update(Symbol symbol, Coord coord) { // alteração para retornar Symbol do ganhador ou null antes da proxima jogada
        requireNonNull(symbol); // validação para não aceitar símbolo nulo
        requireNonNull(coord); // validação para não aceitar coordenada nula

        if (symbol == Symbol.NONE) { // validação para não permitir uso do NONE (espaço em branco)
            throw new IllegalArgumentException("None cannot be added to board");
        }

        if (matrix[coord.i()][coord.j()] != Symbol.NONE) { // validação para verificar se já existe jogada de outro player
            throw new IllegalArgumentException("Play is not possible");
        }
        matrix[coord.i()][coord.j()] = symbol;
        return findSequence(); // verificar se teve ganhador
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (matrix[i][j] == Symbol.NONE) {
                    return false;
                }
            }
        }
        return true;
    }

    private Symbol findSequence() {
        Symbol symbol = findSequenceInRows();
        if (symbol != null) {
            return symbol;
        }

        symbol = findSequenceInColumns();
        if (symbol != null) {
            return symbol;
        }

        return findSequenceInDiagonals();
    }

    private Symbol findSequenceInRows() { // faz a busca em várias linhas
        for (int i = 0; i < SIZE; i++) {
            Symbol symbol = findSequenceInRow(i);
            if (symbol != null) {
                return symbol;
            }
        }
        return null;
    }

    private Symbol findSequenceInRow(int i) { // faz a busca em uma linha
        return matrix[i][0] == matrix[i][1]
                && matrix[i][1] == matrix[i][2]
                && matrix[i][0] != Symbol.NONE
                ? matrix[i][0]
                : null;
    }

    private Symbol findSequenceInColumns() { // varre as colunas
        for (int j = 0; j < SIZE; j++) {
            Symbol symbol = findSequenceInColumn(j);
            if (symbol != null) {
                return symbol;
            }
        }
        return null;
    }

    private Symbol findSequenceInColumn(int j) { // faz a busca coluna
        return matrix[0][j] == matrix[1][j]
                && matrix[1][j] == matrix[2][j]
                && matrix[0][j] != Symbol.NONE
                ? matrix[0][j]
                : null;
    }

    private Symbol findSequenceInDiagonals() { // busca nas diagonais
        if (matrix[0][0] == matrix[1][1]
                && matrix[1][1] == matrix[2][2]
                && matrix[0][0] != Symbol.NONE
        ) {
            return matrix[0][0];
        }

        if (matrix[0][2] == matrix[1][1]
                && matrix[1][1] == matrix[2][0]
                && matrix[0][2] != Symbol.NONE
        ) {
            return matrix[0][2];
        }

        return null;
    }
}