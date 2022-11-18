package chat;

import java.util.Random;

public class Chat {
    boolean flag = false;
    private static Random rand = new Random();

    private static void delay(){
        try{
            Thread.sleep( (long)(Math.abs(rand.nextInt() %2) +1) *1000);
        }catch (InterruptedException e){
        }
    }
    public synchronized void question(String msg) {
        if (flag) {
            try {
                //causes the current thread to wait until another thread invokes notify()
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(msg);
        flag = true;
        //wakes up a single thread that is waiting on this object's monitor
        //alternatively use notifyAll()
        delay();
        notify();
    }

    public synchronized void answer(String msg) {
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(msg);
        flag = false;
        notify();
    }
}







