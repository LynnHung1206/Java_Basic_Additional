package socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSend {
	public static void main(String args[]) throws Exception {

		int port = 8087;

		System.out.print("請輸入欲連線的IP：");

		BufferedReader key_in = new BufferedReader(new InputStreamReader(System.in));
		// 從鍵盤讀取"目的IP"
		String addr = key_in.readLine(); 
		// 建立目的主機之InetAddress物件
		InetAddress address = InetAddress.getByName(addr); 

		while (true) {
			System.out.print("Send>");
			// 從鍵盤讀取"信息字串"
			String message = key_in.readLine(); 
			// "信息字串"轉為位元組陣列
			byte msg[] = message.getBytes(); 

			// 用 ["信息字串"之位元組陣列msg + msg.length + 目的主機之InetAddress物件address + port] 初始化 DatagramPacket(資料元封包)
			DatagramPacket packet = new DatagramPacket(msg, msg.length, address, port);
			// 建立DatagramSocket(資料元插座)沒有引數
			DatagramSocket dsocket = new DatagramSocket(); 
			 // 經由DatagramSocket(資料元插座)送出DatagramPacket(資料元封包)
			dsocket.send(packet);
			// 關閉DatagramSocket(資料元插座)
			dsocket.close(); 
		}
	}
}
