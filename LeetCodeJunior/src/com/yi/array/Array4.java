package com.yi.array;

import java.util.HashSet;
import java.util.Set;
/**
 * 
    * @ClassName: Array4  
    * @Description: TODO
    * ����һ���������飬�ж��Ƿ�����ظ�Ԫ�ء�
    * ����κ�ֵ�������г����������Σ��������� true��
    * ���������ÿ��Ԫ�ض�����ͬ���򷵻� false��
    * @author yi  
    * @date 2018��7��15��  
    *
 */
public class Array4 {
    public boolean containsDuplicate(int[] nums) {
        boolean flag=false;
        Set<Integer> KeySet=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++) {
        	if(!KeySet.add(nums[i])){
        		flag=true;
        		break;
        	}
        }
        return flag;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
