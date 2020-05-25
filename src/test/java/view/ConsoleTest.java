package view;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ConsoleTest {

    @Test
    public void validateNumber_numberGreaterThanRange_false() {
        Console console = new Console();
        boolean validated = console.validateNumber(80, 1,3);
        assertFalse(validated);
    }
    @Test
    public void validateNumber_numberLessThanRange_false() {
        Console console = new Console();
        boolean validated = console.validateNumber(-1, 1,3);
        assertFalse(validated);
    }

    @Test
    public void validateNumber_numberWithinLimit_true() {
        Console console = new Console();
        boolean validated = console.validateNumber(1, 1,1);
        assertTrue(validated);
    }

    @Test
    public void validateNumber_numberInTheUpperLimit_true() {
        Console console = new Console();
        boolean validated = console.validateNumber(1, 0,1);
        assertTrue(validated);
    }

    @Test
    public void validateNumber_numberAtTheBottom_true() {
        Console console = new Console();
        boolean validated = console.validateNumber(3, 3,10);
        assertTrue(validated);
    }
}