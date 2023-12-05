package tictactoe.io;

// pacote io para conter as classes que vão receber os comandos de entrada e saída do jogador

// a classe foi declarada como final para impedir que seja estendida e que seja criado novos construtores

@SuppressWarnings("ALL")
public final class Output {

    private Output(){} // optado por manter construtor privado pois não haverá necessidade de criar objetos em outro lugar

    public static void writeNewLine (){ // o método estático podera ser chamado sem necessidade de uma instância do Objeto Output
        write(null);
    }

    public static void write (Object obj) {
        write(obj, true); // aqui não passando nada adiciona uma novalinha, senão segue o outro construtor
    }

    public static void write (Object obj, boolean addNewLine) { // o método estático podera ser chamado sem necessidade de uma instância do Objeto Output
        if (obj == null) {
            System.out.println();
        } else {
            // se o objeto for diferente de nulo
            if (addNewLine){
                System.out.println(obj);
            } else {
                // senão faz só o print so objeto
                System.out.println(obj);

            }
        }
    }
}
