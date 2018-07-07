package com.imooc.yi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import com.imooc.entity.Book;
import com.imooc.handler.SAXParserHandler;

public class SaxTest {

	public ArrayList<Book> ParseXML() {
		// TODO Auto-generated method stub
		// ����һ��SAXParserFactory����
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParserHandler sph=null;
		// ͨ��factory��ȡSAXParser����
		try {
			SAXParser parser = factory.newSAXParser();
		    //����SAXParserHandler����
			sph=new SAXParserHandler();
			parser.parse("books.xml", sph);
			System.out.println("һ����"+sph.getBookList().size()+"����");
			
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
		return sph.getBookList();
	}
	public void CreateXML() {
		ArrayList<Book> BookList=ParseXML();
	    //����xml
		//1.����һ��TransformerFactory��Ķ���
		SAXTransformerFactory tff= (SAXTransformerFactory)
				SAXTransformerFactory.newInstance();
		try {
		    //2.ͨ��SAXTransformerFactory���󴴽�һ��TransformerHandler����
			TransformerHandler handler=
					tff.newTransformerHandler();
			//3.ͨ��handler���󴴽�һ��Transformer����
		    Transformer tr=handler.getTransformer();
		    //4.ͨ��Transformer��������ɵ�xml�ļ���������
		    //����xml�ı���
		    tr.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		    //����xml��"�Ƿ���"
		    tr.setOutputProperty(OutputKeys.INDENT, "yes");
		    //5.����һ��Result����
		    File f=new File("src/res/newbooks.xml");
		    //����ļ������ڣ��򴴽��ļ�
		   if(!f.exists()) {
			   f.createNewFile();
		   }
		   //6.����Result���󣬲���ʹ����handler����
		   Result result=new StreamResult(new FileOutputStream(f));
		   handler.setResult(result);
		   //7.����handler�����дxml�ļ�������
		   //��document
		   handler.startDocument();
		   AttributesImpl attr=new AttributesImpl();
		   handler.startElement("", "", "bookstore",attr );
		   for(Book book:BookList) { 
			   //���book�ڵ㣬����book�ڵ��id����ֵ��ֵ
			   attr.clear();
			   attr.addAttribute( "","", "id", "", book.getId());
			   handler.startElement("","","book",attr);
			   //��book�ڵ����name�ӽڵ�
			   if(book.getName()!=null&&!book.getName()
					   .trim().equals("")) {
				    attr.clear();
				    handler.startElement("","","name",attr);
				    handler.characters(book.getName().toCharArray()
				    		, 0, book.getName().toCharArray().length);
				    handler.endElement("","","name");
			   }
			   //��book�ڵ����catgory�ӽڵ�
			   if(book.getCatgory()!=null&&!book.getCatgory()
					   .trim().equals("")) {
				    attr.clear();
				    handler.startElement("","","catgory",attr);
				    handler.characters(book.getCatgory().toCharArray()
				    		, 0, book.getCatgory().toCharArray().length);
				    handler.endElement("","","catgory");
			   }
			   //��book�ڵ����description�ӽڵ�
			   if(book.getDescription()!=null&&!book.getDescription()
					   .trim().equals("")) {
				    attr.clear();
				    handler.startElement("","","description",attr);
				    handler.characters(book.getDescription().toCharArray()
				    		, 0, book.getDescription().toCharArray().length);
				    handler.endElement("","","description");
			   }
			   //��book�ڵ����price�ӽڵ�
			   if(book.getPrice()!=null&&!book.getPrice()
					   .trim().equals("")) {
				   attr.clear();
				    handler.startElement("","","price",attr);
				    handler.characters(book.getPrice().toCharArray()
				    		, 0, book.getPrice().toCharArray().length);
				    handler.endElement("","","price");
			   }
			   handler.endElement("", "","book");
		   }
		   handler.endElement("", "", "bookstore");
		   //�ر�document
		   handler.endDocument();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
SaxTest test=new SaxTest();
//test.ParseXML();
test.CreateXML();
	}

}
