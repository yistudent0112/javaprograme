package com.yi.String;

public class String7 {
	  public int strStr(String haystack, String needle) {
	        int index=-1;
	        if(needle.equals("")) {
	        	index=0;
	        	return index;
	        }
	       if(haystack.contains(needle)) {
	    	   if(haystack.length()==needle.length()) {
	    		   index=0;
	    		   return index;
	    	   }
	    	   String result[]=haystack.split(needle);
	    	   if(result.length==0) {
	    		   index=0;
	    		   return index;
	    	   }
	    	   index=result[0].length();
	       }
	        return index;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String7 test=new String7();
test.strStr("aaa", "a");
	}

}
