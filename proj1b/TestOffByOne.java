import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

     // Your tests go here.
    @Test
    public void testOffByOne() {
        boolean actual;
       // actual = offByOne.equalChars('a', 'b');
        //assertTrue(actual);


        actual = offByOne.equalChars('r', 'q');
        assertTrue(actual);

        actual = offByOne.equalChars('d', 'c');
        assertTrue(actual);

        actual = offByOne.equalChars('e', 'f');
        assertTrue(actual);

        actual = offByOne.equalChars('a', 'e');
        assertFalse(actual);

        actual = offByOne.equalChars('z', 'a');
        assertFalse(actual);

        actual = offByOne.equalChars('a', 'a');
        assertFalse(actual);

        actual = offByOne.equalChars('a', 'B');
        assertFalse(actual);

        actual = offByOne.equalChars('a', 'A');
        assertFalse(actual);

        actual = offByOne.equalChars('%', '&');
        assertTrue(actual);
    }



    //Uncomment this class once you've created
    // your CharacterComparator interface and OffByOne class.
}
