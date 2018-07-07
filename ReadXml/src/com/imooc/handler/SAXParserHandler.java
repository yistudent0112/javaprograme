package com.imooc.handler;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.imooc.entity.Book;

public class SAXParserHandler extends DefaultHandler {
	private ArrayList<Book>BookList=new ArrayList<Book>();
	public Book book=null;
	public String value=null;
	private int BookIndex=0;
	public ArrayList<Book> getBookList(){
		return BookList;
	}
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
			book=new Book();
			System.out.println("�Ե�"+BookIndex+"��ı����ѿ�ʼ");
			int number=attributes.getLength();
			for(int i=0;i<number;i++) {
				System.out.print("����book�ĵ�"+(i+1)+"�����ԣ������� : "+attributes.getQName(i));
				System.out.println("--- ����ֵ : "+attributes.getValue(i));
				if(attributes.getQName(i).equals("id")) {
					book.setId(attributes.getValue(i));
				}
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
			//���Ѿ���ɱ������鱾��Ϣ����ӵ��鱾������ȥ
			BookList.add(book);
			book=null;
		}
		else if(qName.equals("catgory")) {
			book.setCatgory(value);
		}
		else if(qName.equals("description")) {
			book.setDescription(value);
		}
		else if(qName.equals("name")) {
			book.setName(value);
		}
		else if(qName.equals("price")) {
			book.setPrice(value);
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
    value=new String(ch,start,length);
	if(!value.trim().equals("")) {
	System.out.println("����ֵ : "+value);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
