package com.imooc.yi;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.imooc.handler.SAXParserHandler;

public class SaxTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 创建一个SAXParserFactory对象
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 通过factory获取SAXParser对象
		try {
			SAXParser parser = factory.newSAXParser();
			//创建SAXParserHandler对象
			SAXParserHandler sph=new SAXParserHandler();
			parser.parse("books.xml", sph);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
