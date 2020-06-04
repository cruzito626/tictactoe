package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeTest {

    private ITicTacToe ticTacToe;

    @Before
    public void init() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void markMoveEmptyCellTrueTest() {
        assertTrue(ticTacToe.markMove(1, 2));
    }

    @Test
    public void markMoveMarkedCellFalseTest() {
        ticTacToe.markMove(1, 2);
        assertFalse(ticTacToe.markMove(1, 2));
    }

    @Test
    public void markMoveInvalidPositionFalseTest() {
        assertFalse(ticTacToe.markMove(7, -1));
    }

    /* X|O|
       X|O|
       X| |
    */
    @Test
    public void checkTicTacToeWonGameVerticalLineTrueTest() {
        ticTacToe.markMove(0, 0);
        ticTacToe.markMove(0, 1);
        ticTacToe.markMove(1, 0);
        ticTacToe.markMove(1, 1);
        ticTacToe.markMove(2, 0);

        assertTrue(ticTacToe.checkTicTacToe());
    }

    /* X|X|X
       O|O|
        | |
    */
    @Test
    public void checkTicTacToeWonGameHorizontalLineTrueTest() {
        ticTacToe.markMove(0, 0);
        ticTacToe.markMove(1, 0);
        ticTacToe.markMove(0, 1);
        ticTacToe.markMove(1, 1);
        ticTacToe.markMove(0, 2);

        assertTrue(ticTacToe.checkTicTacToe());
    }

    /* X|O|
       O|X|
        | |X
    */
    @Test
    public void checkTicTacToeWonGameFirstDiagonalLineTrueTest() {
        ticTacToe.markMove(0, 0);
        ticTacToe.markMove(1, 0);
        ticTacToe.markMove(1, 1);
        ticTacToe.markMove(0, 1);
        ticTacToe.markMove(2, 2);

        assertTrue(ticTacToe.checkTicTacToe());
    }

    /*  |O|X
        O|X|
        X| |
    */
    @Test
    public void checkTicTacToeWonGameSecondDiagonalLineTrue() {
        ticTacToe.markMove(2, 0);
        ticTacToe.markMove(1, 0);
        ticTacToe.markMove(1, 1);
        ticTacToe.markMove(0, 1);
        ticTacToe.markMove(0, 2);

        assertTrue(ticTacToe.checkTicTacToe());
    }

    @Test
    public void checkTicTacToeGameIsDrawFalseTest() {
        ticTacToe.markMove(0, 0);
        ticTacToe.markMove(0, 1);
        ticTacToe.markMove(1, 1);
        ticTacToe.markMove(2, 2);
        ticTacToe.markMove(1, 2);
        ticTacToe.markMove(1, 0);
        ticTacToe.markMove(2, 0);
        ticTacToe.markMove(0, 2);
        ticTacToe.markMove(2, 1);
        assertFalse(ticTacToe.checkTicTacToe());
    }

    /* X|O|
       X|O|
       X| |
    */
    @Test
    public void winnerWonGameVerticalLineXTest() {
        char winner = 'X';
        ticTacToe.markMove(0, 0);
        ticTacToe.markMove(0, 1);
        ticTacToe.markMove(1, 0);
        ticTacToe.markMove(1, 1);
        ticTacToe.markMove(2, 0);

        assertEquals(winner, ticTacToe.winner());
    }

    /* O|O|O
       X|X|
        | |X
     */
    @Test
    public void winnerWonGameHorizontalLineOTest() {

        char winner = 'O';
        ticTacToe.markMove(1, 0);
        ticTacToe.markMove(0, 0);
        ticTacToe.markMove(1, 1);
        ticTacToe.markMove(0, 1);
        ticTacToe.markMove(2, 2);
        ticTacToe.markMove(0, 2);

        assertEquals(winner, ticTacToe.winner());
    }

    @Test
    public void drawGameStartedFalseTest() {
        assertFalse(ticTacToe.draw());
    }

    @Test
    public void drawTiedGameTrueTest() {
        ticTacToe.markMove(0, 0);
        ticTacToe.markMove(0, 1);
        ticTacToe.markMove(1, 1);
        ticTacToe.markMove(2, 2);
        ticTacToe.markMove(1, 2);
        ticTacToe.markMove(1, 0);
        ticTacToe.markMove(2, 0);
        ticTacToe.markMove(0, 2);
        ticTacToe.markMove(2, 1);
        assertTrue(ticTacToe.draw());
    }

    @Test
    public void getBoardStartGameEmptyMatrixTest() {
        char[][] board = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
        assertArrayEquals(board, ticTacToe.getBoard());
    }
}
