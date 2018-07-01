package com.imooc.yi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jTest {
	/**
	 * 
	 * @Title: XmlParse @Description: TODO(Xml�ļ���������) @param ���� @return void
	 * �������� @throws
	 */
	public void XmlParse() {
		// ����books.xml�ļ�
		// ����SAXReader�Ķ���reader
		SAXReader reader = new SAXReader();
		try {
			// ͨ��reader�����read��������xml�ļ����ؽ�ȥ
			Document document = reader.read(new File("books.xml"));
			// ͨ��getRootElement��������ȡxml�ļ��ĸ��ڵ�
			Element BookStore = document.getRootElement();
			// ͨ��elementIterator������ȡ���ڵ��µĵ�����
			Iterator it = BookStore.elementIterator();
			while (it.hasNext()) {
				System.out.println("-----��ʼ��һ����ı���-----");
				// �Ե������е�һ������book��ʼ����
				Element book = (Element) it.next();
				// ���book�������������ֵ
				List<Attribute> BookAttr = book.attributes();
				for (Attribute attr : BookAttr) {
					// ��ȡ������
					String AttrName = attr.getName();
					// ��ȡ����ֵ
					String AttrValue = attr.getValue();
					System.out.println("��������� : " + AttrName + "����ֵ �� " + AttrValue);
				}
				// ͨ��elementIterator������ȡ��book�ڵ��µĵ�����
				Iterator itb = book.elementIterator();
				while (itb.hasNext()) {
					// ��ȡһ���µĽڵ�
					Element Node = (Element) itb.next();
					// ��ȡ�ڵ���
					String NodeName = Node.getName();
					// ��ȡ�ڵ�ֵ
					String NodeValue = Node.getStringValue();
					System.out.println("�ڵ��� : " + NodeName + "�ڵ�ֵ �� " + NodeValue);
				}
				System.out.println("-----������һ����ı���-----");
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void CreateXML() {
		// 1.����document���󣬴�������xml�ĵ�
		Document document = DocumentHelper.createDocument();
		// 2.�������ڵ�rss
		Element rss = document.addElement("rss");
		// 3.��rss�ڵ������version����
		rss.addAttribute("version", "2.0");
		// 4.�����ӽڵ�����Ӧ�Ľڵ�����
		Element channel=rss.addElement("channel");
		Element title=channel.addElement("title");
		title.setText("<![CDATA[ʱ��Ƶ��]]>");
		Element image=channel.addElement("image");
		Element childtitle=image.addElement("title");
		childtitle.setText("<![CDATA[ʱ��Ƶ��]]>");
		Element link=image.addElement("link");
		link.setText("http://politics.people.cn");
		Element url=image.addElement("url");
		url.setText("http://www.people.cn/img/2014peoplelogo/rmw_logo.gif");
		//5.��������xml�ĸ�ʽ
		OutputFormat format=OutputFormat.createPrettyPrint();
		// 6.����xml�ĵ�
		File file = new File("rssnews.xml");
		try {
			XMLWriter writer = new XMLWriter(new FileOutputStream(file),format);
			//�����Ƿ�����ת�幦�ܣ�Ĭ��Ϊtrue��������ת�幦��
			writer.setEscapeText(false);
			writer.write(document);
			writer.close();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dom4jTest test=new Dom4jTest();
		test.CreateXML();
	}
}
