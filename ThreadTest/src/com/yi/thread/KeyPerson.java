package com.yi.thread;

public class KeyPerson extends Thread {
	public void run() {
	System.out.println(getName()+"��ʼս��");

		for(int i=0;i<10;i++) {
			System.out.println(getName()+"�����˵�"+i+"�ν���");
		}
	
	System.out.println(getName()+"����ս��");
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
