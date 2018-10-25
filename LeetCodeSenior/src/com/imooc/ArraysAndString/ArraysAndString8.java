package com.imooc.ArraysAndString;




public class ArraysAndString8 {
	/*
	 * �����Ŀ��Ҫ������Ҫʹ��O(1)�ռ临�ӶȺ�O(n���η�)��ʱ�临�Ӷ�
	 * ��ֱ��ʹ��һ��set�������ƽ⣬��������Ŀ��Ҫ��֮���Ϸ������������������
	 */
//	 public int findDuplicate(int[] nums) {
//	        if(nums==null||nums.length==0) {
//	        	return 0;
//	        }
//	        int result=0;
//	        int length=nums.length;
//	       Set<Integer>set=new HashSet<>();
//	        for(int i=0;i<length;i++) {
//	        	if(set.contains(nums[i])) {
//	        		result=nums[i];
//	        		break;
//	        	}else {
//	        	   set.add(nums[i]);
//	        	}
//	        }
//	        return result;
//	    }
	/*
	 * �����������������������Ķ���
	 * ��Ϊ�������Ϊn+1��������ֻ�����1-n��Χ�ڵ�����
	 * ��   ���鳤��Ϊ10 ��9+1
	 *  �����������ֻ�����1-9�е����� ��������ַ�Χ�������
	 * ��������һ�����ƶ��ֲ��ҵĺ�����ʵ�ֹ���
	 * ����ͳ�Ƶ�����ĳһ��Χ�ڵ����֣�
	 * ��������Χ�ڵ����ֲ���������ֵ(����Χ�Ŀ��)
	 * �ͱ����������Χ�ڴ����ظ�������Ȼ��ʹ�ö��ֲ��ҵķ�ʽ�������������еݹ���Ҿ�����
	 * 
	 * �� ���������Ϊ  1 2 2 2 3 4 5 6 7 �������ĳ���Ϊ9
	 * �����������Ӧ�ó��ֵ�����Ϊ1-8
	 * Ȼ����ݶ��ֲ��ҵĶ��壬�ҵ�1-8�е��м���4
	 * Ȼ�����ȥ���ж��ٸ����м���4С����  ���Ϊ6������������Ķ�����Ӧ��Ϊ4
	 * ˵����1-4�ķ�Χ�ڴ����ظ�������
	 * 
	 * ֮��͵ݹ���ã������м������ҵķ�ΧΪ1-4�������µ��м���2
	 * Ȼ�����ȥ���ж��ٸ����м���2С����  ���Ϊ4�� ���Ӧ��Ϊ2
	 * ˵����1-2�ķ�Χ�ڴ����ظ�������
	 * 
	 * ͨ�����ϵĵݹ飬֪���м����ķ�Χ���½籮�滻�ˣ����ܹ��ҵ��ظ�������
	 */
//	 public int findDuplicate(int[] nums) {
//	        int high=nums.length-1;
//	        int low=0;  
//	        while(high>low){
//	        	int mid=(high+low)/2;
//	        	int count=0;
//	        	for(int i=0;i<nums.length;i++){
//	        		if(nums[i]<=mid)
//	        			count++;
//	        	}
//	        	if(count>mid)
//	        		high=mid;
//	        	else
//	        		low=mid+1;
//	        }
//	        return low;
//	    }
	 public int findDuplicate(int[] nums) {
		 if(nums==null||nums.length==0) {
			 return 0;
		 }
		 int low=0;
		 int length=nums.length;
		int high=length-1;
		int middle=high;
		int temp=0;
		while(low<high) {
			temp=0;
			middle=(low+high)/2;
			for(int i=0;i<length;i++) {
				if(nums[i]<=middle) {
					temp++;
				}
			}
			if(temp>middle) {
				high=middle;
			}else {
				low=middle+1;
			}
		}
		 return low;
	 }
	public static void main(String[] args) {
		ArraysAndString8 test=new ArraysAndString8();
		int []nums= {1,5,4,2,3,4};
		test.findDuplicate(nums);
	}

}
