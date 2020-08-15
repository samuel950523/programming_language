package com.ssafy.sax;

import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXVOCreateTest { // Value Object. 내가 표현하고 싶은 데이터 타입을 모아놓는.
	public static void main(String[] args) throws Exception {

		SAXParserFactory factory = SAXParserFactory.newInstance(); // 싱글톤
		SAXParser parser = factory.newSAXParser(); // 팩토리에서 찍어줌
		SAXHandler handler = new SAXHandler(); // for문 돌리기 위해서 new로 생성
		parser.parse("contactlist.xml", handler);
		
		for (Contact c : handler.getList()) {
			System.out.println(c.toString());
		}
	}

	static class SAXHandler extends DefaultHandler { // 원하는 메소드만 재정의 할 수 있게 함

		private ArrayList<Contact> list;
		private Contact contact;
		private String content;

		public ArrayList<Contact> getList() {
			return list;
		}

		@Override
		public void startDocument() throws SAXException {
			list = new ArrayList<Contact>();
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			if (qName.equals("contact")) {
				contact = new Contact();
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if (qName.equals("contact")) {
				list.add(contact);
			} else if (qName.equals("name")) {
				contact.setName(content);
			} else if (qName.equals("phone")) {
				contact.setPhone(content);
			} else if (qName.equals("email")) {
				contact.setEmail(content);
			}
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			content = String.valueOf(ch, start, length);
		}

	}
}
