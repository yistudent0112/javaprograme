package com.imooc.ArraysAndString;

import java.util.HashMap;
/*
 * 对于这道滑动窗口解字符串问题
 * 核心思想就是利用滑动窗口的原理，维持一个当前最小子串
 * 它利用了首尾指针，尾指针右移扩张找到包含目标字符的子串，首指针右移收缩使子串长度最小
 * 
 * 算法的具体流程：
 * 1.预扫描目标字符串 t，哈希表存储出现的字符及其个数
 * 2.遍历 源字符串s，遇到 t 中字符，其哈希值减一，直到当前子串包含了所有 t 中的字符。
 * 3.收缩该子串，首指针右移 
 *    3.1忽略不在 t 中的字符。
 *    3.2当 子串中出现某字符次数多于 t 中该字符的个数，也可忽略该字符。比如 找到某子串 AACD ，t = ACD，则第一个A也可忽略。
 *    3.3记录该子串，并更新最小子串。
 *    3.4直到右移至 该子串缺失某字符。如 ACD -> CD
 * 4.重复2，直到遍历到s尾
 */
public class ArraysAndString11 {
	/*
	 * 自己写的，基于hashmap的滑动窗口实现，根据上面的定义写的
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
//        // 记录目标字符串每个字母出现次数
//        for(int i = 0; i < T.length(); i++){
//            srcHash[T.charAt(i)]++;
//        }
//        int start = 0,i= 0;
//        // 用于记录窗口内每个字母出现次数 
//        int[] destHash = new int[255];
//        int found = 0;
//        int begin = -1, end = S.length(), minLength = S.length();
//        for(start = 0,i = 0; i < S.length(); i++){
//            // 每来一个字符给它的出现次数加1
//            destHash[S.charAt(i)]++;
//            // 如果加1后这个字符的数量不超过目标串中该字符的数量，则找到了一个匹配字符
//            if(destHash[S.charAt(i)] <= srcHash[S.charAt(i)]) found++;
//            // 如果找到的匹配字符数等于目标串长度，说明找到了一个符合要求的子串    
//            if(found == T.length()){
//                // 将开头没用的都跳过，没用是指该字符出现次数超过了目标串中出现的次数，并把它们出现次数都减1
//                while(start < i && destHash[S.charAt(start)] > srcHash[S.charAt(start)]){
//                    destHash[S.charAt(start)]--;
//                    start++;
//                }
//                // 这时候start指向该子串开头的字母，判断该子串长度
//                if(i - start < minLength){
//                    minLength = i - start;
//                    begin = start;
//                    end = i;
//                }
//                // 把开头的这个匹配字符跳过，并将匹配字符数减1
//                destHash[S.charAt(start)]--;
//                found--;
//                // 子串起始位置加1，我们开始看下一个子串了
//                start++;
//            }
//        }
//        // 如果begin没有修改过，返回空
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
