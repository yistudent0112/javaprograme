package com.imooc.yi;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 创建一个DocumentBuilderFactory对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			// 创建一个DocumentBuilder对象
			DocumentBuilder db = dbf.newDocumentBuilder();
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
				 *前提已经知道book节点有且只有一个属性值，并且知道属性值的名字
				 *将book节点进行强制类型转换为element
				 *Element book1=(Element) books.item(i);
				 *通过getAttribute方法来获得属性名
				 *System.out.println(book1.getAttribute("id"));
				 */
                 NodeList ChildNode=book.getChildNodes();
                 System.out.println("第" + (i + 1) + "个book一共有"+ChildNode.getLength()+"子节点");
             for(int j=0;j<ChildNode.getLength();j++) {
            	 Node temp=ChildNode.item(j);
            	 //区分出text类型的node和element类型的node
            	 if(temp.getNodeType()==Node.ELEMENT_NODE) {
            	 System.out.print("属性名 : "+temp.getNodeName()+"--");
            	 System.out.println("属性值"+temp.getFirstChild().getNodeValue());
            	// System.out.println("属性值 : "+temp.getTextContent());
            	 }
             }
				
			}
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
