package com.yi.ArraysAndString;

public class ArraysAndString5 {
    public String longestPalindrome(String s) {
        if(s==null) {
        	return null;
        }
        if(s.length()<2) {
        	return s;
        }
 
        int start=0;
        int maxLength=1;
 
        return s.substring(start,maxLength );
    }
	public static void main(String[] args) {
	ArraysAndString5 test=new ArraysAndString5();
String s="babad";
test.longestPalindrome(s);
	}

}
