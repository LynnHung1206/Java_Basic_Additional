package schedule;

import java.util.Date;
import java.util.TimerTask;

public class MyAnotherTask extends TimerTask {
	int count = 0;
	@Override
	public void run() {
		System.out.println("This is Task" + count);
		System.out.println("工作排定的時間 = " + new Date(scheduledExecutionTime()));
		System.out.println("工作執行的時間 = " + new Date() + "\n");
		count++;
	}

}
