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
		// 进行对Jdom文件解析的准备工作

		try {
			// 1.创建一个SaxBuilder对象
			SAXBuilder saxBuilder = new SAXBuilder();
			// 2.创建一个输入流，将xml文件加载到输入流中去
			InputStream inputStream = new FileInputStream("books.xml");
			// 通过InputStreamReader来解决乱码问题
		     //InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			// 3.通过saxBuilder的build方法，将输入流加载到saxBuilder中去
			Document document = saxBuilder.build(inputStream);
			// 4.通过getRootElement方法找到根节点
			Element RootElement = document.getRootElement();
			/*
			 * String RootName=RootElement.getName();
			 * System.out.println(RootName+"       ");
			 */
			// 5.通过getChildren方法 ，获得根节点下的所有孩子节点
			List<Element> ChildrenElement = RootElement.getChildren();
			Book tempBook = new Book();
			for (Element child : ChildrenElement) {
				int index = ChildrenElement.indexOf(child);
				System.out.println("-----开始解析第" + (index + 1) + "书-----");
				String ChildName = child.getName();
				System.out.println("书的名字 ： " + ChildName);
				// 6.通过getAttributes方法，得到孩子节点的属性值
				List<Attribute> ChildAttr = child.getAttributes();
				for (Attribute attr : ChildAttr) {
					String AttrName = attr.getName();
					String AttrValue = attr.getValue();
					if (AttrName.equals("id")) {
						tempBook.setId(AttrValue);
					}
					System.out.println("书的属性名 ： " + AttrName + "  属性值 ：" + AttrValue);
				}
				// 7.通过getChildren方法，获得书节点下的所有孩子节点
				List<Element> Children = child.getChildren();
				// 解析book的属性集合
				for (Element Child : Children) {
					// 获得属性名
					String childName = Child.getName();
					// 获得属性值
					String childValue = Child.getValue();
					System.out.println("属性名 ： " + childName + "  属性值 ：" + childValue);
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
				System.out.println("-----结束解析第" + (index + 1) + "书-----");

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
