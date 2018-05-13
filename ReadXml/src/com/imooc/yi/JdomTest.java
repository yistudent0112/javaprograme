package com.imooc.yi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.imooc.entity.Book;

public class JdomTest {
	private static List<Book> Booklist = new ArrayList<Book>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���ж�Jdom�ļ�������׼������

		try {
			// 1.����һ��SaxBuilder����
			SAXBuilder saxBuilder = new SAXBuilder();
			// 2.����һ������������xml�ļ����ص���������ȥ
			InputStream inputStream = new FileInputStream("books.xml");
			// ͨ��InputStreamReader�������������
		     //InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			// 3.ͨ��saxBuilder��build�����������������ص�saxBuilder��ȥ
			Document document = saxBuilder.build(inputStream);
			// 4.ͨ��getRootElement�����ҵ����ڵ�
			Element RootElement = document.getRootElement();
			/*
			 * String RootName=RootElement.getName();
			 * System.out.println(RootName+"       ");
			 */
			// 5.ͨ��getChildren���� ����ø��ڵ��µ����к��ӽڵ�
			List<Element> ChildrenElement = RootElement.getChildren();
			Book tempBook = new Book();
			for (Element child : ChildrenElement) {
				int index = ChildrenElement.indexOf(child);
				System.out.println("-----��ʼ������" + (index + 1) + "��-----");
				String ChildName = child.getName();
				System.out.println("������� �� " + ChildName);
				// 6.ͨ��getAttributes�������õ����ӽڵ������ֵ
				List<Attribute> ChildAttr = child.getAttributes();
				for (Attribute attr : ChildAttr) {
					String AttrName = attr.getName();
					String AttrValue = attr.getValue();
					if (AttrName.equals("id")) {
						tempBook.setId(AttrValue);
					}
					System.out.println("��������� �� " + AttrName + "  ����ֵ ��" + AttrValue);
				}
				// 7.ͨ��getChildren�����������ڵ��µ����к��ӽڵ�
				List<Element> Children = child.getChildren();
				// ����book�����Լ���
				for (Element Child : Children) {
					// ���������
					String childName = Child.getName();
					// �������ֵ
					String childValue = Child.getValue();
					System.out.println("������ �� " + childName + "  ����ֵ ��" + childValue);
					if (childName.equals("name")) {
						tempBook.setName(childValue);
					} else if (childName.equals("catgory")) {
						tempBook.setCatgory(childValue);
					} else if (childName.equals("description")) {
						tempBook.setDescription(childValue);
					} else if (childName.equals("price")) {
						tempBook.setPrice(childValue);
					}
				}
				Booklist.add(tempBook);
				tempBook = new Book();
				System.out.println("-----����������" + (index + 1) + "��-----");

			}
			for (Book temp : Booklist) {
				System.out.println(temp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
