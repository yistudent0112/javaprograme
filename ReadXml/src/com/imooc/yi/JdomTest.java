package com.imooc.yi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.CDATA;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.EscapeStrategy;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.imooc.entity.Book;

public class JdomTest {
	private static List<Book> Booklist = new ArrayList<Book>();

	public void ParseXML() {
		// TODO Auto-generated method stub
		// 进行对Jdom文件解析的准备工作

		try {
			// 1.创建一个SaxBuilder对象
			SAXBuilder saxBuilder = new SAXBuilder();
			// 2.创建一个输入流，将xml文件加载到输入流中去
			InputStream inputStream = new FileInputStream("books.xml");
			// 通过InputStreamReader来解决乱码问题
			// InputStreamReader inputStreamReader = new InputStreamReader(inputStream,
			// "UTF-8");
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

	public void CreateXML() {
		// 1.生成一个根节点
		Element rss = new Element("rss");
		// 2.为根节点添加属性
		rss.setAttribute("version", "2.0");
		//为根节点下添加内容
		Element content=new Element("content");
		//对于需要转义的内容，在jdom中使用cdata来封装他
		content.addContent(new CDATA("<国内最新新闻>"));
		rss.addContent(content);
		// 3.生成一个document对象
		Document document = new Document(rss);
		// 4.创建一个XMLOutputer的对象
		Format format = Format.getPrettyFormat();
		format.setIndent("");
		//将xml文件的编码形式转变为gbk
		format.setEncoding("gbk");
		format.setEscapeStrategy(new EscapeStrategy() {
			
			@Override
			public boolean shouldEscape(char arg0) {
				// TODO Auto-generated method stub
				return false;
			}
		});
		XMLOutputter outputer = new XMLOutputter(format);
		// 5.利用Outputer将document转换为xml文件
		try {
			File f = new File("rssnewxml2");
			if (!f.exists()) {
				f.createNewFile();
			}
			outputer.output(document, new FileOutputStream(f));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JdomTest test = new JdomTest();
		test.CreateXML();
	}

}
