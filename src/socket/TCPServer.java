package socket;
/*
    編譯: javac TcpServer.java
    執行: java  TcpServer
    說明: 聆聽  8888 port
          多重client的server
*/

import java.io.IOException;
import java.net.ServerSocket;

public class TCPServer {
	public static void main(String args[]) throws IOException {
		ServerSocket sc = null;
//		作為流水編號使用
		int count = 0;

		System.out.println("TcpServerM listening port 8888.......");
		try {
			sc = new ServerSocket(8888); // 在8888埠建立ServerSocket, 並等待客戶端的連結
		} catch (IOException ioe) {
			System.err.println("Could not listen on port: 1024.");
			return;
		}

		try {
//			利用無線迴圈來維持運作,用serversocket呼叫accept,當執行到此方法程式會進行等待wait(),
//			有人連進來程式才會繼續執行
			while (true) {
				new ConnThread(sc.accept(), ++count).start(); // 連線
			}
		} catch (IOException ioe) {
			System.err.println("Exception" + ioe);
		}
		sc.close();
	}
}
