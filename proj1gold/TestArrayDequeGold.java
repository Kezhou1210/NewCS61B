import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testArrayDequeAddFirst(){
        StudentArrayDeque<Integer> sda = new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<Integer>();
        String log = "";

        for(int i = 0; i < 10; i++){
            double randomNumber = StdRandom.uniform();

            if(randomNumber < 0.5){
                sda.addFirst(i);
                ads.addFirst(i);
                log += "addFirst(" + i + ")\n";
            }else{
                sda.addLast(i);
                ads.addLast(i);
                log += "addLast(" + i + ")\n";
            }
        }

        for(int i = 0; i<5; i++){
            Integer x = sda.removeFirst();
            Integer y = ads.removeFirst();
            log += "removeFirst()\n";
            assertEquals(log, x, y);
        }

        for(int i = 0; i <5; i++){
            Integer m = sda.removeLast();
            Integer n = ads.removeLast();
            log += "removeLast()\n";
            assertEquals(log,m, n);
        }
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests("all", TestArrayDequeGold.class);
    }
}
