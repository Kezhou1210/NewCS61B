import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    OffByOne obo = new OffByOne();
    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }  

    @Test
    public void testIsPalindrome(){
        String word_1 = "hello";
        assertFalse(palindrome.isPalindrome(word_1));

        String word_2 = "racecar";
        assertTrue(palindrome.isPalindrome(word_2));

        String word_3 = "a";
        assertTrue(palindrome.isPalindrome(word_3));
        
        String word_4 = "";
        assertTrue(palindrome.isPalindrome(word_4));

        String word_5 = "arqb";
        assertTrue(palindrome.isPalindrome(word_5, obo));

        String word_6 = "a";
        assertTrue(palindrome.isPalindrome(word_6, obo));

        String word_7 = "crazy";
        assertFalse(palindrome.isPalindrome(word_7, obo));
    }
}
