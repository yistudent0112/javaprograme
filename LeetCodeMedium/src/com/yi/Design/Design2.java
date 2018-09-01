package com.yi.Design;

import java.util.HashSet;
import java.util.Set;
/*
 * �����Ҫ�����Լ����һ��set���͵����ݽṹ
 * ��Ȼset�������������ճ��лᾭ��ʹ�ã����Ҳ���֪��������ʲô���ݽṹ��ʵ�ֵ�
 * �����о����֣�hashset��������hashmap��һ�����࣬���������е�ֵ������Ϊmap�е�key������
 * �����е�valueͳһΪһ��object���͵Ķ���
 * hashset����Ҫ����Ҳ����ͨ������hashmap�ĺ�����ʵ�ֵ�
 * �����˵һ��hashmap�ĵײ����ݽṹ��һ���������
 * set��������ʵ�ַ�ʽ 
 * 1.  TreeSetʹ���˶���������Ϊ���ݽṹ���ܹ�֧�ִ洢���ݵ����򣬵��������ϻ���һ��
 * 2.  LinkedSetʹ������������Ϊ���ݽṹ�������Ϻ�hashset���
 * 
 */
public class Design2 {
	private static Set<Integer>set;

    public Design2() {
     set=new HashSet<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        return set.add(val);
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        return set.remove(val);
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int result=0;
     int size=set.size();
     int index=(int) (Math.random()*size+1);
     for(int temp:set) {
    	 result++;
    	 if(result==index) {
    		 result=temp;
    		 break;
    	 }
     }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
