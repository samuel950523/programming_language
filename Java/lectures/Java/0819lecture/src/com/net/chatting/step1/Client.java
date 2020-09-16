package com.net.chatting.step1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// 키보드로 입력받은 내용을 서버로 전송
public class Client {

	public static void main(String[] args) {
		try (Socket s = new Socket("localhost", 5000); PrintWriter out = new PrintWriter(s.getOutputStream());) {

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String msg = null;
			while (true) {
				msg = in.readLine();
				out.println(msg);
				out.flush();
				if (msg.equalsIgnoreCase("Q")) break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
