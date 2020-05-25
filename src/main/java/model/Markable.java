package model;

public interface Markable {
    int SIZE_COL = 3;
    int SIZE_ROW = 3;

    void clear();
    boolean markCell(int row, int col, char playerSymbol);
    boolean isEmptyCell(int row, int col);
    void setCell(int row, int col, char symbol);
    char getCell(int row, int col);
}
