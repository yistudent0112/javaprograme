package com.yi.thread;

public class ArmyRunnable implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//ͨ��volatile�ؼ��ֿ��Խ�����߳��ж�ͬһ�����ķ��ʲ�����������
	volatile boolean keepRunning=true;
	@Override
	public void run() {
	    System.out.println(Thread.currentThread().getName()+"��ʼ����");
	    while(keepRunning) {
	    	for(int i=0;i<5;i++) {
	    		System.out.println(Thread.currentThread().getName()+"�����˵�"+i+"�ν���");
	    	}
	    	Thread.yield();
	    }
		System.out.println(Thread.currentThread().getName()+"��������");
	}

}
