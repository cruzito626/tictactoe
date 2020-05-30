package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class TicTacToeTest {

    private ITicTacToe ticTacToe;

    @Before
    public void init() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void markMove_emptyCell_true() {
        assertTrue(ticTacToe.markMove(1, 2));
    }

    @Test
    public void markMove_markedCell_false() {
        ticTacToe.markMove(1, 2);
        assertFalse(ticTacToe.markMove(1, 2));
    }

    @Test
    public void markMove_tiedGame_false() {
        ticTacToe.markMove(0, 0);
        ticTacToe.markMove(0, 1);
        ticTacToe.markMove(1, 1);
        ticTacToe.markMove(2, 2);
        ticTacToe.markMove(1, 2);
        ticTacToe.markMove(1, 0);
        ticTacToe.markMove(2, 0);
        ticTacToe.markMove(0, 2);
        ticTacToe.markMove(2, 1);
        assertFalse(ticTacToe.markMove(1, 2));
    }

    /* X|O|
       X|O|
       X| |
    */
    @Test
    public void markMove_winningGame_false() {
        ticTacToe.markMove(0, 0);
        ticTacToe.markMove(0, 1);
        ticTacToe.markMove(1, 0);
        ticTacToe.markMove(1, 1);
        ticTacToe.markMove(2, 0);
        assertFalse(ticTacToe.markMove(2, 1));
    }

    @Test
    public void draw_gameStarted_false() {
        assertFalse(ticTacToe.draw());
    }

    @Test
    public void draw_tiedGame_true() {
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

    /* X|O|
       X|O|
       X| |
    */
    @Test
    public void checkTicTacToe_wonGameVerticalLine_true() {
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
    public void checkTicTacToe_wonGameHorizontalLine_true() {
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
    public void checkTicTacToe_wonGameFirstDiagonalLine_true() {
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
    public void checkTicTacToe_wonGameSecondDiagonalLine_true() {
        ticTacToe.markMove(2, 0);
        ticTacToe.markMove(1, 0);
        ticTacToe.markMove(1, 1);
        ticTacToe.markMove(0, 1);
        ticTacToe.markMove(0, 2);

        assertTrue(ticTacToe.checkTicTacToe());
    }

    /* X|O|
       X|O|
       X| |
    */
    @Test
    public void winner_wonGameVerticalLine_X() {
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
    public void winner_wonGameHorizontalLine_O() {

        char winner = 'O';
        ticTacToe.markMove(1, 0);
        ticTacToe.markMove(0, 0);
        ticTacToe.markMove(1, 1);
        ticTacToe.markMove(0, 1);
        ticTacToe.markMove(2, 2);
        ticTacToe.markMove(0, 2);

        assertEquals(winner, ticTacToe.winner());
    }
}
