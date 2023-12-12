package tictactoe.core;

@SuppressWarnings("ALL")
public enum Symbol {

    X ('X'),
    O ('O'),
    NONE (' '); // importante para identificar o que está em branco no tabuleiro

    private final char charSymbol; // a informação do símbolo deve ser armazenada em algum lugar, esta variável, e é final porque não será alterada.

    Symbol(char charSymbol) {
        this.charSymbol = charSymbol;
    } // o valor recebido no construtor vai para o atributo

    // para usar a reprersentação visual dentro do construtor, sobrescrever o método toString
    // porque o toString do enum retorna o próprio elemento, ou seja, com o tabuleiro em branco
    // apresentaria NONE e não o espaço em branco.
    @Override
    public String toString() {
        return String.valueOf(charSymbol); // como charSymbol é um char devemos converter para String que é o retorno do toString
    }
}
