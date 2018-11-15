package com.imooc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class FieldTest {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Class class1=Class.forName("com.imooc.reflect.Book");
		Constructor c=class1.getConstructor(int.class,String.class,int.class);
	   // c.newInstance(1,"1",1);
		//1.通过field对象来获取共有的类属性
	    Field field= class1.getField("BookPrice");
	    field.setAccessible(true);
	    System.out.println(field.get( c.newInstance(1,"1",1)));
	    //2.通过field对象来获取私有的类属性
	    Field field1=class1.getDeclaredField("BookId");
	    //通过把可以访问的属性设置为true，来获得私有变量的访问权限
	    field1.setAccessible(true);
	    System.out.println(field1.get( c.newInstance(111,"",1)));
	}

}
