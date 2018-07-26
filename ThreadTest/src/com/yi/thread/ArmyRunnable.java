package com.yi.thread;

public class ArmyRunnable implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//通过volatile关键字可以解决多线程中对同一变量的访问不会出错的问题
	volatile boolean keepRunning=true;
	@Override
	public void run() {
	    System.out.println(Thread.currentThread().getName()+"开始进攻");
	    while(keepRunning) {
	    	for(int i=0;i<5;i++) {
	    		System.out.println(Thread.currentThread().getName()+"发动了第"+i+"次进攻");
	    	}
	    	Thread.yield();
	    }
		System.out.println(Thread.currentThread().getName()+"结束进攻");
	}

}
