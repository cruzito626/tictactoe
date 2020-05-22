package model;

public class VectorBoard extends Board {
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
