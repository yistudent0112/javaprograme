package com.yi.test;

public class Calculator {
	//定义一个静态变量来存放结果
    private static int result;
    public void add(int n) {
    	result+=n;
    }
    public void subtract(int n) {
    	//Bug:代码应该为result-=n
    	result--;
    }
    public void multiply(int n) {
    	//Bug:没有实现代码
    }
    public void devide(int n) throws Exception {
    	if(n==0) {
    		throw new Exception("除数为0");
    	}else {
    		result=result/n;
    	}
    }
    public void square() {
    	result=result*result;
    }
    public void squareroot() {
    	//Bug死循环
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
