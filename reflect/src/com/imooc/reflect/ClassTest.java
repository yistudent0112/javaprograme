package com.imooc.reflect;

public class ClassTest {
/*
 * 获得Class对象
 * 1.通过类名.class
 * 2.对象.getClass()
 * 3.Class.forname()
 */
	public void demo1() throws ClassNotFoundException {
			//方法1
		Class clazz1=Person.class;
         //方法2
		Person person=new Person();
		Class clazz2=person.getClass();
		//方法3(通常都是在不知道对象的情况下来操作，所以推荐使用第三种方式)
		Class clazz3=Class.forName("com.imooc.reflect.Person");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
