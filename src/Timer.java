import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Timer {
    private long startTime;
    private long timeSoFar;
    private ScheduledExecutorService exec= Executors.newScheduledThreadPool(1);
    Timer() {
         //get some container to update
    }

    Runnable measureTime = () -> {
        timeSoFar = System.nanoTime() - startTime;
        //update some container
    };

    public void startTimer(){
        startTime = System.nanoTime();
        exec.scheduleAtFixedRate(measureTime, 0, 1, TimeUnit.SECONDS);
    }

    public long stopTimer(){
        exec.shutdown();
        return timeSoFar;
    }
    
}
