package com.yi.Math;

public class Math3 {
	/*
	 * 这题根据excel对应列的字母打印对应数字不难
	 * 主要是要确定每一个字母所对应的基数    
	 * 通过他们字母在字符串中所占的位置来确定他们基数的大小
	 * 例     A        B        C
	 *    ↑        ↑        ↑
	 * 基数为26的2次方  1次方      0次方即(1)
	 * 确定了基数，寻找解就很简单了
	 */
	 public int titleToNumber(String s) {
	        if(s==null||s.length()==0){
	            return 0;
	        }
	        int length=s.length();
	        int result=0;
	        int base=0;
	        for(int i=length-1;i>=0;i--) {
	        	base=(int)Math.pow(26, i);
	        	result+=base*(s.charAt(length-1-i)+1-'A');
	        }
	        return result;
	    }
	public static void main(String[] args) {
	Math3 test=new Math3();
	test.titleToNumber("AZ");

	}

}
