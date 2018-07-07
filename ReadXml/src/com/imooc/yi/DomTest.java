package com.imooc.yi;

import java.io.IOException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.imooc.entity.Book;

public class DomTest {
	public DocumentBuilder GetDocumentBuilder() {
		// 创建一个DocumentBuilderFactory对象
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    DocumentBuilder db = null;
			// 创建一个DocumentBuilder对象
			try {
			 db = dbf.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return db;
	}
	/**
	 * 
	 * @Title: XmlParse 
	 * @Description: TODO(Xml文件解析函数) 
	 * @param 参数 
	 * @return void
	 * 返回类型 @throws
	 */
	public void XmlParse() {
		// 通过DocumentBuilder这个函数获得一个DocumentBuilder对象
		DocumentBuilder db = GetDocumentBuilder();
		try {
			// 通过DocumentBuilder对象的Parse方法加载books.xml到当前目录下
			Document document = db.parse("books.xml");
			// 获取所有book节点的集合
			NodeList books = document.getElementsByTagName("book");
			// 遍历每一个book节点
			for (int i = 0; i < books.getLength(); i++) {
				// 通过item(index)方法获得一个book节点，books的索引值从0开始
				Node book = books.item(i);
				System.out.println("第" + (i + 1) + "个book");
				NamedNodeMap attrs = book.getAttributes();
				for (int j = 0; j < attrs.getLength(); j++) {
					System.out.println("第" + (i + 1) + "个book节点的名字" + attrs.item(j).getNodeName());
					System.out.println("第" + (i + 1) + "个book节点的内容" + attrs.item(j).getNodeValue());
				}
				/*
				 * 前提已经知道book节点有且只有一个属性值，并且知道属性值的名字 将book节点进行强制类型转换为element Element
				 * book1=(Element) books.item(i); 通过getAttribute方法来获得属性名
				 * System.out.println(book1.getAttribute("id"));
				 */
				NodeList ChildNode = book.getChildNodes();
				System.out.println("第" + (i + 1) + "个book一共有" + ChildNode.getLength() + "子节点");
				for (int j = 0; j < ChildNode.getLength(); j++) {
					Node temp = ChildNode.item(j);
					// 区分出text类型的node和element类型的node
					if (temp.getNodeType() == Node.ELEMENT_NODE) {
						System.out.print("属性名 : " + temp.getNodeName() + "--");
						System.out.println("属性值" + temp.getFirstChild().getNodeValue());
						// System.out.println("属性值 : "+temp.getTextContent());
					}
				}

			}
		}catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public void CreateXml() {
		// 通过DocumentBuilder这个函数获得一个DocumentBuilder对象
		DocumentBuilder db = GetDocumentBuilder();
		Document document=db.newDocument();
		//将document的StandAlone属性，即是否导入外部文件置为True，即不导入外部文件
		document.setXmlStandalone(true);
	
//		//创建Xml文件的根节点RootNode节点
//		Element RootNode=document.createElement("bookstore");
//		//创建RootNode节点下的子节点BookNode节点
//        Element BookNode=document.createElement("Book");
//        //创建BookNode节点下的子节点BookName
//        Element BookName=document.createElement("Name");
//        //BookName.setNodeValue("小王子");
//        //给 BookName节点赋上文本值
//        BookName.setTextContent("小王子");
//        //把BookName节点挂载到BookNode根节点下去
//        BookNode.appendChild(BookName);
//        //给BookNode节点赋上属性值
//        BookNode.setAttribute("id", "1");
//        //把BookNode节点挂载到RootNode根节点下去
//        RootNode.appendChild(BookNode);
//        //把RootNode根节点挂载到xml文件下
//        document.appendChild(RootNode);
		Element RootNode=document.createElement("BookList");
		Element BookNode=document.createElement("Book");
		Element NameNode=document.createElement("Name");
		Element CatgoryNode=document.createElement("Catgory");
		Element DescriptionNode=document.createElement("Description");
        Element PriceNode=document.createElement("Price");
        BookNode.setAttribute("ID", "1");
        NameNode.setTextContent("白银时代");
        CatgoryNode.setTextContent("当代");
        DescriptionNode.setTextContent("王小波的时代三部曲");
        PriceNode.setTextContent("20");
		Element BookNode1=document.createElement("Book");
		Element NameNode1=document.createElement("Name");
		Element CatgoryNode1=document.createElement("Catgory");
		Element DescriptionNode1=document.createElement("Description");
        Element PriceNode1=document.createElement("Price");
        BookNode1.setAttribute("ID", "2");
        NameNode1.setTextContent("明朝那些事");
        CatgoryNode1.setTextContent("历史");
        DescriptionNode1.setTextContent("趣味历史");
        PriceNode1.setTextContent("50");
        BookNode.appendChild(NameNode);
        BookNode.appendChild(CatgoryNode);
        BookNode.appendChild(DescriptionNode);
        BookNode.appendChild(DescriptionNode);
        BookNode.appendChild(PriceNode);
        RootNode.appendChild(BookNode);
        BookNode1.appendChild(NameNode1);
        BookNode1.appendChild(CatgoryNode1);
        BookNode1.appendChild(DescriptionNode1);
        BookNode1.appendChild(DescriptionNode1);
        BookNode1.appendChild(PriceNode1);
        RootNode.appendChild(BookNode1);
        document.appendChild(RootNode);
        //将生成的Document转换成为Xml文件
        //创建TransformerFactory对象
        TransformerFactory tff=TransformerFactory.newInstance();
        try {
        	//创建Transformer对象
			Transformer tf=tff.newTransformer();
			//给转换器的换行属性值附上yes的值
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			//将document对象转换为xml文件
			tf.transform(new DOMSource(document),new StreamResult("books1.xml"));
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DomTest domtest = new DomTest();
		//domtest.XmlParse();
		domtest.CreateXml();
	}
	/**
	 * 
	    * @Title: CreatXml  
	    * @Description: TODO(创建XML文件)  
	    * @param     参数  
	    * @return void    返回类型  
	    * @throws
	 */
	public void CreatXml() {
		
	}

}
