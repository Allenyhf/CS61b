import org.junit.Test;
import static org.junit.Assert.*;


public class TestFilk {

    @Test
    public void testFlik() {
        Boolean expect = true;
        Boolean actual = Flik.isSameNumber(1, 1);
        assertEquals(expect, actual);

        expect = false;
        actual = Flik.isSameNumber(2, 1);
        assertEquals(expect, actual);

        expect = true;
        actual = Flik.isSameNumber(100, 100);
        assertEquals(expect, actual);
    }
}
