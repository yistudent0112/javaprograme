package com.yi.String;
/**
 * 
 * 请编写一个函数，其功能是将输入的字符串反转过来。
 *
 */
public class String1 {
	
   public String reverseString(String s) {
	   Character s1=null;
	   char []s2=s.toCharArray();
	   for(int i=0;i<s2.length/2;i++) {
		   s1=s2[s2.length-1-i];
		   s2[s2.length-1-i]=s2[i];
		   s2[i]=s1;
	   }
        return new String(s2);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
