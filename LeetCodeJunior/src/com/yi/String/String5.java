package com.yi.String;
/**
 * 
 * 给定一个字符串，验证它是否是回文串，
 * 只考虑字母和数字字符，可以忽略字母的大小写。
 *
 */
public class String5 {
    public boolean isPalindrome(String s) {
        boolean flag=true;
        StringBuffer buffer = new StringBuffer();
        char[]s2=s.toCharArray();
        //清洗字符串，将需要的内容读进来
        for(int i=0;i<s.length();i++) {
        	if((s2[i]>='a'&&s2[i]<='z')||(s2[i]>='A'&&s2[i]<='Z')
        			||(s2[i]>='0'&&s2[i]<='9')) {
        		buffer.append(s2[i]);
        	}
        }
        String s1=buffer.toString().toLowerCase();
        for(int i=0;i<s1.length()/2;i++) {
        	if(s1.charAt(i)!=s1.charAt(s1.length()-1-i)) {
        		flag=false;
        		break;
        	}
        }
        return flag;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String5 test=new String5();
boolean temp=test.isPalindrome("A man, a plan, a canal: Panama");
System.out.println(temp);
	}

}
