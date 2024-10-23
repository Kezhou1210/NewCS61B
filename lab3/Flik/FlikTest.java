import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FlikTest{
    @Test
    public void isSameNumberTest(){
        Integer a = 128;
        Integer b = 128;
        assertTrue(Flik.isSameNumber(a, b));
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests("all", FlikTest.class);
    }
}