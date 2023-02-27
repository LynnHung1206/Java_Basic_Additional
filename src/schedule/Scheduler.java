package schedule;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class Scheduler {
	public static void main(String[] args) {

		Timer timer = new Timer();

		Calendar cal = new GregorianCalendar(2017, Calendar.FEBRUARY, 1, 0, 0, 0);
		timer.scheduleAtFixedRate(new MyAnotherTask(), cal.getTime(), 1 * 60 * 1000);
		
//		timer.schedule(new MyAnotherTask(), cal.getTime(), 1 * 60 * 1000);
	}
}
