package com.ssafy.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXTest {
	public static void main(String[] args) throws Exception {
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		parser.parse("contactlist.xml",new SAXHandler());
	}

	static class SAXHandler extends DefaultHandler { // 원하는 메소드만 재정의 할 수 있게 함
		@Override
		public void startDocument() throws SAXException {
			System.out.println("startDocument...");
		}

		@Override
		public void endDocument() throws SAXException {
			System.out.println("endDocument...");
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			System.out.println("startElement : " + localName + ", " + qName);
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			System.out.println("endElement : " + localName + ", " + qName);
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			System.out.println("characters : " + String.valueOf(ch, start, length));
		}

	}
}
