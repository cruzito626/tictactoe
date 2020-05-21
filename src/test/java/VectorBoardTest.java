import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VectorBoardTest {
    private Board board;

    @Before
    public void init() {
        board = new MatrixBoard();
    }

    @Test
    public void markCell_emptyCell_true() {
        assertTrue(board.markCell(1, 2, 'X'));
    }

    @Test
    public void markCell_markedCell_false() {
        board.markCell(1, 2, 'X');
        board.markCell(1, 1, 'X');
        assertFalse(board.markCell(1, 2, 'X'));
    }

}