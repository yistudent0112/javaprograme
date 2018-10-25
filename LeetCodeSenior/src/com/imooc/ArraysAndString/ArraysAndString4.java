package com.imooc.ArraysAndString;

public class ArraysAndString4 {
	/*
	 * ������Ҳ鿴�����ѵ���ʾ���������ǵ�˼·д���˳���
	 * �뷨��ʵ�ǳ��ļ򵥣����Ǵ�������������м���
	 * ����߸߶Ⱥ��ұ߸߶������������ĸ������Ƚ�С�����ƶ��ĸ�����
	 * ��ÿһ���ƶ�������ʱ�򣬼��㵱ǰ�ܷ��µ�ˮ�������
	 * ����֮ǰ�ܹ�����ˮ����������ֵ�Ƚϣ�����������ˮ�����ֵ
	 * ����߶��ߵ����Ҹ߶��غϵ�ʱ�򣬾ͽ���ѭ����
	 * ����֮ǰ����������ˮ�����ֵ
	 */
	 public int maxArea(int[] height) {
	     if(height==null||height.length==0||height.length==1) {
	    	 return 0;
	     }
	     int result=0;
	     int length=height.length;
	     int leftIndex=0;
	     int rightIndex=length-1;
	     int left=height[leftIndex];
	     int right=height[rightIndex];
	     int shortLevel=0;
	     while(leftIndex<rightIndex) {
	    	 left=height[leftIndex];
	    	 right=height[rightIndex];
	    	 shortLevel=Math.min(left, right);
	    	 result=Math.max(result, shortLevel*(rightIndex-leftIndex));
	    	if(left<right) {
	    		leftIndex++;
	    	}else {
	    	    rightIndex--;
	    	}
	    	
	     }
	     return result;
	    }
	public static void main(String[] args) {
		ArraysAndString4 test=new ArraysAndString4();
		int []height= {1,8,6,2,5,4,8,3,7};
		int result=test.maxArea(height);
		System.out.println(result);
	}

}
