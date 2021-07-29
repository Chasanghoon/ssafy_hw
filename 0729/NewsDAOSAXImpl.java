package com.ssafy.hwjava10;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import com.sun.org.apache.xerces.internal.parsers.SAXParser;
import com.sun.org.apache.xml.internal.resolver.readers.SAXParserHandler;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;

public class NewsDAOSAXImpl {
	private List<News> list = new ArrayList<News>(20);

	public List<News> getNewsList(String url) {
		list.removeAll(list);
		connectXML(url);
		return list;
	}

	private void connectXML(String url) {
		SAXParserFactory fac = SAXParserFactory.newInstance();
		try {
			SAXParser parser = fac.newSAXParser();
			SaxHandler handler = new SaxHandler();
			parser.parse(new URL(url).openConnection().getInputStream(), handler);
		} catch (Exception e) {
			throw new RuntimeException("뉴스 정보를 전송 받는 중 오류 발생!!!");
		}
	}

	public class SaxHandler extends DefaultHandler {
		String temp;
		News n;

		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			if (qName.equals("data")) {
				n = new News();
				list.add(n);
			}
		}

		public void characters(char[] ch, int start, int length) throws SAXException {
			temp = new String(ch, start, length);
		}

		public void endElement(String uri, String localName, String qName) throws SAXException {
			if (qName.equals("title")) {
				n.setTitle(temp);
			} else if (qName.equals("desc")) {
				n.setDesc(temp);
			} else if (qName.equals("link")) {
				n.setLink(temp);
			}
		}
	}
}
