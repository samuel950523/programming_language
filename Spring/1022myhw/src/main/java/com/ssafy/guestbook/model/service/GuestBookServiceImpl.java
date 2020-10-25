package com.ssafy.guestbook.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.guestbook.model.GuestBookDto;
import com.ssafy.guestbook.model.dao.GuestBookDao;
import com.ssafy.util.PageNavigation;

@Service
public class GuestBookServiceImpl implements GuestBookService {

	@Autowired
	private GuestBookDao guestBookDao;

	@Override
	public void writeArticle(GuestBookDto guestBookDto) throws Exception {
		if (guestBookDto.getSubject() == null || guestBookDto.getContent() == null) {
			throw new Exception();
		}
		guestBookDao.writeArticle(guestBookDto);
	}

	@Override
	public List<GuestBookDto> listArticle(Map<String, String> map) throws Exception {
		map.put("key", map.get("key") == null ? "" : map.get("key"));
		map.put("word", map.get("word") == null ? "" : map.get("word"));
		return guestBookDao.listArticle(map);
	}

	////////////////////////////////////////////////////////
	// 1) , 2) 여기에 들어갈 적절한 코드를 작성하세요
	//////////////////////////////////////////////////
	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		int naviSize = 10;
		int currentPage = Integer.parseInt(map.get("pg"));
		int sizePerPage = Integer.parseInt(map.get("spp"));
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		int totalCount = guestBookDao.getTotalCount(map);
		pageNavigation.setTotalCount(totalCount);

		int totalPageCount = (totalCount - 1) / sizePerPage + 1; /// ========================1) 여기 !!!!!!!!!!!!!!!
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage; /// ========================== 2) 여기 !!!!!!!!!!!!!
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}

	@Override
	public GuestBookDto getArticle(int articleno) throws Exception {
		return guestBookDao.getArticle(articleno);
	}

	@Override
	public void modifyArticle(GuestBookDto guestBookDto) throws Exception {
		guestBookDao.modifyArticle(guestBookDto);
	}

	@Override
	public void deleteArticle(int articleno) throws Exception {
		guestBookDao.deleteArticle(articleno);
	}

}
