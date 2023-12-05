package tictactoe.core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

public class Board {

    // o tabuleiro é representado por uma matriz de 3 x 3
    public static final int SIZE = 3;

    public final Symbol[][] matrix = new Symbol[SIZE][SIZE];

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
            }

            out.println(); // quebra linha para ficar abaixo dos símbolos
        }

        return sw.toString();
    }

}
