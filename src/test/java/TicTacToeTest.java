import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;


public class TicTacToeTest {

    private TicTacToe ticTacToe;
    private  boolean finished;
    @Before
    public void init() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void markCell_emptyCell_true() {
        boolean marked;
        marked = ticTacToe.markCell(1, 2);
        assertTrue(marked);
    }

    @Test
    public void markCell_markedCell_false() {
        boolean marked;
        ticTacToe.markCell(1, 2);
        marked = ticTacToe.markCell(1, 2);
        assertFalse(marked);
    }

    @Test
    public void markCell_winningGame_false() {
        boolean marked;

        ticTacToe.markCell(0, 0);
        ticTacToe.markCell(0, 1);
        ticTacToe.markCell(1, 0);
        ticTacToe.markCell(1, 1);
        ticTacToe.markCell(2, 0);
        marked = ticTacToe.markCell(2, 1);
        assertFalse(marked);
    }

    @Test
    public void isFinished_gameStarted_false() {
        assertFalse(ticTacToe.isFinished());
    }

    @Test
    public void isFinished_tiedGame_true() {
        ticTacToe.markCell(0, 0);
        ticTacToe.markCell(0, 1);
        ticTacToe.markCell(1, 1);
        ticTacToe.markCell(2, 2);
        ticTacToe.markCell(1, 2);
        ticTacToe.markCell(1, 0);
        ticTacToe.markCell(2, 0);
        ticTacToe.markCell(0, 2);
        ticTacToe.markCell(2, 1);
        assertTrue(ticTacToe.isFinished());
    }

    @Test
    public void isFinished_wonGameVerticalLine_true() {
        /*X|O|
          X|O|
          X| |
        * */
        ticTacToe.markCell(0, 0);
        ticTacToe.markCell(0, 1);
        ticTacToe.markCell(1, 0);
        ticTacToe.markCell(1, 1);
        ticTacToe.markCell(2, 0);

        assertTrue(ticTacToe.isFinished());
    }

    @Test
    public void isFinished_wonGameHorizontalLine_true() {
        /*X|X|X
          O|O|
           | |
        * */
        ticTacToe.markCell(0, 0);
        ticTacToe.markCell(1, 0);
        ticTacToe.markCell(0, 1);
        ticTacToe.markCell(1, 1);
        ticTacToe.markCell(0, 2);

        assertTrue(ticTacToe.isFinished());
    }

    @Test
    public void isFinished_wonGameUpperDiagonalLine_true() {
        /*X|O|
          O|X|
           | |X
        * */
        ticTacToe.markCell(0, 0);
        ticTacToe.markCell(1, 0);
        ticTacToe.markCell(1, 1);
        ticTacToe.markCell(0, 1);
        ticTacToe.markCell(2, 2);

        assertTrue(ticTacToe.isFinished());
    }

    @Test
    public void isFinished_wonGameBottomDiagonalLine_true() {

        /* |O|X
          O|X|
          X| |
        * */

        ticTacToe.markCell(2, 0);
        ticTacToe.markCell(1, 0);
        ticTacToe.markCell(1, 1);
        ticTacToe.markCell(0, 1);
        ticTacToe.markCell(0, 2);

        assertTrue(ticTacToe.isFinished());
    }

}
