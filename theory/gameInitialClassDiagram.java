package theory;

@SuppressWarnings("ALL")
public class gameInitialClassDiagram {

    /*
    *    X |  O  |
    * _____|_____|_____
    *      |  X  |  O
    * _____|_____|_____
    *   O  |     |  X
    *
    * Vamos representar computacionalmente o jogo da velha (POO)
    *
    *           GAME  é o ponto de entrada, quem possui a lógica, para solicitar ao jogador fazer o movimento, verificar se o jogo terminou ou não,
    *                   quem foi o vencedor ou se houve empate
    *
    *           BOARD é o tabuleiro, onde se desenrolará o jogo (uma matriz de 3 x 3) com a inserção de símbolos
    *
    *           SYMBOL será utilizado pelo BOARD e pelo GAME
    *
    *           PLAYERS que na verdade é representado por um símbolo onde o primeiro jogador será X e o segundo O,
    *           por isso essa classe não representará um jogador mas os dois, é a classe que terá a lógica do próximo jogador
    *
    *
    *           Essas classes vão representar o núcleo do jogo
    *
    *
    *                    GAME
    *                     | |
    *                     | v
    *               BOARD | PlAYERS
    *                   | | |
    *                   v v v
    *                   SYMBOL
    *
    *
    *
    * */
}
