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
    * @Description: TODO(Xml文件解析函数)  
    * @param     参数  
    * @return void    返回类型  
    * @throws
 */
	public void XmlParse() {
        //解析books.xml文件
		//创建SAXReader的对象reader
		SAXReader reader=new SAXReader();
		try {
			//通过reader对象的read方法，把xml文件加载进去
			Document document=reader.read(new File("books.xml"));
			//通过getRootElement方法，获取xml文件的根节点
			Element BookStore=document.getRootElement();
			//通过elementIterator方法获取根节点下的迭代器
			Iterator it=BookStore.elementIterator();
			while(it.hasNext()) {
				System.out.println("-----开始对一本书的遍历-----");
				//对迭代器中的一个对象book开始解析
				Element book=(Element) it.next();
				//获得book对象的所有属性值
				List<Attribute> BookAttr=book.attributes();
				for(Attribute attr:BookAttr) {
					//获取属性名
					String AttrName=attr.getName();
					//获取属性值
					String AttrValue=attr.getValue();
					System.out.println("书的属性名 : "+AttrName+"属性值 ： "+AttrValue);
				}
				//通过elementIterator方法获取到book节点下的迭代器
				Iterator itb=book.elementIterator();
				while(itb.hasNext()) {
					//获取一个新的节点
					Element Node=(Element) itb.next();
					//获取节点名
					String NodeName=Node.getName();
					//获取节点值
					String NodeValue=Node.getStringValue();
					System.out.println("节点名 : "+NodeName+"节点值 ： "+NodeValue);
				}
				System.out.println("-----结束对一本书的遍历-----");
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
