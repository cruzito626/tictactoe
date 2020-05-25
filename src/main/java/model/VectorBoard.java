package model;

public class VectorBoard extends Board {
    private char [] board;

    public VectorBoard() {
        initializeBoard();
    }

    private void initializeBoard() {
        board = new char[SIZE_ROW * SIZE_COL];
        clear();
    }

    private int calculatePosition(int row, int col) {
        return SIZE_COL * row + col;
    }

    @Override
    public void setCell(int row, int col, char symbol) {
        board[calculatePosition( row, col)] = symbol;
    }

    @Override
    public char getCell(int row, int col) {
        return board[calculatePosition( row, col)];
    }

}
