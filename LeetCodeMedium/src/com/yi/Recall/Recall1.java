package com.yi.Recall;

import java.util.ArrayList;
import java.util.List;
/*
 * 这道题主要利用了回溯算法来解决问题，
 * 回溯算法就是对一个复杂问题(即每一层都有多种状况，有多层的问题)的多种情况进行一次次的深度搜素，
 * 如果出现了不满足答案的情况，就退回上一次的搜索结果，重新开始搜素
 * 有点像对于图的深度遍历，找到一个节点下面没有子节点了，就往上退，一直退到能找到第二条路的情况
 * 我也是刚刚开始学习，对于算法的思想也不是特别了解
 * 2018/8/19
 */
public class Recall1 {
	//电话数字对应的字母字典，从0~9对应的字典
	 static String []numbers= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	 public List<String> letterCombinations(String digits) {
		 //用来存放所有组合结果的list
	        List<String>result=new ArrayList<String>();
	        if(digits==null||digits.length()==0) {
	        	return result;
	        }
	        backTracking(digits, result, 0, "");
	        return result;
	    }
	 //递归调用函数，也是回溯算法的实现
	 public static void backTracking(String digits,List<String> result,int flag,String s) {
		//函数的退出条件，如果找到的结果长度已经满足要求了，就把结果添加进list中
		 //如果找到的结果长度还不够的话，就继续递归去寻找结果
		 if(flag>=digits.length()) {
			 result.add(s);
			 return ;
		 }
		 //从字典中拿出当前数字所对应的字母，并把它们作为待寻找的目标
		 //等于找到这一层可能的各种方向的路径
		 String chars=numbers[digits.charAt(flag)-'0'];
		 //通过for循环把各种方向的路径都尝试一遍
		 for(int i=0;i<chars.length();i++) {
			 //一个个的把待寻找的目标的各种可能给寻找一遍
			 //找到一个路径，尝试一种可能，并开启新的一轮递归
			 backTracking(digits, result, flag+1, s+chars.charAt(i));
		 }
	 }
	public static void main(String[] args) {
		Recall1 test=new Recall1();
		test.letterCombinations("2345");

	}

}
