public class ThreadApplication {
    public static void main(String args[]) {
        ThreadDemo T1 = new ThreadDemo( "Thread-1");
        T1.start();

        ThreadDemo T2 = new ThreadDemo( "Thread-2");
        T2.start();

        //alternative way to create threads
//        Runnable t3  = () -> {
//            System.out.println("Running Thread -3" );
//            try {
//                for(int i = 4; i > 0; i--) {
//                    System.out.println("Thread: Thread -3" + ", " + i);
//                    // Let the thread sleep for a while.
//                    Thread.sleep(50);
//                }
//            } catch (InterruptedException e) {
//                System.out.println("Thread Thread -3 interrupted.");
//            }
//            System.out.println("Thread Thread -3 exiting.");
//        };
//
//        Thread T3 = new Thread(t3);
//        T3.start();
    }
}
