import model.Markable;
import model.MatrixBoard;
import model.VectorBoard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    private Markable markable;

    @Before
    public void init() {
        markable = new VectorBoard();
        //markable = new MatrixBoard();
    }

    @Test
    public void markCell_emptyCell_true() {
        assertTrue(markable.markCell(1, 2, 'X'));
    }

    @Test
    public void markCell_markedCell_false() {
        markable.markCell(1, 2, 'X');
        markable.markCell(1, 1, 'X');
        assertFalse(markable.markCell(1, 2, 'X'));
    }

}