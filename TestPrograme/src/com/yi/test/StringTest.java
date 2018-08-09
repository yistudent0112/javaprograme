package com.yi.test;
/**
 * 
 * 针对string对象有以下三大特点
 * 1不变性 即String对象被创建之后,其内部的值就不会再发生改变了
 * 2常量池优化 即内容一样的常量String都指向同一个地址
 * 3String类进行了final修饰,String没有子类
 * 
 * 当需要做字符串连接的时候,尽量避免使用+,StringBuilder和StringBuffer的性能比它好几千倍
 * StringBuffer实现了线程安全所以性能上比StringBuilder要差一点
 * 当需要做其他类型转换成String类型的时候,也应该尽量避免使用+"",和上面同理
 * 而valueof()和toString()的区别在于valueof()要先判断字符内容时候为空,再调用toString()
 * 所以toString()的性能最好
 *
 */
@SuppressWarnings("unused")
public class StringTest {
public void addtest1() {
	long time=System.currentTimeMillis();
	String test1="";
	for(int i=0;i<100000;i++) {
		test1+="a";
	}
	long interval=System.currentTimeMillis()-time;
	System.out.println("String对象添加100000次所消耗的时间: "+interval);
}
public void addtest2() {
	long time=System.currentTimeMillis();
	StringBuffer sb=new StringBuffer();
	for(int i=0;i<100000;i++) {
		sb.append("a");
	}
	long interval=System.currentTimeMillis()-time;
	System.out.println("StringBuffer对象添加100000次所消耗的时间: "+interval);
}
public void addtest3() {
	long time=System.currentTimeMillis();
	StringBuilder sb=new StringBuilder();
	for(int i=0;i<100000;i++) {
		sb.append("a");
	}
	long interval=System.currentTimeMillis()-time;
	System.out.println("StringBuilder对象添加100000次所消耗的时间: "+interval);

}
public void transferTest1() {
	long time=System.currentTimeMillis();
	Integer number=0;
	for(int i=0;i<100000;i++) {
		String s=String.valueOf(number);
	}
	long interval=System.currentTimeMillis()-time;
	System.out.println("valueof方法转换成String所消耗的时间"+interval);
}
public void transferTest2() {
	long time=System.currentTimeMillis();
	Integer number=0;
	for(int i=0;i<100000;i++) {
		String s=number.toString();
	}
	long interval=System.currentTimeMillis()-time;
	System.out.println("toString方法转换成String所消耗的时间"+interval);
}
public void transferTest3() {
	long time=System.currentTimeMillis();
	Integer number=0;
	for(int i=0;i<100000;i++) {
		String s=number+"";
	}
	long interval=System.currentTimeMillis()-time;
	System.out.println("+\" \" 法转换成String所消耗的时间"+interval);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s1 = "123";
//		String s2 = "123";
//		String s3 = new String("123");
//	    System.out.println(s1==s3.intern());
//		System.out.println(s1 == s2);
//		System.out.println(s1 == s3);
		StringTest test=new StringTest();
//		test.addtest1();
//		test.addtest2();
//		test.addtest3();
		test.transferTest1();
		test.transferTest2();
		test.transferTest3();
	}

}
