package com.yi.test;

public class Calculator {
	//����һ����̬��������Ž��
    private static int result;
    public void add(int n) {
    	result+=n;
    }
    public void subtract(int n) {
    	//Bug:����Ӧ��Ϊresult-=n
    	result--;
    }
    public void multiply(int n) {
    	//Bug:û��ʵ�ִ���
    }
    public void devide(int n) throws Exception {
    	if(n==0) {
    		throw new Exception("����Ϊ0");
    	}else {
    		result=result/n;
    	}
    }
    public void square() {
    	result=result*result;
    }
    public void squareroot() {
    	//Bug��ѭ��
    	for(;;);
    }
    public void clear() {
    	result=0;
    }
    public int getResult() {
    	return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
