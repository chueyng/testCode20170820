import java.util.concurrent.TimeUnit;

public class TimeMgmtTool
{
     public static void main(String []args) throws InterruptedException
     {
        Timer timer = Timer.startTimer();
        
        // To mimic a method, pause in 10 seconds 
        Thread.sleep(10 * 1000);
        System.out.println("Elapsed Time in seconds: " + timer.timeElapse(TimeUnit.SECONDS));
     }
}
