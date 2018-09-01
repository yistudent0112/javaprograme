package com.yi.Design;

import java.util.HashSet;
import java.util.Set;
/*
 * 本题的要求是自己设计一个set类型的数据结构
 * 虽然set集合类型我在日常中会经常使用，但我并不知道他是有什么数据结构来实现的
 * 经过研究发现，hashset基本算是hashmap的一个子类，集合内所有的值被保存为map中的key来保存
 * 而所有的value统一为一个object类型的对象。
 * hashset的主要功能也都是通过调用hashmap的函数来实现的
 * 这里多说一句hashmap的底层数据结构是一个结点数组
 * set还有两种实现方式 
 * 1.  TreeSet使用了二叉树来作为数据结构，能够支持存储内容的排序，但是性能上会慢一点
 * 2.  LinkedSet使用了链表来作为数据结构，性能上和hashset差不多
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
