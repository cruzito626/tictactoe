
import model.ITicTacToe;
import model.TicTacToe;
import view.Console;

public class Main {
    public static void main(String[] args) {
        ITicTacToe game = new TicTacToe();
        Console console = new Console(game);
        console.run();
    }
}