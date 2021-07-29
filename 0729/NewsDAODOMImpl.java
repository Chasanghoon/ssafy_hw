package com.ssafy.hwjava10;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.ssafy.ws10.step2.Weather;
import com.sun.org.apache.xerces.internal.parsers.SAXParser;
import com.sun.org.apache.xml.internal.resolver.readers.SAXParserHandler;
import com.sun.xml.internal.txw2.Document;

import jdk.internal.org.xml.sax.helpers.DefaultHandler;

public class NewsDAODOMImpl {
	List<News> list = new ArrayList<News>(20);

	public List<News> getNewsList(String url) {
		list.removeAll(list);
		connectXML(url);
		return list;
	}

	private void connectXML(String url) {
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder parser = f.newDocumentBuilder();
			Document dom = parser.parse(new URL(url).openConnection().getInputStream());
			Element root = dom.getDocumentElement();
			NodeList n = root.getElementsByTagName("data");

			for (int i = 0; i < n.getLength(); i++) {
				News w = new News();
				Node item = w.item(i);
				NodeList kids = item.getChildNodes();
				for (int j = 0; j < kids.getLength(); j++) {
					Node kid = kids.item(j);
					String name = kid.getNodeName();
					if (name.equalsIgnoreCase("title")) {
						w.setTitle(kid.getFirstChild().getNodeValue());
					} else if (name.equalsIgnoreCase("desc")) {
						w.setDesc(kid.getFirstChild().getNodeValue());
					} else if (name.equalsIgnoreCase("setlink")) {
						w.setLink(kid.getFirstChild().getNodeValue());
					}
				}
				System.out.println(w);
				list.add(w);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
