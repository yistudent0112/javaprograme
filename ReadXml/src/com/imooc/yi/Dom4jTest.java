package com.imooc.yi;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jTest {
/**
 * 
    * @Title: XmlParse  
    * @Description: TODO(Xml�ļ���������)  
    * @param     ����  
    * @return void    ��������  
    * @throws
 */
	public void XmlParse() {
        //����books.xml�ļ�
		//����SAXReader�Ķ���reader
		SAXReader reader=new SAXReader();
		try {
			//ͨ��reader�����read��������xml�ļ����ؽ�ȥ
			Document document=reader.read(new File("books.xml"));
			//ͨ��getRootElement��������ȡxml�ļ��ĸ��ڵ�
			Element BookStore=document.getRootElement();
			//ͨ��elementIterator������ȡ���ڵ��µĵ�����
			Iterator it=BookStore.elementIterator();
			while(it.hasNext()) {
				System.out.println("-----��ʼ��һ����ı���-----");
				//�Ե������е�һ������book��ʼ����
				Element book=(Element) it.next();
				//���book�������������ֵ
				List<Attribute> BookAttr=book.attributes();
				for(Attribute attr:BookAttr) {
					//��ȡ������
					String AttrName=attr.getName();
					//��ȡ����ֵ
					String AttrValue=attr.getValue();
					System.out.println("��������� : "+AttrName+"����ֵ �� "+AttrValue);
				}
				//ͨ��elementIterator������ȡ��book�ڵ��µĵ�����
				Iterator itb=book.elementIterator();
				while(itb.hasNext()) {
					//��ȡһ���µĽڵ�
					Element Node=(Element) itb.next();
					//��ȡ�ڵ���
					String NodeName=Node.getName();
					//��ȡ�ڵ�ֵ
					String NodeValue=Node.getStringValue();
					System.out.println("�ڵ��� : "+NodeName+"�ڵ�ֵ �� "+NodeValue);
				}
				System.out.println("-----������һ����ı���-----");
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
