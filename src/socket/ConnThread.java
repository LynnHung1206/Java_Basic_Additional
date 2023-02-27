package socket;
import java.io.*;
import java.net.*;

class ConnThread extends Thread {
	private Socket socket = null;
	int threadID;

	public ConnThread(Socket socket, int count) { // 建構子socket為客戶端
		this.socket = socket;
		threadID = count;
	}

	public void run() {
		System.out.println("第" + threadID + "位使用者連線");
		try {
//			socket為雙向,可以輸入和輸出
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());

			while (true) {
				String msg = in.readLine(); // 由socket讀入的字串msg
//				"quit".equals(msg)  較穩固的寫法,不會有NullPointerException的可能性
				if (msg.equals("quit"))
					break;
				System.out.println("第" + threadID + "位使用者訊息:" + msg);
				String remsg = new String("\t" + "Server接收到訊息:" + msg);
				out.println(remsg);
				out.flush();
			}
			out.close();
			in.close();
			socket.close();
			System.out.println("第" + threadID + "位使用者離線");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
