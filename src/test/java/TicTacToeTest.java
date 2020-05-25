import model.Markable;
import model.MatrixBoard;
import model.TicTacToe;
import model.VectorBoard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class TicTacToeTest {

    private TicTacToe ticTacToe;
    private Markable vectorMarkable;
    private Markable matrixMarkable;

    @Before
    public void init() {
        vectorMarkable = new VectorBoard();
        matrixMarkable = new MatrixBoard();
        ticTacToe = new TicTacToe(matrixMarkable);
    }

    @Test
    public void markCell_emptyCell_true() {
        assertTrue(ticTacToe.markCell(1, 2));
    }

    @Test
    public void markCell_markedCell_false() {
        ticTacToe.markCell(1, 2);
        ticTacToe.markCell(1, 1);
        assertFalse(ticTacToe.markCell(1, 2));
    }

    @Test
    public void markCell_twoMarkedCells_false(){
        ticTacToe.markCell(1, 2);
        ticTacToe.markCell(0,2);
        assertFalse(ticTacToe.markCell(1, 2));
    }

    @Test
    public void markCell_winningGame_false() {
        /*
        X|O|
        X|O|
        X| |
         */
        ticTacToe.markCell(0, 0);
        ticTacToe.markCell(0, 1);
        ticTacToe.markCell(1, 0);
        ticTacToe.markCell(1, 1);
        ticTacToe.markCell(2, 0);

        assertFalse(ticTacToe.markCell(2, 1));
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

    @Test
    public void playerTurn_firstTurn_X() {
        assertEquals('X', ticTacToe.playerTurn());
    }

    @Test
    public void playerTurn_secondTurn_O() {
        ticTacToe.markCell(1, 2);
        assertEquals('O', ticTacToe.playerTurn());
    }

    @Test
    public void playerTurn_fifthTurn_X() {
        ticTacToe.markCell(0, 0);
        ticTacToe.markCell(0, 1);
        ticTacToe.markCell(1, 0);
        ticTacToe.markCell(1, 1);
        assertEquals('X', ticTacToe.playerTurn());
    }

    @Test
    public void getWinner_wonGameVerticalLine_X() {
        /*X|O|
          X|O|
          X| |
        * */
        ticTacToe.markCell(0, 0);
        ticTacToe.markCell(0, 1);
        ticTacToe.markCell(1, 0);
        ticTacToe.markCell(1, 1);
        ticTacToe.markCell(2, 0);

        assertEquals('X', ticTacToe.getWinner());
    }
    @Test
    public void getLoser_wonGameVerticalLine_O() {
        /*X|O|
          X|O|
          X| |
        * */
        ticTacToe.markCell(0, 0);
        ticTacToe.markCell(0, 1);
        ticTacToe.markCell(1, 0);
        ticTacToe.markCell(1, 1);
        ticTacToe.markCell(2, 0);

        assertEquals('O', ticTacToe.getLoser());
    }

    @Test
    public void getWinner_wonGameHorizontalLine_O() {
        /*O|O|O
          X|X|
           | |X
        * */
        ticTacToe.markCell(1, 0);
        ticTacToe.markCell(0, 0);
        ticTacToe.markCell(1, 1);
        ticTacToe.markCell(0, 1);
        ticTacToe.markCell(2, 2);
        ticTacToe.markCell(0, 2);

        assertEquals('O', ticTacToe.getWinner());
    }

    @Test
    public void getLoser_wonGameHorizontalLine_X() {
        /*O|O|O
          X|X|
           | |X
        * */
        ticTacToe.markCell(1, 0);
        ticTacToe.markCell(0, 0);
        ticTacToe.markCell(1, 1);
        ticTacToe.markCell(0, 1);
        ticTacToe.markCell(2, 2);
        ticTacToe.markCell(0, 2);

        assertEquals('X', ticTacToe.getLoser());
    }
}
