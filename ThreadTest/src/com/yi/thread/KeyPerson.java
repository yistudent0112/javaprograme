package com.yi.thread;

public class KeyPerson extends Thread {
	public void run() {
	System.out.println(getName()+"开始战斗");

		for(int i=0;i<10;i++) {
			System.out.println(getName()+"发动了第"+i+"次进攻");
		}
	
	System.out.println(getName()+"结束战斗");
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
