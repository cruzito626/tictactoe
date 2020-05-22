package model;

public abstract class Board implements Markable{
    @Override
    public boolean markCell(int row, int col, char playerSymbol) {
        if (isValidMarkCell(row, col)) {
            setCell(row, col, playerSymbol);
            return true;
        }
        return false;
    }

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
}
