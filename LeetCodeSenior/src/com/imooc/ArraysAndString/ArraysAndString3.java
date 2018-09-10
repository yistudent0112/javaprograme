package com.imooc.ArraysAndString;

import java.util.HashMap;
import java.util.Map;

public class ArraysAndString3 {
	//自己根据网上指南理解写的，不能通过
//	 public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
//	        if(A==null||B==null||C==null||D==null||A.length==0) {
//	        	return 0;
//	        }
//	        int result=0;
//	        int length=A.length;
//	       Map<Integer,Integer>map=new HashMap<Integer,Integer>();
//	       for(int i=0;i<length;i++) {
//	    	   for(int j=0;j<length;j++) {
//	    		   if(map.containsKey(A[i]+B[j])) {
//	    			   map.put(A[i]+B[j], map.get(A[i]+B[j])+1);
//	    		   }else {
//	    			   map.put(A[i]+B[j], 1);
//	    		   }
//	    	   }
//	       }
//	       int sum=0;
//	       for(int i=0;i<length;i++) {
//	    	   for(int j=0;j<length;j++) {
//	    		   sum=C[i]+D[j];
//	    		   sum=-sum;
//	    		   if(map.containsKey(sum)) {
//	    			   result++;
////	    			   map.put(sum, map.get(sum)-1);
//	    		   }
//	    	   }
//	       }
//	        return result;
//	    }
	//网上的源码
	 public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
         HashMap<Integer,Integer> map = new HashMap<>();

         int count = 0;
         for(int i=0;i<A.length;i++){
             for(int j=0;j<B.length;j++){
                 map.put(A[i]+B[j],map.getOrDefault(A[i]+B[j],0)+1);
             }
         }

         for(int i=0;i<C.length;i++){
             for(int j=0;j<D.length;j++){
                 count+= map.getOrDefault(-C[i]-D[j],0);
             }
         }
         return count;
     }
	public static void main(String[] args) {
	int[] a= {-1,-1};
	int[] b= {-1,1};
	int[] c= {-1,1};
	int[] d= {-1,1};
	ArraysAndString3 test=new ArraysAndString3();
	test.fourSumCount(a, b, c, d);
	}

}
