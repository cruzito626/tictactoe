package model;

import model.Markable;

public class TicTacToe {
    private char firstPlayer;
    private char secondPlayer;
    private char lastPlayer;
    private char loser;
    private char winner;
    private Markable board;
    private int availableShifts;


    public TicTacToe(Markable board) {
        this.firstPlayer = 'X';
        this.secondPlayer = 'O';
        this.board = board;
        initializeGame();
    }

    public TicTacToe(char firstPlayer, char secondPlayer, Markable board) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.board = board;
        initializeGame();
    }

    public void restart() {
        board.clear();
        initializeGame();
    }

    private void initializeGame(){
        winner = ' ';
        loser = ' ';
        lastPlayer = ' ';
        availableShifts = 9;
    }


    public boolean isFinished() {
        return (isWinningPlay() || availableShifts == 0);
    }

    public char getWinner() {
        return winner;
    }

    public char getLoser() {
        return loser;
    }

    public char getCell(int row, int col) {
        return board.getCell(row, col);
    }

    public boolean markCell(int row, int col) {
        boolean marked;
        char player;
        marked = false;
        player = playerTurn();

        if (!isFinished()) {
            if (board.markCell(row, col, player)) {
                marked = true;
                endOfShift(player);
            }
        }
        return marked;
    }

    private void endOfShift(char player) {
        availableShifts--;
        if (isWinningPlay()) {
            winner = player;
            loser = lastPlayer;
        }
        lastPlayer = player;
    }

    private boolean isWinningPlayVertical() {
        for (int col = 0; col < board.SIZE_ROW; col++) {
            if (board.getCell(0,col) == board.getCell(1,col) &&
                    board.getCell(2,col)== board.getCell(1,col)) {

                if (board.getCell(0,col) == firstPlayer ||
                        board.getCell(0,col) == secondPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWinningPlayHorizontal() {
        for (int row = 0; row < board.SIZE_COL; row++) {
            if (board.getCell(row,0) == board.getCell(row, 1) &&
                    board.getCell(row, 2) == board.getCell(row, 1)) {
                if (board.getCell(row,0) == firstPlayer ||
                        board.getCell(row,0) == secondPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWinningPlayUpperDiagonal() {
        boolean diagonal = board.getCell(0,0) == board.getCell(1,1) &&
                board.getCell(1,1) == board.getCell(2,2);
        boolean players = board.getCell(0,0) == firstPlayer ||
                board.getCell(0,0) == secondPlayer;
        return diagonal && players;
    }

    private boolean isWinningPlayBottomDiagonal() {
        boolean diagonal = board.getCell(0,2) == board.getCell(1,1) &&
                board.getCell(1,1) == board.getCell(2,0);
        boolean players = board.getCell(2,0) == firstPlayer || board.getCell(0,2) == secondPlayer;
        return diagonal && players;
    }

    public boolean isWinningPlay() {
        return isWinningPlayVertical() || isWinningPlayHorizontal() || isWinningPlayUpperDiagonal() || isWinningPlayBottomDiagonal();
    }

    public char playerTurn() {
        if (lastPlayer == ' ' || lastPlayer == secondPlayer) {
            return firstPlayer;
        } else {
            return secondPlayer;
        }
    }
}
