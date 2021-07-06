import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.


    @Test
    public void testisPalindrome() {
        boolean actual;
        actual = palindrome.isPalindrome("");
        assertTrue(actual);

        actual = palindrome.isPalindrome("A");
        assertTrue(actual);

        actual = palindrome.isPalindrome("b");
        assertTrue(actual);

        actual = palindrome.isPalindrome("b ");
        assertFalse(actual);

        actual = palindrome.isPalindrome(" A");
        assertFalse(actual);

        actual = palindrome.isPalindrome("racecar");
        assertTrue(actual);

        actual = palindrome.isPalindrome("r acecar");
        assertFalse(actual);

        actual = palindrome.isPalindrome("apple");
        assertFalse(actual);

        actual = palindrome.isPalindrome("racecaR");
        assertFalse(actual);

        actual = palindrome.isPalindrome("rAcecar");
        assertFalse(actual);

        actual = palindrome.isPalindrome("rAcEcAr");
        assertTrue(actual);
    }

    @Test
    public void testPalindrome() {
        CharacterComparator charCom = new OffByOne();

        boolean actual;
        actual = palindrome.isPalindrome("", charCom);
        assertTrue(actual);

        actual = palindrome.isPalindrome("a", charCom);
        assertTrue(actual);

        actual = palindrome.isPalindrome("a ", charCom);
        assertFalse(actual);

        actual = palindrome.isPalindrome("abb", charCom);
        assertTrue(actual);

        actual = palindrome.isPalindrome("bba", charCom);
        assertTrue(actual);

        actual = palindrome.isPalindrome("abc", charCom);
        assertFalse(actual);

        actual = palindrome.isPalindrome("fbh", charCom);
        assertFalse(actual);

        actual = palindrome.isPalindrome("zva", charCom);
        assertFalse(actual);

        actual = palindrome.isPalindrome("bb a", charCom);
        assertFalse(actual);

        actual = palindrome.isPalindrome("b ba", charCom);
        assertFalse(actual);

        actual = palindrome.isPalindrome("a b", charCom);
        assertTrue(actual);
    }

//    public static void main(String args[]){
//        boolean actual;
//        CharacterComparator charCom = new OffByOne();
//        actual = palindrome.isPalindrome("a ", charCom);
//
//    }

}
