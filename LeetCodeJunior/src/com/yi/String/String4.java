package com.yi.String;
/**
 * 
   * 给定两个字符串 s 和 t ，
   * 编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 */
public class String4 {
    public boolean isAnagram(String s, String t) {
        boolean flag=true;
        if(s.length()!=t.length()) {
        	return false;
        }
        //定义一个长度为26的数组，保存26个字母分别出现的次数
        int []word=new int[26];
        //将s字符串的字母移入数组中去
        for(int i=0;i<s.length();i++) {
        	word[s.charAt(i)-'a']++;
        }
        //将t字符串的字母全部从数组中移除
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
