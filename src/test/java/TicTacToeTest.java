import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TicTacToeTest {

    private TicTacToe ticTacToe;
    private  boolean finished;
    @Before
    public void init() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void testStartGame() {
        finished = false;
        boolean startGame = true;

        assertEquals(startGame, ticTacToe.startGame());
        assertEquals(finished, ticTacToe.isFinished());
    }

    @Test
    public void testToCheckAnEmptyBoxOnAnEmptyBoard() {
        ticTacToe.startGame();
        ticTacToe.checkBox(1, 2);

        char[][] tableAnswer = {{' ', ' ', ' '},
                {' ', ' ', 'X'},
                {' ', ' ', ' '}};
        finished = false;

        assertArrayEquals(tableAnswer, ticTacToe.getTable());
        assertEquals(finished, ticTacToe.isFinished());
    }

    @Test
    public void testToCheckAnEmptyBoxOnAPlayedBoard() {
        ticTacToe.startGame();
        ticTacToe.checkBox(1, 2);
        ticTacToe.checkBox(1, 1);

        finished = false;
        char[][] tableAnswer = {{' ', ' ', ' '},
                {' ', 'O', 'X'},
                {' ', ' ', ' '}};

        assertArrayEquals(tableAnswer, ticTacToe.getTable());
        assertEquals(finished, ticTacToe.isFinished());
    }

    @Test
    public void testNotToMarkAFullBoxOnAPlayedBoard() {
        ticTacToe.startGame();
        ticTacToe.checkBox(1, 2);
        ticTacToe.checkBox(1, 2);

        int availableShifts = 8;
        finished = false;
        char[][] tableAnswer = {{' ', ' ', ' '},
                {' ', ' ', 'X'},
                {' ', ' ', ' '}};

        assertEquals(availableShifts, ticTacToe.getAvailableShifts());
        assertArrayEquals(tableAnswer, ticTacToe.getTable());
        assertEquals(finished, ticTacToe.isFinished());
    }

    @Test
    public void testTiedGame() {
        ticTacToe.startGame();
        ticTacToe.checkBox(0, 0);
        ticTacToe.checkBox(0, 1);
        ticTacToe.checkBox(1, 1);
        ticTacToe.checkBox(2, 2);
        ticTacToe.checkBox(1, 2);
        ticTacToe.checkBox(1, 0);
        ticTacToe.checkBox(2, 0);
        ticTacToe.checkBox(0, 2);
        ticTacToe.checkBox(2, 1);
        ticTacToe.checkBox(0, 2);
        int availableShifts = 0;
        char winner = ' ';
        finished = true;
        char[][] tableAnswer = {{'X', 'O', 'O'},
                {'O', 'X', 'X'},
                {'X', 'X', 'O'}};
        assertEquals(availableShifts, ticTacToe.getAvailableShifts());
        assertArrayEquals(tableAnswer, ticTacToe.getTable());
        assertEquals(finished, ticTacToe.isFinished());
        assertEquals(winner, ticTacToe.getWinner());
    }

    @Test
    public void testWonGameVerticalLine() {
        ticTacToe.startGame();
        ticTacToe.checkBox(0, 0);
        ticTacToe.checkBox(0, 1);
        ticTacToe.checkBox(1, 0);
        ticTacToe.checkBox(1, 1);
        ticTacToe.checkBox(2, 0);

        finished = true;
        int availableShifts = 4;
        char[][] tableAnswer = {{'X', 'O', ' '},
                {'X', 'O', ' '},
                {'X', ' ', ' '}};

        assertEquals(availableShifts, ticTacToe.getAvailableShifts());
        assertArrayEquals(tableAnswer, ticTacToe.getTable());
        assertEquals(finished, ticTacToe.isFinished());
    }

    @Test
    public void testDoNotCheckBoxWonGameVerticalLine() {
        ticTacToe.startGame();
        ticTacToe.checkBox(0, 0);
        ticTacToe.checkBox(0, 1);
        ticTacToe.checkBox(1, 0);
        ticTacToe.checkBox(1, 1);
        ticTacToe.checkBox(2, 0);
        ticTacToe.checkBox(2, 1);

        finished = true;
        int availableShifts = 4;
        char[][] tableAnswer = {{'X', 'O', ' '},
                {'X', 'O', ' '},
                {'X', ' ', ' '}};

        assertEquals(availableShifts, ticTacToe.getAvailableShifts());
        assertArrayEquals(tableAnswer, ticTacToe.getTable());
        assertEquals(finished, ticTacToe.isFinished());
    }

    @Test
    public void testWonGameHorizontalLine() {
        ticTacToe.startGame();
        ticTacToe.checkBox(0, 0);
        ticTacToe.checkBox(1, 0);
        ticTacToe.checkBox(0, 1);
        ticTacToe.checkBox(1, 1);
        ticTacToe.checkBox(0, 2);

        finished = true;
        int availableShifts = 4;
        char[][] tableAnswer = {{'X', 'X', 'X'},
                {'O', 'O', ' '},
                {' ', ' ', ' '}};

        assertEquals(availableShifts, ticTacToe.getAvailableShifts());
        assertArrayEquals(tableAnswer, ticTacToe.getTable());
        assertEquals(finished, ticTacToe.isFinished());
    }

    @Test
    public void testDoNotCheckBoxWonGameHorizontalLine() {
        ticTacToe.startGame();
        ticTacToe.checkBox(0, 0);
        ticTacToe.checkBox(1, 0);
        ticTacToe.checkBox(0, 1);
        ticTacToe.checkBox(1, 1);
        ticTacToe.checkBox(0, 2);
        ticTacToe.checkBox(2, 1);

        finished = true;
        int availableShifts = 4;
        char[][] tableAnswer = {{'X', 'X', 'X'},
                {'O', 'O', ' '},
                {' ', ' ', ' '}};
        assertEquals(availableShifts, ticTacToe.getAvailableShifts());
        assertArrayEquals(tableAnswer, ticTacToe.getTable());
        assertEquals(finished, ticTacToe.isFinished());
    }

    @Test
    public void testWonGameUpperDiagonalLine() {
        ticTacToe.startGame();
        ticTacToe.checkBox(0, 0);
        ticTacToe.checkBox(1, 0);
        ticTacToe.checkBox(1, 1);
        ticTacToe.checkBox(0, 1);
        ticTacToe.checkBox(2, 2);

        finished = true;
        int availableShifts = 4;
        char[][] tableAnswer = {{'X', 'O', ' '},
                {'O', 'X', ' '},
                {' ', ' ', 'X'}};

        assertEquals(availableShifts, ticTacToe.getAvailableShifts());
        assertArrayEquals(tableAnswer, ticTacToe.getTable());
        assertEquals(finished, ticTacToe.isFinished());
    }

    @Test
    public void testDoNotCheckBoxWonGameUpperDiagonalLine() {
        ticTacToe.startGame();
        ticTacToe.checkBox(0, 0);
        ticTacToe.checkBox(1, 0);
        ticTacToe.checkBox(1, 1);
        ticTacToe.checkBox(0, 1);
        ticTacToe.checkBox(2, 2);
        ticTacToe.checkBox(2, 1);

        finished = true;
        int availableShifts = 4;
        char[][] tableAnswer = {{'X', 'O', ' '},
                {'O', 'X', ' '},
                {' ', ' ', 'X'}};

        assertEquals(availableShifts, ticTacToe.getAvailableShifts());
        assertArrayEquals(tableAnswer, ticTacToe.getTable());
        assertEquals(finished, ticTacToe.isFinished());
    }

    @Test
    public void testWonGameBottomDiagonalLine() {
        ticTacToe.startGame();
        ticTacToe.checkBox(2, 0);
        ticTacToe.checkBox(1, 0);
        ticTacToe.checkBox(1, 1);
        ticTacToe.checkBox(0, 1);
        ticTacToe.checkBox(0, 2);

        finished = true;
        int availableShifts = 4;
        char[][] tableAnswer = {{' ', 'O', 'X'},
                {'O', 'X', ' '},
                {'X', ' ', ' '}};

        assertEquals(availableShifts, ticTacToe.getAvailableShifts());
        assertArrayEquals(tableAnswer, ticTacToe.getTable());
        assertEquals(finished, ticTacToe.isFinished());
    }

    @Test
    public void testDoNotCheckBoxWonGameBottomDiagonalLine() {
        ticTacToe.startGame();
        ticTacToe.checkBox(2, 0);
        ticTacToe.checkBox(1, 0);
        ticTacToe.checkBox(1, 1);
        ticTacToe.checkBox(0, 1);
        ticTacToe.checkBox(0, 2);

        finished = true;
        int availableShifts = 4;
        char[][] tableAnswer = {{' ', 'O', 'X'},
                {'O', 'X', ' '},
                {'X', ' ', ' '}};

        assertEquals(availableShifts, ticTacToe.getAvailableShifts());
        assertArrayEquals(tableAnswer, ticTacToe.getTable());
        assertEquals(finished, ticTacToe.isFinished());
    }

    @Test
    public void testPlayerTwoWinnerWithHorizontalLine(){
        ticTacToe.startGame();
        ticTacToe.checkBox(2, 0);
        ticTacToe.checkBox(1, 0);
        ticTacToe.checkBox(0, 1);
        ticTacToe.checkBox(1, 2);
        ticTacToe.checkBox(0, 2);
        ticTacToe.checkBox(1, 1);
        char winner = 'O';
        finished = true;
        int availableShifts = 3;
        char[][] tableAnswer = {{' ', 'X', 'X'},
                {'O', 'O', 'O'},
                {'X', ' ', ' '}};
        assertEquals(availableShifts, ticTacToe.getAvailableShifts());
        assertArrayEquals(tableAnswer, ticTacToe.getTable());
        assertEquals(finished, ticTacToe.isFinished());
        assertEquals(winner, ticTacToe.getWinner());
    }
    @Test
    public void testPlayerOneWinnerWithHorizontalLine(){
        ticTacToe.startGame();
        ticTacToe.checkBox(2, 0);
        ticTacToe.checkBox(1, 0);
        ticTacToe.checkBox(2, 1);
        ticTacToe.checkBox(1, 2);
        ticTacToe.checkBox(2, 2);
        ticTacToe.checkBox(1, 1);
        char winner = 'X';
        finished = true;
        int availableShifts = 4;
        char[][] tableAnswer = {{' ', ' ', ' '},
                {'O', ' ', 'O'},
                {'X', 'X', 'X'}};
        assertEquals(availableShifts, ticTacToe.getAvailableShifts());
        assertArrayEquals(tableAnswer, ticTacToe.getTable());
        assertEquals(finished, ticTacToe.isFinished());
        assertEquals(winner, ticTacToe.getWinner());
    }
}
