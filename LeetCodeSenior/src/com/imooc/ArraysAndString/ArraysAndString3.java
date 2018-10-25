package com.imooc.ArraysAndString;

import java.util.HashMap;
import java.util.Map;
/*
 * 本题的做法如下
 * 对于四个数组一分为2，对前两个数组的数求和，求出他们加起来的各种可能的和，保存到一个map中去
 * 
 * 例          数组1    1    2     3
 *      数组2     -1   -2   -3
 *      则map中结果为       -2=1   -1=2  0=3  1=2  2=1
 *      
 * 然后再去遍历后两个数组，寻找有没有后面两个数组加起来和为前面map中key的相反数的情况，如果有
 * 就在结果中加上所有可行的结果，并继续遍历     
 */
public class ArraysAndString3 {
	//自己根据网上指南理解写的，不能通过
	//找到我这个代码出错的问题了，我从map中去取匹配的结果后，对结果只做了加一运算，但是map中的对应值可能并不是1
	//而有可能大于1，即代表有多种数字组合能够组合成map中key的值，
	//所有只有把result++改为result+=map.get(key)就对了
	 public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
	        if(A==null||B==null||C==null||D==null||A.length==0) {
	        	return 0;
	        }
	        int result=0;
	        int length=A.length;
	       Map<Integer,Integer>map=new HashMap<Integer,Integer>();
	       for(int i=0;i<length;i++) {
	    	   for(int j=0;j<length;j++) {
	    		   if(map.containsKey(A[i]+B[j])) {
	    			   map.put(A[i]+B[j], map.get(A[i]+B[j])+1);
	    		   }else {
	    			   map.put(A[i]+B[j], 1);
	    		   }
	    	   }
	       }
	       int sum=0;
	       for(int i=0;i<length;i++) {
	    	   for(int j=0;j<length;j++) {
	    		   sum=C[i]+D[j];
	    		   sum=-sum;
	    		   if(map.containsKey(sum)) {
	    			   result+=map.get(sum);
//	    			   map.put(sum, map.get(sum)-1);
	    		   }
	    	   }
	       }
	        return result;
	    }
	//网上的源码
//	 public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
//         HashMap<Integer,Integer> map = new HashMap<>();
//
//         int count = 0;
//         for(int i=0;i<A.length;i++){
//             for(int j=0;j<B.length;j++){
//                 map.put(A[i]+B[j],map.getOrDefault(A[i]+B[j],0)+1);
//             }
//         }
//
//         for(int i=0;i<C.length;i++){
//             for(int j=0;j<D.length;j++){
//                 count+= map.getOrDefault(-C[i]-D[j],0);
//             }
//         }
//         return count;
//     }
	public static void main(String[] args) {
	int[] a= {-1,-1};
	int[] b= {-1,1};
	int[] c= {-1,1};
	int[] d= {-1,1};
	ArraysAndString3 test=new ArraysAndString3();
	int i=test.fourSumCount(a, b, c, d);
	System.out.println(i);
	}

}
