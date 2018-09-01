package com.yi.Recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Recall4 {
//	/*
//	 * 这是我自己写的函数
//	 * 这个函数虽然能够实现功能，但是做了大量的重复计算，效率非常的低
//	 * 而且在回溯函数中，还进行了奇怪的排序函数，容易引起误解
//	 */
//	 public List<List<Integer>> subsets(int[] nums) {
//	       List<List<Integer>>result=new ArrayList<List<Integer>>(); 
//	       if(nums==null||nums.length==0) {
//	    	   return result;
//	       }
//	       List<Integer>temp=new ArrayList<Integer>();
//	       BackTracking(temp, nums, result);
//	       return result;
//	    }
//	 public static void BackTracking(List<Integer> temp,int []nums,List<List<Integer>>result) {
//		 int length=nums.length;
//		 int tempLength=temp.size();
//		 if(tempLength>length) {
//			 return ;
//		 }
//		 //Collections.sort(temp);
//		 //不能这么写，是因为在后面会要删除temp中的结点以达到回溯的效果，
//		 //如果进行了排序，删除的就不是我们想要删的结果，而永远是最大的那个结点，会导致一些情况不被递归到
//		 if(!result.contains(temp)) {
//			 List<Integer>tempResult=new ArrayList<Integer>();
//			 for(int a:temp) {
//				 tempResult.add(a);
//			 }
//			 //对拿到的结果进行排序，原因是因为之前有做过重复计算，会产生重复解
//			 //例读入的数组为1,2,3  从1开始找解 会寻找到1,2,3 而从2开始会寻找到 2,1,3 这两个结果是一样的
//			 //但是因为排列顺序不一样，所以contains函数并不能区分他们，他们都会被加到result结果中去
//			 //所以要对结果数组进行排序，让上面这种重复情况能够被contains函数所发现
//			 //而不把sort排序函数写在if条件外面，是因为也会引发错误
//			 Collections.sort(tempResult);
//			 if(!result.contains(tempResult)) {
//			 result.add(tempResult);
//			 }
//		 }
//		 for(int i=0;i<length;i++) {
//			 if(!temp.contains(nums[i])) {
//			 temp.add(nums[i]);
//			 BackTracking(temp, nums, result);
//			 temp.remove(temp.size()-1);
//			 }
//		 }
//	 }
	/*
	 * 这个函数是我参考网上的优秀函数写的
	 * 没有进行多余的计算，准确的算出了每一个子集
	 */
	public  List<List<Integer>> subsets(int[] nums) {
		 List<List<Integer>>result=new ArrayList<List<Integer>>(); 
	       if(nums==null||nums.length==0) {
	    	   return result;
	       }
	       List<Integer>temp=new ArrayList<Integer>();
	       BackTracking(temp, nums,0, result);
	       return result;
	 }
	 public static void BackTracking(List<Integer>temp,int[]nums,int index,List<List<Integer>>result) {
		 result.add(new ArrayList<Integer>(temp));
		 int length=nums.length;
		 //这个函数很巧妙的把回溯结束的判断，写在了for循环里，当for循环找到数组的最后一个元素是
		 //也就代表着这一层的深度遍历已经到底了
		 
		 for(int i=index;i<length;i++) {
			 temp.add(nums[i]);
			 //这里递归传递的参数要注意，要是i+1不应该是index+1
			 //i才是表明现在正在遍历的数组位置的下标
			 BackTracking(temp, nums, i+1, result);
			 temp.remove(temp.size()-1);
		 }
	 }
//	  public  List<List<Integer>> subsets(int[] nums) {
//	        List<List<Integer>> list = new ArrayList<>();//record the final answer
//	        List<Integer> tempList = new ArrayList<>();//record one of the subSet
//	        //Arrays.sort(nums);
//	        int len = nums.length;//prevent calculating the length in the function
//	        getSubset(list, tempList, 0, nums, len);//calling the backtrack function
//	        return list;
//	    }
//
//	    private static void getSubset(List<List<Integer>> list, List<Integer> tempList, int startLen, int[] nums, int len) {
//	        list.add(new ArrayList<>(tempList));//by calling itself to add tempList to the list
//	        for(int i = startLen ; i < len ; i++){
//	            tempList.add(nums[i]);// add element to tempList
//	            getSubset(list,tempList,i+1,nums,len);//calling itself
//	            tempList.remove(tempList.size()-1);//backtrack and remove the top element in tempList
//	        }
//	    }
	public static void main(String[] args) {
	Recall4 test=new Recall4();
	int[]nums= {1,2,3};
test.subsets(nums);
	}

}
