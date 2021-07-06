public class Palindrome {


    public Deque<Character> wordToDeque(String word) {

        Deque<Character> chaDeq = new ArrayDeque<>();
        int i = 0;
        while (i < word.length()) {
            char ch = word.charAt(i);
            chaDeq.addLast(ch);
            i++;
        }

        return chaDeq;
    }

    /**
     *  helper method used for check if the character in  Deque is Palindrome
     * @param chaDeq
     *
     */
    private boolean do_isPalindrome_recursive(Deque<Character> chaDeq) {
        if (chaDeq.size() <= 1) {
            return true;
        }
        if (chaDeq.removeFirst() != chaDeq.removeLast()) {
            return false;
        } else {
            return do_isPalindrome_recursive(chaDeq);
        }
    }

    /**
     *  Check if word is a Palindrome
     *  return true, if it is.  Like " ", "a", "aBa"
     *  return false, if it isn't.  Like "aBA", "accc"
     */
    public boolean isPalindrome(String word) {
        Deque<Character> chaDeq = wordToDeque(word);
           // return do_isPalindrome_recursive(chaDeq);

        boolean result = true;
        while (chaDeq.size() > 1) {
            char first = chaDeq.removeFirst();
            char last = chaDeq.removeLast();
            if (first != last) {
                result = false;
            }
        }
        return result;
    }

    private boolean do_isPalindrome_recursive (Deque<Character> charDeq, CharacterComparator cc) {
        if (charDeq.size() <= 1) {
            return true;
        } else if ( !cc.equalChars(charDeq.removeFirst(), charDeq.removeLast())) {
            return false;
        } else {
            return do_isPalindrome_recursive(charDeq, cc);
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> chaDeq = wordToDeque(word);
        return do_isPalindrome_recursive(chaDeq, cc);
    }

}
