package com.imooc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodTest {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class class1=Class.forName("com.imooc.reflect.Address");
		Constructor c=class1.getConstructor();
		//1.ͨ�������ȡ�����е��޲�public����
		Method m=class1.getMethod("toString",null );
        Object result=m.invoke(c.newInstance(),null );
        System.out.println(result);
	    //2.ͨ�������ȡ�����е��޲�private����
    	Method m1=class1.getDeclaredMethod("info",null );
    	//ͨ�����ö�����Ƿ�ɻ�����õ�private����ķ���Ȩ
    	m1.setAccessible(true);
        m1.invoke(c.newInstance(),null );
        //3.ͨ�������ȡ�����е��в�private����
        Method m2=class1.getDeclaredMethod("equalsAddress",String.class );
        m2.setAccessible(true);
    	Constructor c1=class1.getConstructor(int.class,String.class,String.class,int.class);
        m2.invoke(c1.newInstance(1,"1","1",1),"1111" );
      
	}

}
