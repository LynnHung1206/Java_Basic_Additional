package socket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceive {
	public static void main(String args[]) throws Exception {
		int port = 8087;
		// 建立一個DatagramSocket(資料元插座)物件,並指定連接埠
		DatagramSocket dsocket = new DatagramSocket(port);
		// 準備一個1024個位元組的buf緩衝器
		byte buf[] = new byte[1024]; 

		System.out.println("UDPReceive Listening Port (" + port + ")......");
		// 無限迴圈
		while (true) { 
			// 建立一個擁有buf緩衝器的DatagramPacket(資料封包)物件
			DatagramPacket packet = new DatagramPacket(buf, buf.length); 
			// DatagramSocket(資料元插座)等待接收抵達在指定連接埠上的資料元
			// 接收到資料元後,會將該資料元送至DatagramPacket(資料元封包)所指定的buf緩衝器
			dsocket.receive(packet);
									
			// 轉為字串 , 印出
			String msg = new String(buf, 0, packet.getLength());
			System.out.println("Receive>" + msg);
		}
	}
}
