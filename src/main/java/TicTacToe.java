public class TicTacToe {
    private char firstPlayer;
    private char secondPlayer;
    private char lastPlayer;
    private char loser;
    private char winner;
    static final int SIZE = 3;
    private char[][] table;
    private int availableShifts;
    private boolean finished;


    public TicTacToe() {
        this.firstPlayer = 'X';
        this.secondPlayer = 'O';
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
        availableShifts = 0;

        table = new char[SIZE][SIZE];

        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                table[row][col] = ' ';
                availableShifts++;
            }
        }
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

    private boolean isValidMarkCell(int row, int col){
        return table[row][col] == ' ';
    }

    public boolean markCell(int row, int col) {
        boolean marked;
        char player;
        marked = false;
        player = playerTurn();

        if (isValidMarkCell(row, col) && !isFinished()) {
            table[row][col] = player;
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
        System.out.println(availableShifts);
        return marked;
    }

    private boolean isWinningPlayVertical() {
        for (int col = 0; col < table.length; col++) {
            if (table[0][col] == table[1][col] && table[2][col] == table[1][col]) {
                if (table[0][col] == firstPlayer || table[0][col] == secondPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWinningPlayHorizontal() {
        for (int row = 0; row < table.length; row++) {
            if (table[row][0] == table[row][1] && table[row][2] == table[row][1]) {
                if (table[row][0] == firstPlayer || table[row][0] == secondPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWinningPlayUpperDiagonal() {
        boolean diagonal = table[0][0] == table[1][1] && table[1][1] == table[2][2];
        boolean players = table[0][0] == firstPlayer || table[0][0] == secondPlayer;
        return diagonal && players;
    }

    private boolean isWinningPlayBottomDiagonal() {
        boolean diagonal = table[0][2] == table[1][1] && table[1][1] == table[2][0];
        boolean players = table[2][0] == firstPlayer || table[2][0] == secondPlayer;
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
