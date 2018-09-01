package com.yi.SortAndSearch;
/*
 * Ѱ��һ���ߵ����ֵ��±꣬�����Ҳ���� 
 * �ߵ����Ķ����������������ǰ��λ�õ�����Ҫ��  ��  1 2 3 4 1 �� 4 ���Ǹߵ���
 * �ҵ������������øߵ�����������壬����������Ѱ�ң���һ����ǰ��λ�ö��������Ȼ�󷵻������±�
 * Ȼ��Ҫ����һ������������ͱ������鳤��Ϊ2��ʱ�򣬾Ͳ���������ı�������Ĳ����ˣ�Ҫ�����ж�
 * ���о������鱾���ǵ������ߵݼ��ģ��������Ҳ����𰸵ģ�
 * Ҫ���ݸ����ĸ������� �����[-1]��[length]�Ĵ�СΪ����С ���ж�
 * 
 * ���������������ķ�ʽ�ٶȲ����죬���ǿ���������ܵ�
 */
public class SortAndSearch4 {
//	 public int findPeakElement(int[] nums) {
//	      int length=nums.length;
//	      //������ĳ���Ϊ2ʱ�������⴦��
//	      if(length==2) {
//	    	 if(nums[0]>nums[1]) {
//	    		 return 0;
//	    	 }else {
//	    		 return 1;
//	    	 }
//	      }
//	      int result=0;
//	      //��־����Ϊ������״̬
//	      boolean increase=true;
//	      for(int i=0;i<length-2;i++) {
//	    	  //�����������ߵ�������������������������±�
//	    	  if((nums[i]<nums[i+1])&&(nums[i+1]>nums[i+2])) {
//	    		  result=i+1;
//	    		  break;	
//	    	  }if(nums[i]>nums[i+1]) {
//	    		  increase=false;
//	    	  }
//	      }
//	      //������������������������һ��λ��
//	      if(increase&&result==0) {
//	    	  result=length-1;
//	      }
//	      return result;      
//	    }
	/*
	 * �������Ż���ʽ��ʹ�ö��ֲ�����Ѱ�Ҹߵ������ܹ�ʹ�ö��ֲ��ҵ�ԭ������
	 * ����м�Ԫ�ش��������ڵĺ���Ԫ�أ����м�Ԫ����ࣨ�����м�Ԫ�أ���Ȼ����һ���ֲ����ֵ��
	 * �������м�Ԫ�صĺ󲿳����˹յ㣬ǰ���Ϳ϶����н�
	 * ����м�Ԫ��С�������ڵĺ���Ԫ�أ����м�Ԫ���Ҳ��Ȼ����һ���ֲ����ֵ
	 * �����м�Ԫ�ص�ǰ���йյ㣬�󲿾ͻ��н�
	 */
	 public int findPeakElement(int[] nums) {
		 int length=nums.length;
		 if(length==1) {
			 return 0;
		 }
		 if(nums[0]>nums[1]) {
			 return 0;
		 }
		 if(nums[length-2]<nums[length-1]) {
			 return length-1;
		 }
		 int index=0;
		 int left=0;
		 int right=length-1;
		 //���ö��ֲ�����Ѱ�Ҹߵ���
		 while(left<right) {
			 index=(left+right)/2;
			 if(nums[index-1]<nums[index]&&nums[index]>nums[index+1]) {
				 break;
			 }
			 if(nums[index]>nums[index+1]) {
				 right=index;
			 }else {
				 left=index;
			 }
		 }
		 return index;
	 }
	public static void main(String[] args) {
		int []nums= {1,2,3,1};
		SortAndSearch4 test=new SortAndSearch4();
		test.findPeakElement(nums);

	}

}
