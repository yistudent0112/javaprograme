package com.yi.Maths;
/*
 *寻找三的幂指数，这道题不难，主要循环除以3查看余数就能得到结果
 *要注意的是1是3的0次幂也是3的幂指数，不能忘记考虑他的存在
 */
public class Math3 {
public boolean isPowerOfThree(int n) {
	if(n<3&&n!=1) {
		return false;
	}
        boolean flag=true;
        while(n!=1) {
        	if(n%3!=0) {
        		flag=false;
        		break;
        	}else {
        	n=n/3;
        	}
        }
        return flag;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
