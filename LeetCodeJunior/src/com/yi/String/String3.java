package com.yi.String;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * ����һ���ַ����� �ҵ����ĵ�һ�����ظ����ַ������������������� ��������ڣ��򷵻� -1��
 *
 */
public class String3 {
	public int firstUniqChar(String s) {
		int index = -1;
		Map<Character, Integer> Unique = new LinkedHashMap<Character, Integer>();
		for(int i=0;i<s.length();i++) {
		     if(!Unique.containsKey(s.charAt(i))) {
		    	 Unique.put(s.charAt(i), 1);
		     }else {
		    	 Unique.put(s.charAt(i), Unique.get(
		    			s.charAt(i))+1);
		     }
		}
	   for(Entry<Character, Integer> en: Unique.entrySet()){
	        if(en.getValue()==1) {
	        	index=s.indexOf(en.getKey().toString());
	        	break;
	        }     	
	    }
		return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
