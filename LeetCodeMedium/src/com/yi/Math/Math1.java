package com.yi.Math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Math1 {
	/*
	 * Ѱ�һ�������������ѵ�����ʲôʱ���˳�Ѱ�ң�
	 * ��Ϊֻ�����˶��ڻ������Ķ���  ��(���õ���ÿһλ�ϵ�ƽ���ͻ�ͣ����1��)
	 * �������ǻ������������Ϊ�趨�˳������Ļ�������ѭ����ȥ
	 * �ڸ�����ѧ�ϵ����ԣ������������ѭ���Ļ����ʹ�������ĳЩ������ϵ��ظ�
	 * ���ԾͿ���������һ���������������˳�������
	 * �������ظ���������Ͼ��˳���ϲ����ز��ǻ���������Ϣ
	 */
	public static boolean flag=false;
	 public boolean isHappy(int n) {
//		 boolean flag=false;
//	     findHappy(n, new ArrayList<ArrayList>(),flag);
	      findHappy(n, new ArrayList<ArrayList>());
	      return flag;
	    }
	 public static boolean  findHappy(int n,List<ArrayList> list) {
		 //����ҵ���ƽ����Ϊ1���������˵�����ڻ�����
		 if(n==1) {
			flag=true;
			return flag;
		 }
		 ArrayList<Integer> nums=new ArrayList<Integer>();
		 while(n>0) {
			 nums.add(n%10);
			 n=n/10;
		 }
		 //��ÿ�εõ��ĸ�λ����Ϣ��������������˳���ϲ�ͬ����ɵı�����������ϣ�
		 //��Ϊ�ڼ���ƽ���͵Ĺ����в���Ҫ����˳���ϵ���Ϣ
		 Collections.sort(nums);
		 //����ǰ����ϼ��뵽�����У�����������Ѿ�������������ˣ���˵��������ѭ�������ز��ǻ���������Ϣ
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
