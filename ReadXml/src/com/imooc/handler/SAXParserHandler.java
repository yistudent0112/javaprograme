package com.imooc.handler;

import javax.xml.stream.events.StartElement;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserHandler extends DefaultHandler {
	private int BookIndex=0;
@Override
/*
 * ��������xmlԪ��
 */
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		//����ڵ������Ϊbook
		if(qName.equals("book")) {
			//��֪book�ڵ����м������ԣ���֪�������������ֵ�����£�������ķ���
/*			String id=attributes.getValue("id");
			System.out.println("book������ֵ�� : "+id);*/
			//��֪��book�ڵ��м������ԣ���Ҳ��֪���������ֵ������
			BookIndex++;
			System.out.println("�Ե�"+BookIndex+"��ı����ѿ�ʼ");
			int number=attributes.getLength();
			for(int i=0;i<number;i++) {
				System.out.print("����book�ĵ�"+(i+1)+"�����ԣ������� : "+attributes.getQName(i));
				System.out.println("--- ����ֵ : "+attributes.getValue(i));
			}
		}else if(!qName.equals("booklist")) {
			System.out.println("����"+qName+"����");
		}
	}
@Override
/*
 * ��������xml�ļ��Ľ�����ǩ
 */
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		//�ж��Ƿ����һ����ı����Ѿ�����
		if(qName.equals("book")) {
			System.out.println("�Ե�"+BookIndex+"��ı����ѽ���");
		}
	}
@Override
/*
 * ������ʶ������ʼ
 */
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("Sax������ʼ");
	}
@Override
/*
 * ������ʶ��������
 */
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("Sax��������");
	}
   @Override
public void characters(char[] ch, int start, int length) throws SAXException {
	// TODO Auto-generated method stub
	super.characters(ch, start, length);
	String value=new String(ch,start,length);
	if(!value.trim().equals("")) {
	System.out.println("����ֵ : "+value);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
