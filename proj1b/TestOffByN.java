import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    OffByN obn = new OffByN(5);

    @Test
    public void testOffByN(){
        char x_1 = 'a';
        char y_1 = 'f';

        assertTrue(obn.equalChars(x_1,y_1));
    }
}
