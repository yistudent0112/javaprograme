package com.yi.String;
/**
 * 
 * ����һ�� 32 λ�з����������������е����ֽ��з�ת��
 *
 */
public class String2 {
    public int reverse(int x) {

    	int mark=1;
    	if(x<0) {
    		mark=-1;
    		x=-x;
    	}
    	long number=0;
        int digit=x%10;
        while(x!=0) {
        	number=number*10+digit;
        	x=x/10;
        	digit=x%10;
        } 
        String length=Long.toBinaryString(number);
        if(length.length()>31) {
        	return 0;
        }
        return (int)number*mark;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String2 test=new String2();
test.reverse(1563847412);
	}

}
