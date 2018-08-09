package com.yi.test;

import java.lang.reflect.Field;

public class IntegerTest {
	/**
	 * 使用Integer关键字代表在内存中生成了一个Integer的对象
	 * 而==判断的是两个对象在内存中的地址是否相同，所以前两个输出理论上都应该为false
	 * 而第一个结果为true是因为在Integer内部有一个私用类IntegerCache
	 * 里面存贮了-128-127范围的对象，当使用到他们是，直接返回的是他们对象的引用
	 * 这么做的原因是在这一范围内的数字使用频率很高，这样的操作可以节省内存空间
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
	//反射机制
		Class cache=Integer.class.getDeclaredClasses()[0];
		Field myCache=cache.getDeclaredField("cache");
		myCache.setAccessible(true);
		Integer[] newCache=(Integer[]) myCache.get(cache);
		//修改了对应的IntegerCache中4的值，把4变为了5
		newCache[132]=newCache[133];
		int a=2;
		int b=a+a;
		System.out.printf("%d + %d = %d\n",a,a,b);
		System.out.println(a+" + "+a+" = "+b);
	}

}
