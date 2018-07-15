package com.yi.array;
/**
 * 
    * @ClassName: Array3  
    * @Description: TODO
    * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
    * @author yi  
    * @date 2018年7月14日  
    *
 */
public class Array3 {
    public void rotate(int[] nums, int k) {
        int temp=0;
    	for(int i=0;i<k;i++) {
    		temp=nums[nums.length-1];
           for(int j=nums.length-1;j>0;j--) {
        	   nums[j]=nums[j-1];
           }
           nums[0]=temp;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Array3 test=new Array3();
int []nums= {1,2,3,4,5,6};
test.rotate(nums, 3);
	}

}
