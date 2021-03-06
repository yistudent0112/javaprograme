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
 * 用来解析xml元素
 */
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		//如果节点的名字为book
		if(qName.equals("book")) {
			//已知book节点中有几个属性，并知道属性名的名字的情况下，用下面的方法
/*			String id=attributes.getValue("id");
			System.out.println("book的属性值是 : "+id);*/
			//不知道book节点有几个属性，且也不知道属性名字的情况下
			BookIndex++;
			book=new Book();
			System.out.println("对第"+BookIndex+"书的遍历已开始");
			int number=attributes.getLength();
			for(int i=0;i<number;i++) {
				System.out.print("这是book的第"+(i+1)+"个属性，属性名 : "+attributes.getQName(i));
				System.out.println("--- 属性值 : "+attributes.getValue(i));
				if(attributes.getQName(i).equals("id")) {
					book.setId(attributes.getValue(i));
				}
			}
		}else if(!qName.equals("booklist")) {
			System.out.println("这是"+qName+"属性");
		}
	}
@Override
/*
 * 用来遍历xml文件的结束标签
 */
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		//判断是否针对一本书的遍历已经结束
		if(qName.equals("book")) {
			System.out.println("对第"+BookIndex+"书的遍历已结束");
			//将已经完成遍历的书本信息，添加到书本数组中去
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
 * 用来标识解析开始
 */
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("Sax解析开始");
	}
@Override
/*
 * 用来标识解析结束
 */
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("Sax解析结束");
	}
   @Override
public void characters(char[] ch, int start, int length) throws SAXException {
	// TODO Auto-generated method stub
	super.characters(ch, start, length);
    value=new String(ch,start,length);
	if(!value.trim().equals("")) {
	System.out.println("属性值 : "+value);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
