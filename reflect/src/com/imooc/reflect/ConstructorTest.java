package com.imooc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// 获得无参数的构造方法
		
	    //1.拿到goods商品类的类对象
		Class class1=Class.forName("com.imooc.reflect.Goods");
		//2.获取到goods类的无参构造函数
        Constructor c=class1.getConstructor();
        //3.相当于 Goods goods=new Goods();
        Goods goods=(Goods) c.newInstance();
        goods.display();
        
        // 获得有参数的构造函数
        
        //1.拿到goods商品类的类对象
       // Class class2=Class.forName("com.imooc.reflect.Goods");
    	//2.获取到goods类的无参构造函数
        //这里需要注意的是 当构造函数中的参数类型为int这种时，应该传入的是int.class而不是他的包装类Integer.class
        Constructor c1=class1.getConstructor(int.class,int.class,String.class,String.class);
        //3.相当于 Goods goods=new Goods(1,"1",1,"1");
        Goods goods1=(Goods)c1.newInstance(1,1,"1","1");
        goods1.display();
	}

}
