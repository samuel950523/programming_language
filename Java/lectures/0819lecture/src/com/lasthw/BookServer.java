package com.lasthw;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class BookServer {
	public static void main(String[] args) {
		try (ServerSocket ss = new ServerSocket(5000)) {

			while (true) {
				System.out.println("server ready.....");
				Socket s = ss.accept();
				ObjectInputStream in = new ObjectInputStream(s.getInputStream());
				List<Book> list = (List<Book>) in.readObject();

				System.out.println("========== 수신한 도서 목록 =========");
				list.stream().forEach(book -> System.out.println(book));

//				for (Book book2 : list) {
//					System.out.println(book2);
//				}
				s.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
