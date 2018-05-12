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
		// ����һ��SAXParserFactory����
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// ͨ��factory��ȡSAXParser����
		try {
			SAXParser parser = factory.newSAXParser();
			//����SAXParserHandler����
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
