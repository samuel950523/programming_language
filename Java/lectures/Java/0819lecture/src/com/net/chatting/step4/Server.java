package com.net.chatting.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread {

	private static ArrayList<ServerThread> clients;

	public static void main(String[] args) {
		try (ServerSocket ss = new ServerSocket(5000)) {

			clients = new ArrayList<ServerThread>();
			while (true) {
				System.out.println("server ready ...");
				Socket s = ss.accept();
				System.out.println(s.getInetAddress() + "이 접속하였습니다.");

//				ServerThread st = new ServerThread(s);
//				clients.add(st);
//				st.start();

				new ServerThread(s).start();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void broadcast(String msg) {
		// 모든 클라이언트에게 메시지를 송신
		for (ServerThread serverThread : clients) {
			serverThread.sendMessage(msg);
		}
	}

	static class ServerThread extends Thread {

		Socket socket;
		PrintWriter out;

		public ServerThread(Socket s) {
			clients.add(this);
			this.socket = s;
			try {
				out = new PrintWriter(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void sendMessage(String msg) {
			// 자신의 클라이언트로 메시지를 송신
			out.println(msg);
			out.flush();
		}

		@Override
		public void run() {
			try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
				String msg = null;
				while (!(msg = in.readLine()).equalsIgnoreCase("Q")) {
					System.out.println("클라이언트가 보낸 메시지 : " + msg);
					// 모든 클라이언트에게 메시지를 송신
					broadcast(msg);
				}
				// 목록에서 지우기
				clients.remove(this);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 목록에서 지우기
				clients.remove(this);
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
