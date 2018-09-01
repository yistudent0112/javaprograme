package com.yi.Recall;

import java.util.ArrayList;
import java.util.List;

public class Recall2 {
	/*
	 * 这道题和前一道回溯的题目思想是一样的
	 * 而且在递归中的临时变量使用的string，所以也省去了手动分配内存空间的麻烦
	 * 这题主要是多了一个错误答案，回退的情况
	 * 就是对于括号排列情况来说，右括号的数量不能够多余左括号的数量
	 * 如果出现了这种情况，就应该立即舍去这种情况，回溯到上一层去寻找答案
	 * 就是减去不可能的答案，也被称为剪枝
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
		 //右括号多的错误情况，立即回溯
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
