package model;

public abstract class Board implements Markable {

    @Override
    public void clear() {
        for (int row = 0; row < SIZE_ROW; row++) {
            for (int col = 0; col < SIZE_COL; col++) {
                setCell(row, col,' ');
            }
        }
    }

    @Override
    public boolean markCell(int row, int col, char playerSymbol) {
        if (isEmptyCell(row, col)) {
            setCell(row, col, playerSymbol);
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmptyCell(int row, int col) {
        return getCell(row, col) == ' ';
    }
}
