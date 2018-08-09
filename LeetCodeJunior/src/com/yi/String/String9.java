package com.yi.String;

import java.util.List;

public class String9 {
    public String longestCommonPrefix(String[] strs) {
    	if(strs.length==0) {
    		return "";
    	}	if(strs.length==0) {
    		return "";
    	}
        StringBuilder sb=new StringBuilder();
        int length=strs[0].length();
        boolean same=true;
       for(int i=1;i<strs.length;i++) {
    	   if(strs[i].length()<length) {
    		   length=strs[i].length();
    	   }
       }
       for(int i=0;i<length;i++) {
    	   for(int j=0;j<strs.length-1;j++) {
    		   if(strs[j].charAt(i)!=strs[j+1].charAt(i)) {
    			   same=false;
    			   break;
    		   }
    	   }
    	   if(same) {
    		   sb.append(strs[0].charAt(i));
    	   }
    	   else {
    		   break;
    	   }
       }
        return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//System.out.println(new StringBuilder().toString().length());
//System.out.println("".length());
	}

}
