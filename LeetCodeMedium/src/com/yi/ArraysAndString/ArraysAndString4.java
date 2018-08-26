package com.yi.ArraysAndString;


import java.util.HashMap;

import java.util.Map;


public class ArraysAndString4 {
	 public int lengthOfLongestSubstring(String s) {
	        if(s==null||s.length()==0) {
	        	return 0;
	        }
	        if(s.length()==1) {
	        	return 1;
	        }
	        int length=s.length();
	        int result=0;
	        int left=0;
	        int right=0;
	        Map<Character,Integer>words=new HashMap<Character,Integer>();
	        for(int i=0;i<length;i++) {
	        	if(!words.containsKey(s.charAt(i))) {
	        		words.put(s.charAt(i), i);
	        		right++;
	        	}else {
	        		left=words.get(s.charAt(i));
	        	}
	        	result=Math.max(result, right-left);
	        }
	        return result;
	    }
	public static void main(String[] args) {
		ArraysAndString4 test=new ArraysAndString4();
		String word="pwwkew";
		test.lengthOfLongestSubstring(word);

	}

}
