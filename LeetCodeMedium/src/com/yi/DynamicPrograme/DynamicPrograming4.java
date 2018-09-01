package com.yi.DynamicPrograme;




/*
 * �����Ľ���˼·��û����⣬���п��˾Ͳ���������˼·
 * �����ǿ����������̬�滮��ԭ������������֮ǰ�Ŀ�
 * �������ѵ����ڶԵ�j��������ж�ʱ��ʵ����Ҫ���ǵ��� 1��1~2 ,1~3 �� 1~j������������
 * �����ǵ�nums[j]�����Ԫ�صĴ�С������ܷ��֮ǰ�������ɵ�������
 * ��Ȼ��һ��Ľ⻹��������֮ǰ�Ľ⣬�����Ǽ򵥵�ֻ������ǰһ��Ľ��ˣ�����Ҫ�õ�ǰ�����еĽ�ȥѰ�Ҵ�
 * 
 * ��  ������      1    4    7    6     2      3      8
 * ������Ľ�Ϊ1    2    3    
 * ����Ҫ��3λ��(6)�Ľ�  
 * ����ȥ��0λ��(1)ȥ���Ƚ�            1<6  ����6��ֵ����Ϊf(1)+1   Ϊ2
 * Ȼ���1λ��(Ҳ����4)ȥ���Ƚ�     4<6  ����6��ֵ�ȸ���Ϊf(4)+1  Ϊ3
 * ����ٺ�2λ��(7)ȥ���Ƚ�            7>6  ���Ա���ԭ����ֵΪ3     ���6λ�õĽ�Ϊ3
 * 
 * �������ֵ����Ϊ      1     4     7     6      2     3     8
 *               1     2     3     3
 * ͨ�������ķ���ȥ���������ҵ����еĽ���ܹ��õ�ÿ��λ���ϵ������������Ϣ��
 */
public class DynamicPrograming4 {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int length = nums.length;
	    int result=0;
	    int []longest=new int[length];
	    //�Ƚ����е�������������Ϣ��ʼ��Ϊ1����ֻ�������Լ������
	    for(int i=0;i<length;i++) {
	    	longest[i]=1;
	    }
	    for(int i=1;i<length;i++) {
	    	for(int j=0;j<i;j++) {
	    		//���жϣ������ǰԪ�ش���֮ǰ�ĵ㣬�����������������Ϣ��û�б����¹����������������
	    		if(nums[i]>nums[j]&&longest[i]<(longest[j]+1)) {
	    			longest[i]=longest[j]+1;
	    		}
	    	}
	    }
	    //�������еĽ�������ҵ����е����ֵ
	    for(int temp:longest) {
	    	if(result<temp) {
	    		result=temp;
	    	}
	    }
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 4, 7, 6, 2, 3, 8 };
		DynamicPrograming4 test = new DynamicPrograming4();
		test.lengthOfLIS(nums);
	}

}
