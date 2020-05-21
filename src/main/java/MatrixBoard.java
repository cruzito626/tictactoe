public class MatrixBoard implements Board{
    private char [][] board;

    public MatrixBoard() {
        initializeBoard();
    }

    public void initializeBoard() {
        board = new char[SIZE] [SIZE];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
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
        board[row][col] = playerSymbol;
    }

    @Override
    public char getCell(int row, int col) {
        return board[row][col];
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
