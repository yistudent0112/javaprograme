package com.yi.Recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Recall4 {
//	/*
//	 * �������Լ�д�ĺ���
//	 * ���������Ȼ�ܹ�ʵ�ֹ��ܣ��������˴������ظ����㣬Ч�ʷǳ��ĵ�
//	 * �����ڻ��ݺ����У�����������ֵ��������������������
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
//		 //������ôд������Ϊ�ں����Ҫɾ��temp�еĽ���Դﵽ���ݵ�Ч����
//		 //�������������ɾ���ľͲ���������Ҫɾ�Ľ��������Զ�������Ǹ���㣬�ᵼ��һЩ��������ݹ鵽
//		 if(!result.contains(temp)) {
//			 List<Integer>tempResult=new ArrayList<Integer>();
//			 for(int a:temp) {
//				 tempResult.add(a);
//			 }
//			 //���õ��Ľ����������ԭ������Ϊ֮ǰ�������ظ����㣬������ظ���
//			 //�����������Ϊ1,2,3  ��1��ʼ�ҽ� ��Ѱ�ҵ�1,2,3 ����2��ʼ��Ѱ�ҵ� 2,1,3 �����������һ����
//			 //������Ϊ����˳��һ��������contains�����������������ǣ����Ƕ��ᱻ�ӵ�result�����ȥ
//			 //����Ҫ�Խ������������������������ظ�����ܹ���contains����������
//			 //������sort������д��if�������棬����ΪҲ����������
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
	 * ����������Ҳο����ϵ����㺯��д��
	 * û�н��ж���ļ��㣬׼ȷ�������ÿһ���Ӽ�
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
		 //�������������İѻ��ݽ������жϣ�д����forѭ�����forѭ���ҵ���������һ��Ԫ����
		 //Ҳ�ʹ�������һ�����ȱ����Ѿ�������
		 
		 for(int i=index;i<length;i++) {
			 temp.add(nums[i]);
			 //����ݹ鴫�ݵĲ���Ҫע�⣬Ҫ��i+1��Ӧ����index+1
			 //i���Ǳ����������ڱ���������λ�õ��±�
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
