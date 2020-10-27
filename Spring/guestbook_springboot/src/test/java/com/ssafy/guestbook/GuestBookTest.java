//package com.ssafy.guestbook;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.ssafy.guestbook.model.GuestBookDto;
//import com.ssafy.guestbook.model.service.GuestBookService;
//
//public class GuestBookTest extends Configure {
//
//	@Autowired
//	private GuestBookService guestBookService;
//	
//	@Test
//	public void writeArticle() throws Exception {
//		GuestBookDto guestBookDto = new GuestBookDto();
//		guestBookDto.setUserid("admin");
//		guestBookDto.setSubject("관리자가 글써요11111111");
//		guestBookDto.setContent("Spring Test를 이용한 관리자 글쓰기111111");
//		guestBookService.writeArticle(guestBookDto);
//	}
//	
//	@Test
//	public void getArticle() throws Exception {
//		GuestBookDto guestBookDto = guestBookService.getArticle(5);
//		System.out.println("제목 : " + guestBookDto.getSubject());
//	}
//}
