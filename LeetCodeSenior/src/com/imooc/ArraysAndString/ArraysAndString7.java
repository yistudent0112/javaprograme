package com.imooc.ArraysAndString;

import java.util.HashMap;


public class ArraysAndString7 {
	/*
	 * �����ƽⷨ���������������Ȼ��Ѱ��ǰ��Ϊ�������������ָ���
	 * Ҫע�������������У������������ͬ�����������Ҫ���Ƕ��������Ĵ���
	 */
//	 public int longestConsecutive(int[] nums) {
//	        if(nums==null||nums.length==0) {
//	        	return 0;
//	        }
//	        if(nums.length==1) {
//	        	return 1;
//	        }
//	        int length=nums.length;
//	        Arrays.sort(nums);
//	        int result=1;
//	        int temp=1;
//	        for(int i=0;i<length-1;i++) {
//	            while(nums[i]==nums[i+1]) {
//	        		i++;
//	        		if(i==length-1) {
//	        			break;
//	        		}
//	        	}
//	            if(i==length-1) {
//	        			break;
//	        		}
//	        	if(nums[i]==nums[i+1]-1) {
//	        		temp++;
//	        	}else {
//	        		temp=1;
//	        	}
//	        	result=Math.max(temp, result);
//	        }
//	        return result;
//	    }
	/*
	 * �Լ�д�ĸĽ��溯�����߼��������Ⲣ���ܹ�ͨ��
	 * д���߼��Ǽ�¼ÿһ�γ����������������������������ĸ���
	 * �� ����Ϊ      -1 0 1   3 4 5 6
	 * ��ͳ�Ƶ���       1 1     1 1 1 ��Ϊ5
	 * ��ʵ����Ҫͳ�Ƶ���   3,4,5,6 �ĳ��ȣ�Ӧ��Ϊ4 
	 */
//	 public int longestConsecutive(int[] nums) {
//	        if(nums==null||nums.length==0) {
//	        	return 0;
//	        }
//	        if(nums.length==1) {
//	        	return 1;
//	        }
//	        int temp=1;
//	        int result=1;
//	        int length=nums.length;
//	      Set<Integer>set=new HashSet<>();
//	        for(int i=0;i<length;i++) {
//	        	if(set.contains(nums[i])) {
//	        		continue;
//	        	}if(set.contains(nums[i]+1)) {
//	        		temp++;
//	        		set.add(nums[i]);
//	        	}if(set.contains(nums[i]-1)) {
//	        		temp++;
//	        		set.add(nums[i]);
//	        	}
//	        	if(!set.contains(nums[i]-1)&&!set.contains(nums[i]+1)) {
//	        		temp=1;
//	        		set.add(nums[i]);
//	        	}
//	        	result=Math.max(result, temp);
//	        }
//	        return result;
//	 }
	/*
	 * java8��������map����getOrDefault(int key,int defaultValue)
	 * ���������keyֵȥmap�н��в��ң�����ҵ���Ӧ��value�ͷ���value��ֵ
	 * ���map�в����ڶ�Ӧ��key���ͷ���defaultValue
	 */
	/*
	 * �����������ѵ������㷨���ҿ���������˼·�������ܽ�һ��
	 * 1.�����ȱ������飬Ȼ����һ��map��������Ϣ��keyΪ�����г��ֵ����֣�valueΪ�����������ɵ��������ֵĳ���
	 * ��Ҫע�����ֻ���������ֵ���β���ָ���Ϊ����ֵ�����жε����ֵ�valueֵ���ܲ�����ȷ
	 * ��         1  2  3  4
	 * ֻ��֤1,4��ֵΪ4  ��2,3��ֵ������֤Ϊ4
	 * 2.����map�в���Ԫ�صĹ����У������������
	 * 2.1map�в��������Ԫ��(nums[i])�����Ǵ�������������ӵ�����(���� nums[i]-1��nums[i]+1)
	 * ����Ҫ������������ӳɵ����ִ�����βԪ�صĳ�����Ϣ����Ϊһ�����ִ�ֻ�п�������β�������µ�Ԫ��
	 * ��������ִ�����β��Ϣ���º�ֻ��Ҫ������µ�����Ҳ���뵽map��ȥ������
	 * 2.2map�в��������Ԫ�أ�Ҳ������������������ӵ�Ԫ�ء�
	 * ��ζ�ŵ�ǰԪ�����ڵ��������г��Ⱦ���1��ֻ��Ҫ��map�в������Ԫ�ؾ�����
	 * 
	 * 
	 * ��  ���������Ϊ   9  1  4  7  3  -1   0  5  8  1   6
	 * �������ģ������������ֶ���map�Ĺ��̣�ǰ��ľ��Թ���
	 * map�е����Ϊ   key��   -1  0  1    3   4   5  7      9
	 *          value��     3  2  3    3   2   3  1      1
	 *          ��һ�����������Ϊ8��
	 *          map�в�����������֣����Ǵ����������ӵ���β���֣�Ȼ���ȡ������β���ֵ�value
	 *          �õ���ֵ��Ϊ1����ʾ��δ����8ʱ��7,9��������û�ܹ�����������֣��ڲ�����8�������7,8,9����������
	 *          ������β���ֵ�map��Ϣ   7=3 9=3 ���ҽ�Ԫ��8����map��
	 *          ��һ�����������Ϊ1��
	 *          ��Ϊmap���Ѿ�����1�ˣ������в���
	 *          �����������Ϊ6��
	 *  map�е����Ϊ   key��   -1  0  1    3   4   5  7   8   9
	 *           value��     3  2  3    3   2   3  3   3   3  
	 *   map�в�����������֣����Ǵ����������ӵ���β���֣�Ȼ���ȡ������β���ֵ�value
	 *          �õ���ֵ��Ϊ3����ʾ��δ����6ʱ��5,7�������ֶ�����������֣��ֱ�Ϊ 3,4,5 ��7,8,9 
	 *          �ڲ�����6�������3,4,5,6,7,8,9����������
	 *          ������β���ֵ�map��Ϣ   3=7 9=7 ���ҽ�Ԫ��6����map��   
	 */
	 public int longestConsecutive(int[] nums) {
	        int max = 0;
	        HashMap<Integer,Integer> map = new HashMap<>();
	        for (int i:nums){
	            if(map.getOrDefault(i,0)==0){
	            	//Ϊ����Ԫ�ص���߽�
	                int left = map.getOrDefault(i-1,0);
	                //Ϊ����Ԫ�ص��ұ߽�
	                int right = map.getOrDefault(i+1,0);
	                map.put(i,left+right+1);
	                //����Ԫ����߽��ֵ
	                if(left!=0){
	                    map.put(i-left,left+right+1);
	                }
	                //����Ԫ���ұ߽��ֵ
	                if(right!=0){
	                    map.put(i+right,right+left+1);
	                }
	                max = max>(left+right+1)?max:(left+right+1);
	            }
	        }
	        return max;
	    }
	public static void main(String[] args) {
int []nums= {9,1,4,7,3,-1,0,5,8,-1,6};
ArraysAndString7 test=new ArraysAndString7();
int number=test.longestConsecutive(nums);
System.out.println(number);
	}

}
