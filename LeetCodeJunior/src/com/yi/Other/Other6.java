package com.yi.Other;

import java.util.HashSet;
import java.util.Set;

public class Other6 {
	/**
	 * 
	 * �������ʹ����set������Ӧ��Ҫ�е����֣�Ȼ���ٶ�Ӧ��һ����ɾ�������е�����
	 * ���ʣ�µ����־���ȱʧ�����֣���Ȼ����ʵ�֣�����ʱ��Ϳռ临�Ӷȶ��ϸ�
	 */
//public int missingNumber(int[] nums) {
//        int missNumber=0;
//        int length=nums.length;
//        Set<Integer>numbers=new HashSet<Integer>(length+1);
//        for(int i=0;i<length+1;i++) {
//        	numbers.add(i);
//        }
//        for(int i=0;i<length;i++) {
//        	numbers.remove(nums[i]);
//        }
//        for(int i:numbers) {
//        	missNumber=i;
//        }
//        return missNumber;
//    }
	/**
	 * 
	 * �������ʹ��һ����������������nums����Ϣ������ֵΪ1������ǣ�
	 * ����ͨ�������±���ܹ���ɶ�Ӧ�ı������ҵ�ȱʧ���Ǹ�����
	 */
public int missingNumber(int[] nums) {
	int length=nums.length;
	int[]numbers=new int [length+1];
	for(int i=0;i<length;i++) {
		numbers[nums[i]]=1;
	}
	for(int i=0;i<length;i++) {
		if(numbers[i]==0) {
			return i;
		}
	}
	return length;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[]nums= {3,0,1};
Other6 test=new Other6();
test.missingNumber(nums);
	}

}
