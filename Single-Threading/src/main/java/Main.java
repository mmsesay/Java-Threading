import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String...args) throws InterruptedException {

        BlockingQueue<Task> tasks = new LinkedBlockingQueue<>();

        tasks.add(() -> System.out.println("Task 1"));
        tasks.add(() -> System.out.println("Task 2"));
        tasks.add(() -> System.out.println("Task 3"));

        Worker wk = new Worker(tasks);

        wk.start();
        Thread.sleep(5000);
        wk.shutdown();
//        System.out.println(Thread.currentThread().getName());
    }
}
