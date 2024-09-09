package classPractice;

public class HelloNumbers {
    public static void main(String[] args) {
        int i = 0;
        int culmulative = 0;
        while(i < 10){
            culmulative += i;
            System.out.println(culmulative);
            i++;
        }
    }
}
