import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.LongConsumer;

/**
 * Timer class that measures time in nanoseconds asynchronously
 * 
 * @param timeOutCallback - a callback function to update the time display
 */

public class Timer {
    /**
     * startTime - the time the timer was started
     */
    private long startTime = 0;
    /**
     * timeSoFar - the time that has passed since the timer was started
     */
    private long timeSoFar = 0;
    /**
     * updateTimeDisplay - a callback function to update the time display
     */
    private LongConsumer updateTimeDisplay;
    /**
     * exec - a ScheduledExecutorService to run the measureTime Runnable
     */
    private ScheduledExecutorService exec= Executors.newScheduledThreadPool(1);
    /**
     * isRunning - a boolean to check if the timer is running
     */
    private boolean isRunning = false;

    /**
     * Constructor for the Timer class
     * 
     * @param timeOutCallback - a callback function to update the time display
     */    
    Timer(LongConsumer timeOutCallback){
        updateTimeDisplay = timeOutCallback;
        exec.scheduleAtFixedRate(measureTime, 0, 1, TimeUnit.SECONDS);
    }
    /**
     * measureTime - a Runnable that measures the time that has passed since the timer was started
     */
    Runnable measureTime = () -> {
        timeSoFar = System.nanoTime() - startTime;
        if (isRunning){
            updateTimeDisplay.accept(timeSoFar);
        }

    };
    /**
     * startTimer - starts the timer
     */
    public void startTimer(){
        startTime = System.nanoTime();
        isRunning = true;
    }
    /**
     * stopTimer - stops the timer
     * 
     * @return timeSoFarTemp - the time that has passed since the timer was started
     */
    public long stopTimer(){
        long timeSoFarTemp = timeSoFar;
        timeSoFar = 0;
        startTime = 0;
        isRunning = false;
        return timeSoFarTemp;
    }
    
}
