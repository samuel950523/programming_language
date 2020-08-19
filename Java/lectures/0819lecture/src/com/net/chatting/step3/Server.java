package com.net.chatting.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

	public static void main(String[] args) {
		try (ServerSocket ss = new ServerSocket(5000)) {
			while (true) {
				System.out.println("server ready ...");
				Socket s = ss.accept();
				System.out.println(s.getInetAddress() + "이 접속하였습니다.");
				
				new ServerThread(s).start();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static class ServerThread extends Thread {

		Socket socket;

		public ServerThread(Socket s) {
			this.socket = s;
		}

		@Override
		public void run() {
			try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					PrintWriter out = new PrintWriter(socket.getOutputStream());) {
				String msg = null;
				while (!(msg = in.readLine()).equalsIgnoreCase("Q")) {
					System.out.println("클라이언트가 보낸 메시지 : " + msg);
					out.println("[" + socket.getInetAddress() + "]" + msg);
					out.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
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
