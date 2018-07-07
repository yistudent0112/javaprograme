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
		// ����һ��DocumentBuilderFactory����
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    DocumentBuilder db = null;
			// ����һ��DocumentBuilder����
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
	 * @Description: TODO(Xml�ļ���������) 
	 * @param ���� 
	 * @return void
	 * �������� @throws
	 */
	public void XmlParse() {
		// ͨ��DocumentBuilder����������һ��DocumentBuilder����
		DocumentBuilder db = GetDocumentBuilder();
		try {
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
				 * ǰ���Ѿ�֪��book�ڵ�����ֻ��һ������ֵ������֪������ֵ������ ��book�ڵ����ǿ������ת��Ϊelement Element
				 * book1=(Element) books.item(i); ͨ��getAttribute���������������
				 * System.out.println(book1.getAttribute("id"));
				 */
				NodeList ChildNode = book.getChildNodes();
				System.out.println("��" + (i + 1) + "��bookһ����" + ChildNode.getLength() + "�ӽڵ�");
				for (int j = 0; j < ChildNode.getLength(); j++) {
					Node temp = ChildNode.item(j);
					// ���ֳ�text���͵�node��element���͵�node
					if (temp.getNodeType() == Node.ELEMENT_NODE) {
						System.out.print("������ : " + temp.getNodeName() + "--");
						System.out.println("����ֵ" + temp.getFirstChild().getNodeValue());
						// System.out.println("����ֵ : "+temp.getTextContent());
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
		// ͨ��DocumentBuilder����������һ��DocumentBuilder����
		DocumentBuilder db = GetDocumentBuilder();
		Document document=db.newDocument();
		//��document��StandAlone���ԣ����Ƿ����ⲿ�ļ���ΪTrue�����������ⲿ�ļ�
		document.setXmlStandalone(true);
	
//		//����Xml�ļ��ĸ��ڵ�RootNode�ڵ�
//		Element RootNode=document.createElement("bookstore");
//		//����RootNode�ڵ��µ��ӽڵ�BookNode�ڵ�
//        Element BookNode=document.createElement("Book");
//        //����BookNode�ڵ��µ��ӽڵ�BookName
//        Element BookName=document.createElement("Name");
//        //BookName.setNodeValue("С����");
//        //�� BookName�ڵ㸳���ı�ֵ
//        BookName.setTextContent("С����");
//        //��BookName�ڵ���ص�BookNode���ڵ���ȥ
//        BookNode.appendChild(BookName);
//        //��BookNode�ڵ㸳������ֵ
//        BookNode.setAttribute("id", "1");
//        //��BookNode�ڵ���ص�RootNode���ڵ���ȥ
//        RootNode.appendChild(BookNode);
//        //��RootNode���ڵ���ص�xml�ļ���
//        document.appendChild(RootNode);
		Element RootNode=document.createElement("BookList");
		Element BookNode=document.createElement("Book");
		Element NameNode=document.createElement("Name");
		Element CatgoryNode=document.createElement("Catgory");
		Element DescriptionNode=document.createElement("Description");
        Element PriceNode=document.createElement("Price");
        BookNode.setAttribute("ID", "1");
        NameNode.setTextContent("����ʱ��");
        CatgoryNode.setTextContent("����");
        DescriptionNode.setTextContent("��С����ʱ��������");
        PriceNode.setTextContent("20");
		Element BookNode1=document.createElement("Book");
		Element NameNode1=document.createElement("Name");
		Element CatgoryNode1=document.createElement("Catgory");
		Element DescriptionNode1=document.createElement("Description");
        Element PriceNode1=document.createElement("Price");
        BookNode1.setAttribute("ID", "2");
        NameNode1.setTextContent("������Щ��");
        CatgoryNode1.setTextContent("��ʷ");
        DescriptionNode1.setTextContent("Ȥζ��ʷ");
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
        //�����ɵ�Documentת����ΪXml�ļ�
        //����TransformerFactory����
        TransformerFactory tff=TransformerFactory.newInstance();
        try {
        	//����Transformer����
			Transformer tf=tff.newTransformer();
			//��ת�����Ļ�������ֵ����yes��ֵ
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			//��document����ת��Ϊxml�ļ�
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
	    * @Description: TODO(����XML�ļ�)  
	    * @param     ����  
	    * @return void    ��������  
	    * @throws
	 */
	public void CreatXml() {
		
	}

}
