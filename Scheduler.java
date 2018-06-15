import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
* The Scheduler program helps to trigger any java program at a particular interval of time.
*
* @author  Nirenj George
* @version 1.0
*/
public class Scheduler 
{
	public static void main(String[] args) 
	{
		final String script = args[0];				//script to trigger
		int init = Integer.parseInt(args[1]);		//
		int duration = Integer.parseInt(args[2]);	//duration
		
		String prsName = ManagementFactory.getRuntimeMXBean().getName();
		
		String prsId = prsName.substring(0, prsName.indexOf("@"));
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() 
		{
			@Override
			public void run() 
			{
				try 
				{
					Runtime runtime = Runtime.getRuntime();
					runtime.exec(script);
					
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}, init, duration, TimeUnit.MINUTES);
		
		System.out.printf("Scheduler is running in minutes initial: %d durataion: %d%n", init, duration);
		System.out.printf("to check <process id> running #ps -ef | grep Scheduler OR #ps -e | grep %s%n", prsId);
		System.out.printf("to stop the process #kill -9 <process id>");
	}
}
