package com.imooc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// ����޲����Ĺ��췽��
		
	    //1.�õ�goods��Ʒ��������
		Class class1=Class.forName("com.imooc.reflect.Goods");
		//2.��ȡ��goods����޲ι��캯��
        Constructor c=class1.getConstructor();
        //3.�൱�� Goods goods=new Goods();
        Goods goods=(Goods) c.newInstance();
        goods.display();
        
        // ����в����Ĺ��캯��
        
        //1.�õ�goods��Ʒ��������
       // Class class2=Class.forName("com.imooc.reflect.Goods");
    	//2.��ȡ��goods����޲ι��캯��
        //������Ҫע����� �����캯���еĲ�������Ϊint����ʱ��Ӧ�ô������int.class���������İ�װ��Integer.class
        Constructor c1=class1.getConstructor(int.class,int.class,String.class,String.class);
        //3.�൱�� Goods goods=new Goods(1,"1",1,"1");
        Goods goods1=(Goods)c1.newInstance(1,1,"1","1");
        goods1.display();
	}

}
