package com.yi.String;
/**
 * 
   * ���������ַ��� s �� t ��
   * ��дһ���������ж� t �Ƿ��� s ��һ����ĸ��λ�ʡ�
 *
 */
public class String4 {
    public boolean isAnagram(String s, String t) {
        boolean flag=true;
        if(s.length()!=t.length()) {
        	return false;
        }
        //����һ������Ϊ26�����飬����26����ĸ�ֱ���ֵĴ���
        int []word=new int[26];
        //��s�ַ�������ĸ����������ȥ
        for(int i=0;i<s.length();i++) {
        	word[s.charAt(i)-'a']++;
        }
        //��t�ַ�������ĸȫ�����������Ƴ�
        for(int i=0;i<t.length();i++) {
        	word[t.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++) {
        	if(word[i]!=0) {
        		flag=false;
        		break;
        	}
        }
        return flag;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
