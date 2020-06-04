package model;
import static model.Symbol.X;
import static model.Symbol.O;
import static model.Symbol.Empty;

public class TicTacToe implements ITicTacToe {
    static final int SIZE_ROW = 3;
    static final int SIZE_COLUMN = 3;
    static final int ZERO = 0;

    private Symbol firstPlayer;
    private Symbol secondPlayer;
    private Symbol turn;
    private Symbol winner;
    private Symbol[][] board = new Symbol[SIZE_ROW][SIZE_COLUMN];
    private int availableShifts;

    public TicTacToe() {
        this.firstPlayer = X;
        this.secondPlayer = O;
        winner = Empty;
        turn = O;
        availableShifts = 9;
        create();
    }

    @Override
    public void create() {
        for (int row = 0; row < SIZE_ROW; row++) {
            for (int column = 0; column < SIZE_COLUMN; column++) {
                setCell(row, column, Empty);
            }
        }
    }

    @Override
    public boolean markMove(int row, int column) {
        boolean marked;
        Symbol player;
        marked = false;
        player = getTurn();
        if (isValid(row, column)) {
            setCell(row, column, player);
            marked = true;
            endOfShift(player);
        }
        return marked;
    }

    @Override
    public boolean checkTicTacToe() {
        return checkTicTacToeColumn() || checkTicTacToeRow() || checkTicTacToeDiagonal();
    }

    @Override
    public char winner() {
        return winner.toChar();
    }

    @Override
    public boolean draw() {
        return availableShifts == 0;
    }

    @Override
    public char[][] getBoard() {
        char[][] board = new char[SIZE_ROW][SIZE_COLUMN];
        for (int row = 0; row < SIZE_ROW; row++) {
            for (int column = 0; column < SIZE_COLUMN; column++) {
                board[row][column] = getCell(row, column).toChar();
            }
        }
        return board;
    }

    private void setCell(int row, int column, Symbol symbol) {
        board[row][column] = symbol;
    }

    private Symbol getTurn() {
        if (turn == Empty || turn == secondPlayer) {
            return firstPlayer;
        } else {
            return secondPlayer;
        }
    }

    private boolean isValid(int row, int column) {
        return inRange(row, ZERO, SIZE_ROW) && inRange(column, ZERO, SIZE_COLUMN) && isEmptyCell( row, column);
    }

    private Symbol getCell(int row, int column) {
        return board[row][column];
    }

    private boolean isEmptyCell(int row, int column) {
        return getCell(row, column) == Empty;
    }

    private boolean inRange(int number, int start, int end) {
        return number >= start && number < end;
    }

    private void endOfShift(Symbol player) {
        availableShifts--;
        if (checkTicTacToe()) {
            winner = player;
        }
        turn = player;
    }

    private boolean checkTicTacToeColumn() {
        for (int column = 0; column < SIZE_ROW; column++) {
            if (getCell(0,column) == getCell(1,column) && getCell(2,column) == getCell(1,column)) {
                if (getCell(0,column) == firstPlayer || getCell(0,column) == secondPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkTicTacToeRow() {
        for (int row = 0; row < SIZE_ROW; row++) {
            if (getCell(row,0) == getCell(row, 1) && getCell(row, 2) == getCell(row, 1)) {
                if (getCell(row,0) == firstPlayer || getCell(row,0) == secondPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkTicTacToeDiagonal() {
        boolean firstDiagonal, secondDiagonal;
        boolean players;
        Symbol centerCell = getCell(1,1);
        firstDiagonal = getCell(0,0) == centerCell && centerCell == getCell(2,2);
        secondDiagonal = getCell(0,2) == centerCell && centerCell == getCell(2,0);
        players = getCell(1,1) == firstPlayer || getCell(1,1) == secondPlayer;
        return (firstDiagonal || secondDiagonal) && players;
    }
}
