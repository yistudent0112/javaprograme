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
		// 创建一个SAXParserFactory对象
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParserHandler sph=null;
		// 通过factory获取SAXParser对象
		try {
			SAXParser parser = factory.newSAXParser();
		    //创建SAXParserHandler对象
			sph=new SAXParserHandler();
			parser.parse("books.xml", sph);
			System.out.println("一共有"+sph.getBookList().size()+"本书");
			
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
	    //生成xml
		//1.创建一个TransformerFactory类的对象
		SAXTransformerFactory tff= (SAXTransformerFactory)
				SAXTransformerFactory.newInstance();
		try {
		    //2.通过SAXTransformerFactory对象创建一个TransformerHandler对象
			TransformerHandler handler=
					tff.newTransformerHandler();
			//3.通过handler对象创建一个Transformer对象
		    Transformer tr=handler.getTransformer();
		    //4.通过Transformer对象对生成的xml文件进行设置
		    //设置xml的编码
		    tr.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		    //设置xml的"是否换行"
		    tr.setOutputProperty(OutputKeys.INDENT, "yes");
		    //5.创建一个Result对象
		    File f=new File("src/res/newbooks.xml");
		    //如果文件不存在，则创建文件
		   if(!f.exists()) {
			   f.createNewFile();
		   }
		   //6.创建Result对象，并且使其与handler关联
		   Result result=new StreamResult(new FileOutputStream(f));
		   handler.setResult(result);
		   //7.利用handler对象编写xml文件的内容
		   //打开document
		   handler.startDocument();
		   AttributesImpl attr=new AttributesImpl();
		   handler.startElement("", "", "bookstore",attr );
		   for(Book book:BookList) { 
			   //添加book节点，并给book节点的id属性值赋值
			   attr.clear();
			   attr.addAttribute( "","", "id", "", book.getId());
			   handler.startElement("","","book",attr);
			   //给book节点添加name子节点
			   if(book.getName()!=null&&!book.getName()
					   .trim().equals("")) {
				    attr.clear();
				    handler.startElement("","","name",attr);
				    handler.characters(book.getName().toCharArray()
				    		, 0, book.getName().toCharArray().length);
				    handler.endElement("","","name");
			   }
			   //给book节点添加catgory子节点
			   if(book.getCatgory()!=null&&!book.getCatgory()
					   .trim().equals("")) {
				    attr.clear();
				    handler.startElement("","","catgory",attr);
				    handler.characters(book.getCatgory().toCharArray()
				    		, 0, book.getCatgory().toCharArray().length);
				    handler.endElement("","","catgory");
			   }
			   //给book节点添加description子节点
			   if(book.getDescription()!=null&&!book.getDescription()
					   .trim().equals("")) {
				    attr.clear();
				    handler.startElement("","","description",attr);
				    handler.characters(book.getDescription().toCharArray()
				    		, 0, book.getDescription().toCharArray().length);
				    handler.endElement("","","description");
			   }
			   //给book节点添加price子节点
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
		   //关闭document
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
