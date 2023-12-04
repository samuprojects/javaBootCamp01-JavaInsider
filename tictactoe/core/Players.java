package tictactoe.core;

import java.util.ArrayList;
import java.util.List;

public class Players { // unica função é de controlar os jogadores

    private final List<Symbol> players = new ArrayList<>(2); // como são sempre dois jogadores podemos otimizar já definindo isso para o Java e economizando memória

    // para controle do jogador atual
    private int currentPlayerIndex = -1;

    public Players() {
        players.add(Symbol.X);
        players.add(Symbol.O);
    }

    // lógica (conceito de lista circular) para Players entregar sempre o próximo jogador da vez
    public Symbol next(){
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        return players.get(currentPlayerIndex);
    }
}
