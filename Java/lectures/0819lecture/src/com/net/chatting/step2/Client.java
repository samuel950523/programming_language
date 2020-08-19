package com.net.chatting.step2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// 키보드로 입력받은 내용을 서버로 전송
public class Client {

	public static void main(String[] args) {
		try (Socket s = new Socket("localhost", 5000); PrintWriter out = new PrintWriter(s.getOutputStream());) {

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader sin = new BufferedReader(new InputStreamReader(s.getInputStream())); // 소켓의 inputstream
			
			String msg = null;
			while (true) {
				msg = in.readLine();
				out.println(msg); // 서버로 메시지 송신
				out.flush();
				if (msg.equalsIgnoreCase("Q")) break;
				System.out.println(sin.readLine()); // 서버에서 오는 메시지 수신
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
