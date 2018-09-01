package com.yi.Recall;

import java.util.ArrayList;
import java.util.List;

public class Recall3 {
	//public static   List<List<Integer>>result=new ArrayList<List<Integer>>();
//public List<List<Integer>> permute(int[] nums) {
//        if(nums==null||nums.length==0) {
//        	return result;
//        }
//        int length=nums.length;
//        boolean []visit=new boolean[length];
//        List<Integer>currentResult=new ArrayList<Integer>();
//        backTracking(currentResult, 0,0, length, visit,nums);
//        return result;
//    }
/*
 * û����ǰ����һ�����ѻ�δ�ݹ���Ľ����Ϊ��������ݹ麯����
 * ��Ϊǰ����������String���������治��������ģ�String��final��������
 * ����ÿ�ζ������·����ڴ�ռ䣬Ҳ����ÿ���ݹ���̶߳�ӵ��һ���Լ�����ʱ���
 * �������õĲ���String������Ϊ��ʱ�������������еݹ���߳�ӵ�е���ͬһ�ݽ��
 * ������ֻ���ҵ�һ������޷���ȫȫ���Ľ���
 */
//public void backTracking(List<Integer>currentResult,int index,int currentLength,int length,boolean[]visit,int []nums) {
//	if(index<0||index>=length) {
//		return;
//	}
//	if(visit[index]) {
//		return ;
//	}
//	visit[index]=true;
//	currentResult.add(nums[index]);
//	currentLength++;
//	if(currentLength==length) {
//		result.add(currentResult);
//		return;
//	}
//	for(int i=0;i<length;i++) {
//		backTracking(currentResult, i, currentLength, length, visit, nums);
//	}
//}
	 public List<List<Integer>> permute(int[] nums) {
		 List<List<Integer>>result=new ArrayList<List<Integer>>();
		 if(nums==null||nums.length==0) {
	        	return result;
	        }
		 List<Integer>temp=new ArrayList<Integer>();
		 backTracking(nums, temp,result);
		 return result;
	    }
	 public static void backTracking(int []nums,List<Integer> temp, List<List<Integer>>result) {
		int length=nums.length;
		 if(length==temp.size()) {
			 //ÿ�������Ľ⻹����Ҫ���������ڴ�ռ�,�����ܱ�֤���Ĵ��ÿ���ⶼ�������ȥ��
			 //��Ȼ��Ž�ȥ��ֻ�Ƕ������ᵼ�����еĴ𰸶�ָ��ͬһ���ַ
			 List<Integer>tempresult=new ArrayList<Integer>();
		     for(int a:temp) {
		    	 tempresult.add(a);
		     }
			 result.add(tempresult);
			 return ;
		 }
		 for(int i=0;i<length;i++) {
			 if(temp.contains(nums[i])) {
				 continue;
			 }
			 temp.add(nums[i]);
			 backTracking(nums, temp,result);
			 //��Ϊ�������ʱ�������ڴ���ֻӵ��һ�ݣ������Ǹ����ݹ���̶߳�ӵ��һ�ݶ��Ե���ʱ����temp
			 //����Ҫ�ڵݹ�������˳�һ����Ϣ����֤�ָ����ݹ�ǰ��״̬���Ѵﵽ�����Ļ���
			 //���������Ѿ��ҵ�һ����Ϊ 1,2,3 ����temp�д�ŵľ��� 1,2,3 ������   
			 //�����ݵ� 2����ʱ�� temp����ϢӦ��Ϊ 1,2 ����Ϊ����һ�ݹ�����ڴ棬
			 //���� temp ����֮ǰ�ҵ��� 1,2,3,����Ҫ��Ϊȥɾ������Ԫ�أ�����������Ļ���
			 temp.remove(temp.size()-1);
		 }
	 }
	 /*
	  * ����������һ��Ч�ʸ��ߵĽ���������Ԫ�صķ���
	  * �Ҷ�����������������ԭ��
	  */
	  public List<List<Integer>> permute1(int[] nums) {
		  List<List<Integer>>res=new ArrayList<List<Integer>>();
	        int len = nums.length;
	        if (len==0||nums==null)  return res;

	        // ����ǰ��Ԫ�ؽ����İ취��dfs����
	        exchange(nums, 0, len,res);
	        return res;
	    }

	    public void exchange(int[] nums, int i, int len,List<List<Integer>> res) {
	        // ����ǰ����ӵ��������
	        if(i==len-1) {
	            List<Integer> list = new ArrayList<>();
	            for (int j=0; j<len; j++){
	                list.add(nums[j]);
	            }
	            res.add(list);
	            return ;
	        }
	        // ����ǰλ�õ��������������������������
	        for (int j=i; j<len; j++) {
	            swap(nums, i, j);
	            exchange(nums, i+1, len,res);
	            swap(nums, i, j);
	        }
	    }

	    public void swap(int[] nums, int i, int j) {
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
	public static void main(String[] args) {
		int []nums= {1,2,3};
		Recall3 test=new Recall3();
		test.permute1(nums);

	}

}
