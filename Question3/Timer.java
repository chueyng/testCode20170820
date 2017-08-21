import java.util.concurrent.TimeUnit;

public class Timer 
{
    // Declare start variable
    long start;
    
    // Constructor
    private Timer() 
    {
       start = System.nanoTime();
    }
    
    // Start timer
    public static Timer startTimer() 
    {
        return new Timer();
    }
    
    // Time consume
    public long timeElapse()
    {
        long end = System.nanoTime();
        return end - start;
    }
    
    // Time consume by timer unit
    public long timeElapse(TimeUnit timeUnit)
    {
        // Convert time unit from nanoseconds to seconds
        return timeUnit.convert(timeElapse(), TimeUnit.NANOSECONDS);
    }
 }