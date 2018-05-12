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
		// ����һ��DocumentBuilderFactory����
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			// ����һ��DocumentBuilder����
			DocumentBuilder db = dbf.newDocumentBuilder();
			// ͨ��DocumentBuilder�����Parse��������books.xml����ǰĿ¼��
			Document document = db.parse("books.xml");
			// ��ȡ����book�ڵ�ļ���
			NodeList books = document.getElementsByTagName("book");
			// ����ÿһ��book�ڵ�
			for (int i = 0; i < books.getLength(); i++) {
				// ͨ��item(index)�������һ��book�ڵ㣬books������ֵ��0��ʼ
				Node book = books.item(i);
				System.out.println("��" + (i + 1) + "��book");
				NamedNodeMap attrs = book.getAttributes();
				for (int j = 0; j < attrs.getLength(); j++) {
					System.out.println("��" + (i + 1) + "��book�ڵ������" + attrs.item(j).getNodeName());
					System.out.println("��" + (i + 1) + "��book�ڵ������" + attrs.item(j).getNodeValue());
				}
				/*
				 *ǰ���Ѿ�֪��book�ڵ�����ֻ��һ������ֵ������֪������ֵ������
				 *��book�ڵ����ǿ������ת��Ϊelement
				 *Element book1=(Element) books.item(i);
				 *ͨ��getAttribute���������������
				 *System.out.println(book1.getAttribute("id"));
				 */
                 NodeList ChildNode=book.getChildNodes();
                 System.out.println("��" + (i + 1) + "��bookһ����"+ChildNode.getLength()+"�ӽڵ�");
             for(int j=0;j<ChildNode.getLength();j++) {
            	 Node temp=ChildNode.item(j);
            	 //���ֳ�text���͵�node��element���͵�node
            	 if(temp.getNodeType()==Node.ELEMENT_NODE) {
            	 System.out.print("������ : "+temp.getNodeName()+"--");
            	 System.out.println("����ֵ"+temp.getFirstChild().getNodeValue());
            	// System.out.println("����ֵ : "+temp.getTextContent());
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
