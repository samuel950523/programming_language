package com.ssafy.dom;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ssafy.sax.Contact;

public class DOMVOCreateTest {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		Document document = parser.parse("contactlist.xml");
		Element root = document.getDocumentElement(); // root element

		ArrayList<Contact> list = new ArrayList<Contact>();

//		document.getElementsByTagName(tagname);
		NodeList contactList = root.getElementsByTagName("contact");
		for (int i = 0; i < contactList.getLength(); i++) {
			Contact c = new Contact();
			list.add(c);

			Element contact = (Element) contactList.item(i);
			NodeList childNodes = contact.getChildNodes();
			for (int j = 0; j < childNodes.getLength(); j++) { // 공백도 자식으로
				Node node = childNodes.item(j);
				if (node.getNodeType() == Node.ELEMENT_NODE) { // type으로 구분
//					node.getAttributes()
					if (node.getNodeName().equals("name")) {
//						c.setName(node.getFirstChild().getNodeValue()); // value
						c.setName(node.getTextContent()); // DOM lv3
					} else if (node.getNodeName().equals("phone")) {
						c.setPhone(node.getFirstChild().getNodeValue());
					} else if (node.getNodeName().equals("email")) {
						c.setEmail(node.getFirstChild().getNodeValue());
					}
				}
			}
		}
		
		for (Contact contact : list) {
			System.out.println(contact);
		}
	}
}
