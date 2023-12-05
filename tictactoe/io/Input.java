package tictactoe.io;

import java.util.Scanner;

@SuppressWarnings("ALL")
public final class Input {

    private Input(){}

    public static String read(String message){ // ler informação do teclado, fica bloqueado até o usuário digitar a informação e dar um enter
        if (message != null) {
            Output.write(message + " ", false); // alterado o write para não quebrar linha nesse caso
        }

        return new Scanner(System.in).nextLine(); // não fechar o Scanner pois fechará o System.in e não poderá ler dados do console
    }
}
