import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Worker extends Thread{

    private final BlockingQueue<Task> tasks;

    private volatile boolean running = true;

    public Worker(BlockingQueue<Task> tasks) {
        this.tasks = tasks;
    }

    // will handle shutting down the worker
    public void shutdown() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {

            try {
                Task tsk = tasks.poll(500, TimeUnit.MILLISECONDS);

                if(tsk != null) {
                    tsk.run();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Shutting down...");
    }
}
