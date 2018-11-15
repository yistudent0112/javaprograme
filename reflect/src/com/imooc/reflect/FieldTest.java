package com.imooc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class FieldTest {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Class class1=Class.forName("com.imooc.reflect.Book");
		Constructor c=class1.getConstructor(int.class,String.class,int.class);
	   // c.newInstance(1,"1",1);
		//1.ͨ��field��������ȡ���е�������
	    Field field= class1.getField("BookPrice");
	    field.setAccessible(true);
	    System.out.println(field.get( c.newInstance(1,"1",1)));
	    //2.ͨ��field��������ȡ˽�е�������
	    Field field1=class1.getDeclaredField("BookId");
	    //ͨ���ѿ��Է��ʵ���������Ϊtrue�������˽�б����ķ���Ȩ��
	    field1.setAccessible(true);
	    System.out.println(field1.get( c.newInstance(111,"",1)));
	}

}
