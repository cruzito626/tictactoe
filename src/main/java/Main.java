import model.Markable;
import model.MatrixBoard;
import model.TicTacToe;
import model.VectorBoard;
import view.Console;

public class Main {
    static TicTacToe ticTacToe;
    static Markable board;
    static Console console;
    static int[][] tiedGame = { {0, 0}, {0, 1}, {1, 1}, {2, 2}, {1, 2}, {1, 0}, {2, 0}, {0, 2}, {2, 1}};
    static int[][] winXGame = { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}};
    static int[][] winOGame = { {1, 0}, {0, 0}, {1, 1}, {0, 1}, {2, 2}, {0, 2}};

    public static void main(String[] args) {
        board = new VectorBoard();
        ticTacToe = new TicTacToe(board);
        console = new Console(ticTacToe);
        console.run();
    }
}












/*int[][] aux = tiedGame;
        for (int i = 0; i < aux.length; i++) {
            if (!ticTacToe.isFinished()) {
                System.out.printf("Player: %c%n", ticTacToe.playerTurn());
                ticTacToe.markCell(aux[i][0], aux[i][1]);
            } else {
                break;
            }
            //System.out.print(ticTacToe.getBoard());
        }
        if (ticTacToe.isWinningPlay()) {
            System.out.printf("Winner player: %c%n", ticTacToe.getWinner());
            System.out.printf("Loser player: %c%n", ticTacToe.getLoser());
        } else {
            System.out.println("Game tied");
        }*/