package com.yi.test;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

/**
 * 
 * �����Ż�������    ������������δ֪����
 * �����Ż���Ŀ�꣺1.��С���������   2.��ߴ��������Ч��
 * 
 * ����ϸ�ڣ�
 * 1.������ʹ��final���η�
 * java�������ᾡ���ܽ���final���εĺ���ת��Ϊ���������������ͻ���ߴ��������
 * ����ʹ��final���λ��ܱ��⺯�����̳к���д�������˴������Ŀ�����
 * 2.���������ö���
 * �����ɲ���Ҫ���ɵĶ�����ܼ����ڴ�ռ��ʹ�ã�������������ٶ�
 * 3.������ʹ�þֲ�����
 * ��Ϊ��java���ڴ�����оֲ�����������ջ�У���ȫ�ֱ����洢�ڶ��У��ٶȽ���
 * ���Ҿֲ���������Ҫʹ���ڴ���ջ��ƣ��ڵ��ý�������Զ������ڴ�
 * 4.��ʱ�ر����������
 * ��Щ����ϵͳ�����Ĺ��ܶ���ռ�ô�������Դ
 * 5.�������ٶԱ������ظ�����
 * ��  for(int i=0;i<a.length;i++)   ����        for(int i=0,b=a.length;i<b;i++)
 * 6.����ʹ���쳣
 *    �쳣������Ӱ��ǳ��󣬵��쳣��������java������ͻ��޸Ķ�ջ��Ϣ��
 *    �쳣ֻӦ�����ڴ���������Ӧ���������̿���
 * 7.��ʹ�ü��ϻ򹤾���ʹ�����֪������ʹ�÷�Χ���趨�ü��ϵĴ�С
 * ��������̶����ڴ�ռ䣬�����������ϸ����������ڴ�ռ��������Ͽ�
 * 8.��Ҫ���ƴ���������ʱ��ʹ��System.arraycopy()
 * 9.�˷��ͳ�������ʹ����λ����������
 * ��Ϊ��λ�������ɵײ���ʵ�ֵģ����������ϻ��ܶ� 
 * 10.��Ҫ��public��������̫����βγ���
 * public�Ƕ��⹫���ķ�����Ҫ�ǲ�������������������
 * 1.��������������˼�룬������βκ���������˼���ͻ
 * 2.������β��п��ܻ��������γ���
 * ���Ҫ����Ĳ������࣬���Խ�����Ϊһ����װ�࣬Ȼ�󴫵�һ����Ķ������
 * 11.����Դ��close����Ӧ��д�ڲ�ͬ��try��catch��
 * ������һ��close�����쳣�����ʱ����һ��������������ܹ������Ĺر�
 *
 */
public class OptimizationTest {
private static int test() {
	int i=1;
	try {
		return i;
	}catch(Exception exception) {
		exception.printStackTrace();
	}
	finally {
	    i=0;
		return i;
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//System.out.println(Objects.equals('a', null));
//		String word="test";
//		switch(word) {
//		case "test":
//			System.out.println("test");
//			break;
//		}
//		System.out.println(UUID.randomUUID());
//		System.out.println(UUID.randomUUID());
		System.out.println(test());
	}

}
