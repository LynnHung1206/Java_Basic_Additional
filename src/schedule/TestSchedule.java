package schedule;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class TestSchedule {
	
	public static void main(String[] args) {
		TestSchedule ts = new TestSchedule();
//		ts.testDelayTask();
//		ts.testDelayAndPeriod();
//		ts.testDateAndPeriod();
	}
	
	private void testDelayTask() {
		Timer timer = new Timer();
		
		System.out.println("Delay 5 seconds.");
		System.out.println("Start Time: " + new Date());
		
		timer.schedule(new MyTask(), 5000);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException ie) {
			
		}
		timer.cancel();
		System.out.println("End Time: " + new Date());
	}
	
	private void testDelayAndPeriod() {
		Timer timer = new Timer();
		
		System.out.println("Delay 5 seconds. Period 2 seconds.");
		System.out.println("Start Time: " + new Date());
		
		timer.schedule(new MyTask(), 5000, 2000);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException ie) {
			
		}
		timer.cancel();
		System.out.println("End Time: " + new Date());
		
	}
	
	
	
	private void testDateAndPeriod() {
		Timer timer = new Timer();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 15);
		Date firstTime = calendar.getTime();
		
		System.out.println("Start Time: " + new Date());
		System.out.println("設定執行Date為15秒後：" + firstTime + ", Period：10 seconds.");
		
		timer.schedule(new MyTask(), firstTime, 10000);
		
		try {
			Thread.sleep(30000);
		} catch (InterruptedException ie) {
			
		}
		timer.cancel();
		System.out.println("End Time: " + new Date());
		
	}
	
	
	
}
