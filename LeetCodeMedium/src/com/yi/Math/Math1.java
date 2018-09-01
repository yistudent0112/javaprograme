package com.yi.Math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Math1 {
	/*
	 * 寻找欢乐数，这题的难点在于什么时候退出寻找，
	 * 因为只给出了对于欢乐数的定义  即(最后得到的每一位上的平方和会停留在1上)
	 * 而其他非欢乐数如果不人为设定退出条件的话会无限循环下去
	 * 在根据数学上的特性，如果存在无限循环的话，就代表会出现某些数字组合的重复
	 * 所以就可以依据这一特性来做函数的退出条件，
	 * 当出现重复的数字组合就退出组合并返回不是欢乐数的信息
	 */
	public static boolean flag=false;
	 public boolean isHappy(int n) {
//		 boolean flag=false;
//	     findHappy(n, new ArrayList<ArrayList>(),flag);
	      findHappy(n, new ArrayList<ArrayList>());
	      return flag;
	    }
	 public static boolean  findHappy(int n,List<ArrayList> list) {
		 //如果找到了平方和为1的情况，则说明存在欢乐数
		 if(n==1) {
			flag=true;
			return flag;
		 }
		 ArrayList<Integer> nums=new ArrayList<Integer>();
		 while(n>0) {
			 nums.add(n%10);
			 n=n/10;
		 }
		 //对每次得到的各位数信息进行排序，来避免顺序上不同所造成的保留了这种组合，
		 //因为在计算平方和的过程中不需要数字顺序上的信息
		 Collections.sort(nums);
		 //将当前的组合加入到集合中，如果集合中已经存有这种组合了，则说明出来了循环，返回不是欢乐数的信息
		 if(list.contains(nums)) {
			 flag=false;
			 return flag;
		 }else {
			 list.add(nums);
		 }
		 int length=nums.size();
		 int sum=0;
		 for(int i=0;i<length;i++) {
			 sum+=nums.get(i)*nums.get(i);
		 }
		 findHappy(sum, list);
		return flag;
	 }
	public static void main(String[] args) {
		Math1 test=new Math1();
		System.out.println(test.isHappy(4));

	}

}
