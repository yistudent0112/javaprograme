package com.yi.Maths;
/*
 *Ѱ��������ָ��������ⲻ�ѣ���Ҫѭ������3�鿴�������ܵõ����
 *Ҫע�����1��3��0����Ҳ��3����ָ�����������ǿ������Ĵ���
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
