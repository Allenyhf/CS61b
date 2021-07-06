import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    @Test
    public void testOffbyN(){
        OffByN offBy5 = new OffByN(5);
        boolean actual = offBy5.equalChars('a', 'f');
        assertTrue(actual);

        actual = offBy5.equalChars('f', 'a');
        assertTrue(actual);

        actual = offBy5.equalChars('f', 'h');
        assertFalse(actual);

        OffByN offBy0 = new OffByN(0);
        actual = offBy0.equalChars('a', 'a');
        assertTrue(actual);

        actual = offBy0.equalChars('a', 'b');
        assertTrue(actual);
    }

}
