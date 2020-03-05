import java.util.Random;

public class main {
    public static void main(String[] args) {
        int row;
        int col;
        TicTacToe ticTacToe = new TicTacToe();
        Random random = new Random();


        while (!ticTacToe.isFinished()){
            row = random.nextInt(3);
            col = random.nextInt(3);
            ticTacToe.markCell(row,col);
        }
        for (char[] eles: ticTacToe.getTable()) {
            for (char ele: eles) {
                System.out.print(ele);
            }
            System.out.println();
        }
        System.out.printf("Available shitfs is %d%n", ticTacToe.getAvailableShifts());
        char winner = ticTacToe.getWinner();
        if(winner != ' '){
            System.out.printf("Winner player %c%n", ticTacToe.getWinner());
        } else {
            System.out.println("tied!!");
        }
    }
}
