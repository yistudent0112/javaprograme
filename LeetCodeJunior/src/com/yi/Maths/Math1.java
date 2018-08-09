package com.yi.Maths;

import java.util.ArrayList;
import java.util.List;

public class Math1 {
	  public List<String> fizzBuzz(int n) {
		  if(n<1) {
			  return null;
		  }
	      List<String> result=new ArrayList<String>();  
		  for(int i=1;i<n+1;i++) {
	        	if(i%3==0&&i%5==0) {
	        		result.add("FizzBuzz");
	        	}else if(i%3==0) {
	        		result.add("Fizz");
	        	}else if(i%5==0) {
	        		result.add("Buzz");
	        	}else {
	        		result.add(String.valueOf(i));
	        	}
	        		
	        }
		  return result;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
