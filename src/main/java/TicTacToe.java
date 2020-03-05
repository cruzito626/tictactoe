public class TicTacToe {
    static final char PLAYERONE = 'X';
    static final char PLAYERTWO = 'O';
    static final int sizetable = 3;
    private char[][] table;
    private int availableShifts;
    private boolean finished;
    private char winner;

    public TicTacToe() {
        table = new char[sizetable][sizetable];
        availableShifts = 0;
        winner = ' ';
        finished = false;
        initializeTable();
    }

    public char[][] getTable() {
        return table;
    }

    public char getCell(int row, int col){
        return table[row][col];
    }

    public int getAvailableShifts() {
        return availableShifts;
    }

    public boolean isFinished() {
        return isWinningPlay() || availableShifts == 0;
    }

    public char getWinner() {
        return winner;
    }

    private void initializeTable(){
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                table[row][col] = ' ';
                availableShifts++;
            }
        }
    }

    private boolean isValidMarkCell(int row, int col){
        return table[row][col] == ' '  && !isFinished();
    }

    public boolean markCell(int row, int col) {
        boolean marked;
        char player;
        marked = false;
        player = playerTurn();

        if (isValidMarkCell(row, col)) {
            table[row][col] = player;
            marked = true;
            availableShifts--;
            if(isFinished()) {
                if (isWinningPlay()) {
                    winner = player;
                }
            }
        }
        return marked;
    }

    private boolean isWinningPlayVertical() {
        for (int col = 0; col < table.length; col++) {
            if (table[0][col] == table[1][col] && table[2][col] == table[1][col]) {
                if (table[0][col] == PLAYERONE || table[0][col] == PLAYERTWO) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWinningPlayHorizontal() {
        for (int row = 0; row < table.length; row++) {
            if (table[row][0] == table[row][1] && table[row][2] == table[row][1]) {
                if (table[row][0] == PLAYERONE || table[row][0] == PLAYERTWO) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWinningPlayUpperDiagonal() {
        boolean diagonal = table[0][0] == table[1][1] && table[1][1] == table[2][2];
        boolean players = table[0][0] == PLAYERONE || table[0][0] == PLAYERTWO;
        return diagonal && players;
    }

    private boolean isWinningPlayBottomDiagonal() {
        boolean diagonal = table[0][2] == table[1][1] && table[1][1] == table[2][0];
        boolean players = table[2][0] == PLAYERONE || table[2][0] == PLAYERTWO;
        return diagonal && players;
    }

    public boolean isWinningPlay() {
        return isWinningPlayVertical() || isWinningPlayHorizontal() || isWinningPlayUpperDiagonal() || isWinningPlayBottomDiagonal();
    }

    public char playerTurn() {
        return availableShifts % 2 == 1 ? PLAYERONE : PLAYERTWO;
    }
}
