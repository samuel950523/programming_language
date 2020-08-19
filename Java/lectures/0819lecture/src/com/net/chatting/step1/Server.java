package com.net.chatting.step1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try (ServerSocket ss = new ServerSocket(5000)) {
			System.out.println("server ready ...");
			Socket s = ss.accept();
			System.out.println(s.getInetAddress() + "이 접속하였습니다.");
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String msg = null;
			while (!(msg = in.readLine()).equalsIgnoreCase("Q")) {
				System.out.println("클라이언트가 보낸 메시지 : " + msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
