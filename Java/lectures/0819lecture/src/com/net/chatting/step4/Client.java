package com.net.chatting.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.net.chatting.step4.Server.ServerThread;

// 키보드로 입력받은 내용을 서버로 전송
public class Client {

	public static void main(String[] args) {
		try (Socket s = new Socket("localhost", 5000); PrintWriter out = new PrintWriter(s.getOutputStream());) {

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//			BufferedReader sin = new BufferedReader(new InputStreamReader(s.getInputStream())); // 소켓의 inputstream
			
			String msg = null;
			while (true) {
				msg = in.readLine();
				out.println(msg); // 서버로 메시지 송신
				out.flush();
				if (msg.equalsIgnoreCase("Q")) break;
//				System.out.println("서버에서 오는 메시지 수신" + sin.readLine()); // 서버에서 오는 메시지 수신
				
				// 일해라 쓰레드
				new ClientThread(s).start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	static class ClientThread extends Thread {

		Socket socket;
		PrintWriter out;
		BufferedReader sin;
		
		public ClientThread(Socket s) {
			this.socket = s;
		}

		

		@Override
		public void run() { // 서버에서 보낸 msg를 받아옴
			try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
				String msg = null;
				
				// 목록에서 지우기
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 목록에서 지우기
				if (socket != null)
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}

		}

	}
}
