package com.yi.String;

public class String8 {

	public String countAndSay(int n) {
	String s1="1";
	String s2="1";
	while((--n)>0) {
		s2=Trans(s1);
		s1=s2;
	}
		return s2;
	}

	public String Trans(String number) {
		String word="";
		int length=number.length();
		int count=1;
		int index=0;
		if(length==1) {
			word=count+number;
			return word;
		}
        while(index<length-1) {
        	if(number.charAt(index)==number.charAt(index+1)) {
        		count++;
        	}else {
        	word=word+count+number.charAt(index);
        	count=1;
        	}
        	index++;
        }
        word=word+count+number.charAt(index);
		return word;
	}
	public static void main(String[] args) {
		String8 test = new String8();
		System.out.println(test.countAndSay(5));
		//System.out.println(test.Trans("111221"));
		//System.out.println('a'=='a');
	}

}
