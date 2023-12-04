package tictactoe.core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

public class Board {

    // o tabuleiro é representado por uma matriz de 3 x 3
    public static final int SIZE = 3;

    public final Symbol[][] matrix = new Symbol[SIZE][SIZE];

    // tabuleiro deve iniciar vazio com símbolo do NONE
    public Board(){
        for (Symbol[] symbols : matrix) {
            Arrays.fill(symbols, Symbol.X);// método que preenche o array os índices do array com alguma coisa
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
            for (int j = 0; j < SIZE; j++){
                out.print(matrix[i][j] + " ");

            }
        }

        return sw.toString();
    }
}
