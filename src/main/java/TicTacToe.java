public class TicTacToe {
    private char[][] table;
    static final char PLAYERONE = 'X';
    static final char PLAYERTWO = 'O';
    static final int sizetable = 3;
    private int availableShifts;
    private boolean finished;
    private char winner;

    public TicTacToe() {
        table = new char[sizetable][sizetable];
        availableShifts = 0;
        winner = ' ';
        finished = false;
    }

    public char[][] getTable() {
        return table;
    }

    public int getAvailableShifts() {
        return availableShifts;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public char getWinner() {
        return winner;
    }

    public void setWinner(char winner) {
        this.winner = winner;
    }

    public boolean startGame(){
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                table[row][col] = ' ';
                availableShifts++;
            }
        }
        winner = ' ';
        finished = false;
        return availableShifts == 9;
    }

    public void checkBox(int row, int col) {
        if (table[row][col] == ' ' && !finished) {
            table[row][col] = playerTurn();
            setFinished(winningPlay());
            if(isFinished()){
                setWinner(playerTurn());
            }
            availableShifts--;
            if (availableShifts == 0) {
                setFinished(true);
            }
        }
    }

    private boolean winningPlayVertical() {
        for (int col = 0; col < table.length; col++) {
            if (table[0][col] == table[1][col] && table[2][col] == table[1][col]) {
                if (table[0][col] == PLAYERONE || table[0][col] == PLAYERTWO) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean winningPlayHorizontal() {
        for (int row = 0; row < table.length; row++) {
            if (table[row][0] == table[row][1] && table[row][2] == table[row][1]) {
                if (table[row][0] == PLAYERONE || table[row][0] == PLAYERTWO) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean winningPlayUpperDiagonal() {
        boolean diagonal = table[0][0] == table[1][1] && table[1][1] == table[2][2];
        boolean players = table[0][0] == PLAYERONE || table[0][0] == PLAYERTWO;
        return diagonal && players;
    }

    private boolean winningPlayBottomDiagonal() {
        boolean diagonal = table[0][2] == table[1][1] && table[1][1] == table[2][0];
        boolean players = table[2][0] == PLAYERONE || table[2][0] == PLAYERTWO;
        return diagonal && players;
    }

    private boolean winningPlay() {
        return winningPlayVertical() || winningPlayHorizontal() || winningPlayUpperDiagonal() || winningPlayBottomDiagonal();
    }

    private char playerTurn() {
        return availableShifts % 2 == 1 ? PLAYERONE : PLAYERTWO;
    }
}
