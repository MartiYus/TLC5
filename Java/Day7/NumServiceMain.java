import java.lang.reflect.Executable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NumServiceMain {
    public static void main(String[] args) {
        Runnable task = () -> {NumberService.getNumberAndPrint();};

        System.out.println("Main Thread id: " + Thread.currentThread().getId());

        //thread per task
//        Executor threadPerTask = t->new Thread(t).start();
//        threadPerTask.execute(task);
//        threadPerTask.execute(task);
//        threadPerTask.execute(task);

        // in-thread
//        Executor inThread = t->t.run();
//        inThread.execute(task);
//        inThread.execute(task);
//        inThread.execute(task);

        //fixed size thread pool
       ExecutorService es = Executors.newFixedThreadPool(2);
//        es.execute(task);
//        es.execute(task);
//        es.execute(task);
    }
}
