package com.imooc.reflect;

public class ClassTest {
/*
 * ���Class����
 * 1.ͨ������.class
 * 2.����.getClass()
 * 3.Class.forname()
 */
	public void demo1() throws ClassNotFoundException {
			//����1
		Class clazz1=Person.class;
         //����2
		Person person=new Person();
		Class clazz2=person.getClass();
		//����3(ͨ�������ڲ�֪�������������������������Ƽ�ʹ�õ����ַ�ʽ)
		Class clazz3=Class.forName("com.imooc.reflect.Person");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
