package com.yi.String;
/**
 * 
 * ����һ���ַ�������֤���Ƿ��ǻ��Ĵ���
 * ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд��
 *
 */
public class String5 {
    public boolean isPalindrome(String s) {
        boolean flag=true;
        StringBuffer buffer = new StringBuffer();
        char[]s2=s.toCharArray();
        //��ϴ�ַ���������Ҫ�����ݶ�����
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
