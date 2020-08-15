package com.ssafy.ws;

import java.util.Scanner;

public class MovieTest {
	public static void main(String[] args) {

		MovieMgr mg = MovieMgr.getInstance(); // Singleton Design

		Scanner sc = new Scanner(System.in);

//		MovieMgr mg = new MovieMgr();
		// 
		// 구현
		while (true) {
			System.out.println("<<< 영화 관리 프로그램 >>>");
			System.out.println("1. 영화 정보 입력");
			System.out.println("2. 영화 정보 전체 검색");
			System.out.println("3. 영화명 검색");
			System.out.println("4. 영화 장르별 검색");
			System.out.println("5. 영화 정보 삭제");
			System.out.println("0. 종료");
			System.out.print("원하는 번호를 선택하세요 : ");

			// 번호 선택
			int num = Integer.parseInt(sc.nextLine());
			if (num == 0) { // 0이면 종료
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			switch (num) {
			case 1: // 영화 정보 입력
				Movie m = new Movie();
				System.out.println("[영화 정보 입력]");
				System.out.print("영화 제목을 입력하세요 : ");
				m.setTitle(sc.nextLine());
				System.out.print("감독 이름을 입력하세요 : ");
				m.setDirector(sc.nextLine());
				System.out.print("평점을 입력하세요 : ");
				m.setGrade(Integer.parseInt(sc.nextLine()));
				System.out.print("장르를 입력하세요 : ");
				m.setGenre(sc.nextLine());
				System.out.print("요약을 입력하세요 : ");
				m.setSummary(sc.nextLine());
				mg.add(m);
				System.out.println("영화 정보 입력이 완료되었습니다.\n");
				break;

			case 2: // 영화 정보 전체 검색
				Movie[] movies = mg.search();
				System.out.println("-----영화 전체 목록-----");
				for (int i = 0; i < mg.getSize(); i++) {
					System.out.println(movies[i]);
				}
				break;

			case 3: // 영화명 검색
				System.out.println("검색하고자 하는 영화 이름을 입력하세요 : ");
				String title = sc.nextLine();
				Movie[] moviesTitle = mg.search(title);
				if (moviesTitle.length == 0) {
					System.out.println("검색하고자 하는 영화가 없습니다.");
					break;
				}
				System.out.println("검색하고자 하는 영화의 정보입니다.");
//				for (Movie movie : moviesTitle) {
//					if (movie != null) {
//						System.out.println(movie);
//					}
//				}
				for (Movie movie : moviesTitle) {
					System.out.println(movie);
				}
				break;

			case 4: // 영화 장르별 검색
				System.out.println("검색하고자 하는 장르를 입력하세요 : ");
				String genre = sc.nextLine();
				Movie[] moviesGenre = mg.searchGenre(genre);
				if (moviesGenre.length == 0) {
					System.out.println("검색하고자 하는 영화가 없습니다.");
					break;
				}
				System.out.println("검색하고자 하는 영화의 정보입니다.");
				for (Movie movie : moviesGenre) {
					if (movie != null) {
						System.out.println(movie);
					}
				}
				break;

			case 5: // 영화 정보 삭제
				System.out.println("삭제하고자 하는 영화의 제목을 입력하세요");
				String titleDel = sc.nextLine();
				mg.delete(titleDel);
				break;

			default:
				System.out.println("잘못된 번호입니다. 다시 입력하세요");
				break;
			}
		}
		sc.close();
	}
}
