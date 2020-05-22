package model;

public class MatrixBoard extends Board {
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
