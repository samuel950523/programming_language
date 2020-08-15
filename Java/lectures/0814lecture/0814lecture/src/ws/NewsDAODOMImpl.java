package ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NewsDAODOMImpl implements INewsDAO {

	private static List<News> list = new ArrayList<News>();

	@Override
	public List<News> getNewsList(String url) throws Exception {
		list.clear();
		connectNews(url);
		return list;
	}

	@Override
	public News search(int index) {
		return list.get(index);
	}

	private static void connectNews(String url) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		Document document = parser.parse(url);
		Element root = document.getDocumentElement(); // root element

		NodeList newsList = root.getElementsByTagName("item");
		for (int i = 0; i < newsList.getLength(); i++) {
			News n = new News();
			list.add(n);

			Element news = (Element) newsList.item(i);
			NodeList childNodes = news.getChildNodes();
			for (int j = 0; j < childNodes.getLength(); j++) { // 공백도 자식으로
				Node node = childNodes.item(j);
				if (node.getNodeType() == Node.ELEMENT_NODE) { // type으로 구분
					if (node.getNodeName().equals("title")) {
						n.setTitle(node.getTextContent()); // DOM lv3
					} else if (node.getNodeName().equals("link")) {
						n.setLink(node.getFirstChild().getNodeValue());
					} else if (node.getNodeName().equals("description")) {
						n.setDesc(node.getFirstChild().getNodeValue());
					}
				}
			}
		}
	}

}
