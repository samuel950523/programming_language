package com.ssafy.ws;

import java.util.Arrays;

public class MovieMgr {
	private Movie[] movies = new Movie[100];
	private int index;

	private static MovieMgr instance = new MovieMgr();

	private MovieMgr() {
	}

	public static MovieMgr getInstance() {
		return instance;
	}

	/** 파라메터로 전달된 영화 정보를 전달받아 배열에 저장한다. */
	public void add(Movie m) {
		movies[index] = m;
		index++;
	}

	/** 배열에 저장된 모든 영화정보를 리턴한다. */
//	public Movie[] search() {
//		return movies;
//	}

	public Movie[] search() {
		Movie m[] = new Movie[index];
		for (int i = 0; i < index; i++) {
			m[i] = movies[i];
		}
		return m;
	}

	/** 파라메터로 전달된 타이틀을 포함하고 있는 모든 영화 정보를 검색하여 리턴한다 */
	public Movie[] search(String title) {
		Movie[] temp = new Movie[index]; // 리턴할 temp 어레이 생성
		int j = 0; // temp의 인덱스
		for (int i = 0; i < index; i++) {
			if (movies[i].getTitle().contains(title)) { // 타이틀 검색
				temp[j] = movies[i];
				j++;
			}
		}
//		return temp;
		return Arrays.copyOfRange(temp, 0, j);
	}

	/** 파라메터로 전달된 감독명의 모든 영화 정보를 검색하여 리턴한다 */
	public Movie[] searchDirector(String name) {
		Movie[] temp = new Movie[index]; // 리턴할 temp 어레이 생성
		int j = 0; // temp의 인덱스
		for (int i = 0; i < index; i++) {
			if (movies[i].getDirector().equals(name)) { // 타이틀 검색
				temp[j] = movies[i];
				j++;
			}
		}
		return temp;
	}

	/** 파라메터로 전달된 장르의 모든 영화 정보를 검색하여 리턴한다 */
	public Movie[] searchGenre(String genre) {
		Movie[] temp = new Movie[index]; // 리턴할 temp 어레이 생성
		int j = 0; // temp의 인덱스
		for (int i = 0; i < index; i++) {
			if (movies[i].getGenre().equals(genre)) { // 타이틀 검색
				temp[j] = movies[i];
				j++;
			}
		}
		return temp;
	}

	/** 파라메터로 전달된 제목의 영화를 삭제한다. */
	public void delete(String title) { // title이 유일할 때
		int idx = -1;
		for (int i = 0; i < index; i++) {
			if (movies[i].getTitle().equals(title)) {
				idx = i;
				break;
			}
		}
		if (idx == -1) {
			System.out.println("해당하는 영화가 없습니다.");
		} else {
			for (int i = idx; i < movies.length - 1; i++) {
				movies[i] = movies[i + 1];
			}
			movies[index - 1] = null;
			index--;
			System.out.println("성공적으로 삭제되었습니다.");
		}
	}

	public void delete2(String title) { // title 유일에 상관없음
		Movie m[] = new Movie[movies.length]; // movies.length로 설정해줘야한다.
		int cnt = 0;
		for (int i = 0; i < index; i++) {
			if (!movies[i].getTitle().equals(title)) {
				m[cnt] = movies[i]; // m에 title이 같이 않은 것만 넣어준다.
				cnt++;
			}
		}
		// movies 업데이트
		movies = m;
		index = cnt;
	}

	/** 저장된 영화 정보의 갯수를 리턴한다. */
	public int getSize() {
		return index;
	}
}
