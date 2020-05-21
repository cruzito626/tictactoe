import java.util.Arrays;

public class VectorBoard implements Board {
    private char [] board;

    public VectorBoard() {
        initializeBoard();
    }

    public void initializeBoard() {
        board = new char[SIZE * SIZE];
        for (int i = 0; i < board.length; i++) {
            board[i] = ' ';
        }
    }

    //codigo repetido
    @Override
    public boolean markCell(int row, int col, char playerSymbol) {
        if (isValidMarkCell(row, col)) {
            setCell(row, col, playerSymbol);
            return true;
        }
        return false;
    }

    //codigo repetido
    @Override
    public boolean isValidMarkCell(int row, int col) {
        if (row >= ZERO && col >= ZERO &&
            row < SIZE && col < SIZE) {
            if (getCell(row, col) == ' ') {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setCell(int row, int col, char playerSymbol) {
        board[SIZE * row + col] = playerSymbol;
    }

    @Override
    public char getCell(int row, int col) {
        return board[SIZE * row + col];
    }

    //codigo repetido
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                string.append("["+getCell(row,col)+"]");
            }
            string.append("\n");
        }
        return string.toString();
    }
}
