package com.imooc.ArraysAndString;

import java.util.HashMap;
/*
 * ��������������ڽ��ַ�������
 * ����˼��������û������ڵ�ԭ��ά��һ����ǰ��С�Ӵ�
 * ����������βָ�룬βָ�����������ҵ�����Ŀ���ַ����Ӵ�����ָ����������ʹ�Ӵ�������С
 * 
 * �㷨�ľ������̣�
 * 1.Ԥɨ��Ŀ���ַ��� t����ϣ��洢���ֵ��ַ��������
 * 2.���� Դ�ַ���s������ t ���ַ������ϣֵ��һ��ֱ����ǰ�Ӵ����������� t �е��ַ���
 * 3.�������Ӵ�����ָ������ 
 *    3.1���Բ��� t �е��ַ���
 *    3.2�� �Ӵ��г���ĳ�ַ��������� t �и��ַ��ĸ�����Ҳ�ɺ��Ը��ַ������� �ҵ�ĳ�Ӵ� AACD ��t = ACD�����һ��AҲ�ɺ��ԡ�
 *    3.3��¼���Ӵ�����������С�Ӵ���
 *    3.4ֱ�������� ���Ӵ�ȱʧĳ�ַ����� ACD -> CD
 * 4.�ظ�2��ֱ��������sβ
 */
public class ArraysAndString11 {
	/*
	 * �Լ�д�ģ�����hashmap�Ļ�������ʵ�֣���������Ķ���д��
	 */
	 public String minWindow(String s, String t) {
	       String result="";
	       if(s==null||t==null||t.length()>s.length()) {
	       return result;
	       }
	       HashMap<Character,Integer>target=new HashMap<Character,Integer>();
	       HashMap<Character,Integer>source=new HashMap<Character,Integer>();
	       int targetLength=t.length();
	       int sourceLength=s.length();
	       int found=0;
	       for(int i=0;i<targetLength;i++) {
	    	   if(target.containsKey(t.charAt(i))) {
	    		   target.put(t.charAt(i), target.get(t.charAt(i))+1);
	    	   }else {
	    		   target.put(t.charAt(i), 1);
	    	   }
	       }
	       int minLength=Integer.MAX_VALUE;
	       int start=0;
	       int begin=-1;
	       int end=0;
	       for(int i=0;i<sourceLength;i++) {
	    	 if(source.containsKey(s.charAt(i))) {
	    		 source.put(s.charAt(i),source.get(s.charAt(i))+1);
	    	 }else {
	    		 source.put(s.charAt(i), 1);
	    	 }
	    	 if(target.containsKey(s.charAt(i))&&(source.get(s.charAt(i))<=target.get(s.charAt(i)))) {
	    		 found++;
	    	 }
	    	 if(found==targetLength) {
	    		 while(start<i&&(!target.containsKey(s.charAt(start))||(source.get(s.charAt(start))>target.get(s.charAt(start))))) {
	    			 source.put(s.charAt(start), source.get(s.charAt(start))-1);
	    			 start++;
	    		 }
	    		 if(minLength>(i-start)) {
	    			 minLength=i-start;
	    			 begin=start;
	    			 end=i;
	    		 }
	    		 source.put(s.charAt(start), source.get(s.charAt(start))-1);
	    		 found--;
	    		 start++;
	    	 }
	       }
	       if(begin>=0)
	       result=s.substring(begin,end+1);
	       return result;
	    }
	
//	public String minWindow(String S, String T) {
//        int[] srcHash = new int[255];
//        // ��¼Ŀ���ַ���ÿ����ĸ���ִ���
//        for(int i = 0; i < T.length(); i++){
//            srcHash[T.charAt(i)]++;
//        }
//        int start = 0,i= 0;
//        // ���ڼ�¼������ÿ����ĸ���ִ��� 
//        int[] destHash = new int[255];
//        int found = 0;
//        int begin = -1, end = S.length(), minLength = S.length();
//        for(start = 0,i = 0; i < S.length(); i++){
//            // ÿ��һ���ַ������ĳ��ִ�����1
//            destHash[S.charAt(i)]++;
//            // �����1������ַ�������������Ŀ�괮�и��ַ������������ҵ���һ��ƥ���ַ�
//            if(destHash[S.charAt(i)] <= srcHash[S.charAt(i)]) found++;
//            // ����ҵ���ƥ���ַ�������Ŀ�괮���ȣ�˵���ҵ���һ������Ҫ����Ӵ�    
//            if(found == T.length()){
//                // ����ͷû�õĶ�������û����ָ���ַ����ִ���������Ŀ�괮�г��ֵĴ������������ǳ��ִ�������1
//                while(start < i && destHash[S.charAt(start)] > srcHash[S.charAt(start)]){
//                    destHash[S.charAt(start)]--;
//                    start++;
//                }
//                // ��ʱ��startָ����Ӵ���ͷ����ĸ���жϸ��Ӵ�����
//                if(i - start < minLength){
//                    minLength = i - start;
//                    begin = start;
//                    end = i;
//                }
//                // �ѿ�ͷ�����ƥ���ַ�����������ƥ���ַ�����1
//                destHash[S.charAt(start)]--;
//                found--;
//                // �Ӵ���ʼλ�ü�1�����ǿ�ʼ����һ���Ӵ���
//                start++;
//            }
//        }
//        // ���beginû���޸Ĺ������ؿ�
//        return begin == -1 ? "" : S.substring(begin,end + 1);
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ArraysAndString11 test=new ArraysAndString11();
String s="A";
String t="B";
String word=test.minWindow(s, t);
System.out.println(word);
	}

}
