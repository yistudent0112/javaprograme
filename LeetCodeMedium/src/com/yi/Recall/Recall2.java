package com.yi.Recall;

import java.util.ArrayList;
import java.util.List;

public class Recall2 {
	/*
	 * ������ǰһ�����ݵ���Ŀ˼����һ����
	 * �����ڵݹ��е���ʱ����ʹ�õ�string������Ҳʡȥ���ֶ������ڴ�ռ���鷳
	 * ������Ҫ�Ƕ���һ������𰸣����˵����
	 * ���Ƕ����������������˵�������ŵ��������ܹ����������ŵ�����
	 * ��������������������Ӧ��������ȥ������������ݵ���һ��ȥѰ�Ҵ�
	 * ���Ǽ�ȥ�����ܵĴ𰸣�Ҳ����Ϊ��֦
	 */
	private static String []Parenthesis= {"(",")"};
	 public List<String> generateParenthesis(int n) {
	        List<String> result=new ArrayList<String>();
	        if(n<1) {
	        	return result;
	        }
	        backTracking(n, 0, 0, result, "");
	        return result;
	    }
	 public static void backTracking(int length,int left,int right,List<String> result,String temp) {
		 if(left==length&&right==length) {
			 result.add(temp);
			 return;
		 }
		 //�����Ŷ�Ĵ����������������
		 if(left<right) {
			 return ;
		 }
		 if(right<length) {
			 backTracking(length, left, right+1, result, temp+Parenthesis[1]);
		 }
		 if(left<length) {
			 backTracking(length, left+1, right, result, temp+Parenthesis[0]);
		 }
	 }
	public static void main(String[] args) {
		Recall2 test=new Recall2();
		test.generateParenthesis(3);

	}

}
