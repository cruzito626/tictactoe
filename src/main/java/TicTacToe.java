import model.Markable;

public class TicTacToe {
    private char firstPlayer;
    private char secondPlayer;
    private char lastPlayer;
    private char loser;
    private char winner;
    private Markable board;
    private int availableShifts;
    private boolean finished;


    public TicTacToe(Markable markable) {
        this.firstPlayer = 'X';
        this.secondPlayer = 'O';
        this.board = markable;
        initializeGame();
    }

    public TicTacToe(char firstPlayer, char secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        initializeGame();
    }

    private void initializeGame(){
        winner = ' ';
        loser = ' ';
        lastPlayer = ' ';
        finished = false;
        availableShifts = 9;
    }

    public Markable getBoard() {
        return board;
    }

    public boolean isFinished() {
        return finished;
    }

    public char getWinner() {
        return winner;
    }

    public char getLoser() {
        return loser;
    }

    public boolean markCell(int row, int col) {
        boolean marked;
        char player;
        marked = false;
        player = playerTurn();

        if (board.isValidMarkCell(row, col) && !isFinished()) {
            board.markCell(row, col, player);
            availableShifts--;
            marked = true;
            if(isWinningPlay() || availableShifts == 0) {
                if (isWinningPlay()) {
                    winner = player;
                    loser = lastPlayer;
                }
                finished = true;
            }
            lastPlayer = player;
        }
        return marked;
    }

    private boolean isWinningPlayVertical() {
        for (int col = 0; col < board.SIZE; col++) {

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
        for (int row = 0; row < board.SIZE; row++) {
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
