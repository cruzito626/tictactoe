public interface Board {
    int SIZE = 3;
    int ZERO = 0;
    boolean markCell(int row, int col, char playerSymbol);
    boolean isValidMarkCell(int row, int col);
    void setCell(int row, int col, char playerSymbol);
    char getCell(int row, int col);
}
