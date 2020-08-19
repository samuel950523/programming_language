package com.net.chatting.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// 키보드로 입력받은 내용을 서버로 전송
public class Client {

	static boolean running = true;

	public static void main(String[] args) {

		try (Socket s = new Socket("127.0.0.1", 5000);
				PrintWriter out = new PrintWriter(s.getOutputStream());
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));) {

			String msg = null;
			while (true) {
				new ClientThread(s).start();
				
				msg = in.readLine();
				out.println(msg); // 서버로 메시지 송신
				out.flush();
				if (msg.equalsIgnoreCase("Q")) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static class ClientThread extends Thread {
		Socket socket;
		BufferedReader in;

		public ClientThread(Socket s) {
			this.socket = s;
			try {
				this.in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {

			while (in != null) {
				try {
					System.out.println(socket.getInetAddress() + "의 메시지 " + in.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
}