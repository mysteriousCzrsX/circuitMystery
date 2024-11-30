import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.LongConsumer;

public class Timer {
    private long startTime = 0;
    private long timeSoFar = 0;
    private LongConsumer updateTimeDisplay;
    private ScheduledExecutorService exec= Executors.newScheduledThreadPool(1);
    private boolean isRunning = false;
    
    Timer(LongConsumer timeOutCallback){
        updateTimeDisplay = timeOutCallback;
        exec.scheduleAtFixedRate(measureTime, 0, 1, TimeUnit.SECONDS);
    }

    Runnable measureTime = () -> {
        timeSoFar = System.nanoTime() - startTime;
        if (isRunning){
            updateTimeDisplay.accept(timeSoFar);
        }

    };

    public void startTimer(){
        startTime = System.nanoTime();
        isRunning = true;
    }

    public long stopTimer(){
        long timeSoFarTemp = timeSoFar;
        timeSoFar = 0;
        startTime = 0;
        isRunning = false;
        return timeSoFarTemp;
    }
    
}
