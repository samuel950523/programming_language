package ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsDAOSAXImpl implements INewsDAO {
	private static List<News> list = new ArrayList<News>();

	@Override
	public List<News> getNewsList(String url) throws Exception { // 속보 타이틀 목록 출력
		list.clear();
		connectNews(url);
		return list;
	}

	@Override
	public News search(int index) { // 타이틀 선택 시 그 속보 타이틀에 맞는 기사를 출력
		return null;
	}

	private static void connectNews(String url) throws Exception {

		SAXParserFactory factory = SAXParserFactory.newInstance(); // 싱글톤
		SAXParser parser = factory.newSAXParser(); // 팩토리에서 찍어줌
		SAXHandler handler = new SAXHandler(); // for문 돌리기 위해서 new로 생성
		parser.parse(url, handler);
	}

	static class SAXHandler extends DefaultHandler {
		News news;
		String content;

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			if (qName.equals("item")) {
				news = new News();
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if (news == null)
				return;
			if (qName.equals("item")) {
				list.add(news);
			} else if (qName.equals("title")) {
				news.setTitle(content);
			} else if (qName.equals("link")) {
				news.setLink(content);
			} else if (qName.equals("description")) {
				news.setDesc(content);
			}
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			content = String.valueOf(ch, start, length);
		}

	}
}
