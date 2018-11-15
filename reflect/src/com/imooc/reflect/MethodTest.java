package com.imooc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodTest {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class class1=Class.forName("com.imooc.reflect.Address");
		Constructor c=class1.getConstructor();
		//1.通过反射获取到类中的无参public函数
		Method m=class1.getMethod("toString",null );
        Object result=m.invoke(c.newInstance(),null );
        System.out.println(result);
	    //2.通过反射获取到类中的无参private函数
    	Method m1=class1.getDeclaredMethod("info",null );
    	//通过设置对象的是否可获得来得到private对象的访问权
    	m1.setAccessible(true);
        m1.invoke(c.newInstance(),null );
        //3.通过反射获取到类中的有参private函数
        Method m2=class1.getDeclaredMethod("equalsAddress",String.class );
        m2.setAccessible(true);
    	Constructor c1=class1.getConstructor(int.class,String.class,String.class,int.class);
        m2.invoke(c1.newInstance(1,"1","1",1),"1111" );
      
	}

}
