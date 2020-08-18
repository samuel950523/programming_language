package com.ssafy.hw;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class BookServer {
	public static void main(String[] args) {
		int port = 5555;
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			System.out.println("Server Started");

			while (true) {
				Socket socket = serverSocket.accept();
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				System.out.println("데이터파일에서 데이터를 불러옵니다.");
				List<Book> list = (List<Book>) in.readObject();
				System.out.println(list);
			}
		} catch (Exception e) {
			System.out.println("Server exception : " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Server Ended");
	}
}
