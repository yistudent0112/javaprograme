package com.yi.test;
/**
 * 
 * ���string���������������ص�
 * 1������ ��String���󱻴���֮��,���ڲ���ֵ�Ͳ����ٷ����ı���
 * 2�������Ż� ������һ���ĳ���String��ָ��ͬһ����ַ
 * 3String�������final����,Stringû������
 * 
 * ����Ҫ���ַ������ӵ�ʱ��,��������ʹ��+,StringBuilder��StringBuffer�����ܱ����ü�ǧ��
 * StringBufferʵ�����̰߳�ȫ���������ϱ�StringBuilderҪ��һ��
 * ����Ҫ����������ת����String���͵�ʱ��,ҲӦ�þ�������ʹ��+"",������ͬ��
 * ��valueof()��toString()����������valueof()Ҫ���ж��ַ�����ʱ��Ϊ��,�ٵ���toString()
 * ����toString()���������
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
	System.out.println("String�������100000�������ĵ�ʱ��: "+interval);
}
public void addtest2() {
	long time=System.currentTimeMillis();
	StringBuffer sb=new StringBuffer();
	for(int i=0;i<100000;i++) {
		sb.append("a");
	}
	long interval=System.currentTimeMillis()-time;
	System.out.println("StringBuffer�������100000�������ĵ�ʱ��: "+interval);
}
public void addtest3() {
	long time=System.currentTimeMillis();
	StringBuilder sb=new StringBuilder();
	for(int i=0;i<100000;i++) {
		sb.append("a");
	}
	long interval=System.currentTimeMillis()-time;
	System.out.println("StringBuilder�������100000�������ĵ�ʱ��: "+interval);

}
public void transferTest1() {
	long time=System.currentTimeMillis();
	Integer number=0;
	for(int i=0;i<100000;i++) {
		String s=String.valueOf(number);
	}
	long interval=System.currentTimeMillis()-time;
	System.out.println("valueof����ת����String�����ĵ�ʱ��"+interval);
}
public void transferTest2() {
	long time=System.currentTimeMillis();
	Integer number=0;
	for(int i=0;i<100000;i++) {
		String s=number.toString();
	}
	long interval=System.currentTimeMillis()-time;
	System.out.println("toString����ת����String�����ĵ�ʱ��"+interval);
}
public void transferTest3() {
	long time=System.currentTimeMillis();
	Integer number=0;
	for(int i=0;i<100000;i++) {
		String s=number+"";
	}
	long interval=System.currentTimeMillis()-time;
	System.out.println("+\" \" ��ת����String�����ĵ�ʱ��"+interval);
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
