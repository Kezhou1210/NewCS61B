import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    // Your tests go here.
    Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/

    OffByOne obo = new OffByOne();
    @Test
    public void testOffByOne(){
        char x_1 = 'a';
        char y_1 = 'b';
        assertTrue(obo.equalChars(x_1, y_1));

        char x_2 = '%';
        char y_2 = '&'; 
        assertTrue(obo.equalChars(x_2, y_2));

        char x_3 = 'b';
        char y_3 = 'a';
        assertTrue(obo.equalChars(x_3, y_3));
    }
}
