package com.yi.test;

import java.lang.reflect.Field;

public class IntegerTest {
	/**
	 * ʹ��Integer�ؼ��ִ������ڴ���������һ��Integer�Ķ���
	 * ��==�жϵ��������������ڴ��еĵ�ַ�Ƿ���ͬ������ǰ������������϶�Ӧ��Ϊfalse
	 * ����һ�����Ϊtrue����Ϊ��Integer�ڲ���һ��˽����IntegerCache
	 * ���������-128-127��Χ�Ķ��󣬵�ʹ�õ������ǣ�ֱ�ӷ��ص������Ƕ��������
	 * ��ô����ԭ��������һ��Χ�ڵ�����ʹ��Ƶ�ʺܸߣ������Ĳ������Խ�ʡ�ڴ�ռ�
	 */
public void test() {
	Integer a=1000;
	Integer b=1000;
	int c=1000;
	int d=1000;
	Integer e=100;
	Integer f=100;
	System.out.println(e==f);
	System.out.println(a==b);
	System.out.println(c==d);
}
	public static void main(String[] args) throws Exception, Exception {
//IntegerTest test=new IntegerTest();
//test.test();
	//�������
		Class cache=Integer.class.getDeclaredClasses()[0];
		Field myCache=cache.getDeclaredField("cache");
		myCache.setAccessible(true);
		Integer[] newCache=(Integer[]) myCache.get(cache);
		//�޸��˶�Ӧ��IntegerCache��4��ֵ����4��Ϊ��5
		newCache[132]=newCache[133];
		int a=2;
		int b=a+a;
		System.out.printf("%d + %d = %d\n",a,a,b);
		System.out.println(a+" + "+a+" = "+b);
	}

}
