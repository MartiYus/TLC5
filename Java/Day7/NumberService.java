import java.util.Random;

public class NumberService {
    private static Random rand = new java.util.Random();

    private static void delay(){
        try{
            Thread.sleep( (long)(Math.abs(rand.nextInt() %2) +1) *1000);
        }catch (InterruptedException e){
        }
    }

    public static void getNumberAndPrint(){
        int theNum = rand.nextInt() % 100;
        delay();
        System.out.println("Thread: " + Thread.currentThread().getId() + " returning: " + theNum);
    }
}
