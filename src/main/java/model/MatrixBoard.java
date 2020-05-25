package model;

public class MatrixBoard extends Board {
    private char [][] board;

    public MatrixBoard() {
        initializeBoard();
    }

    private void initializeBoard() {
        board = new char[SIZE_ROW] [SIZE_COL];
        clear();
    }

    @Override
    public void setCell(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    @Override
    public char getCell(int row, int col) {
        return board[row][col];
    }
}
