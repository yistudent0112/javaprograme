package com.yi.thread;

public class Stage extends Thread {
public void run() {
	ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
	ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();
	Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty, "���");
	Thread armyOfRevolt = new Thread(armyTaskOfRevolt, "ũ�������");
	armyOfRevolt.start();
	armyOfSuiDynasty.start();
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    Thread MRChen=new KeyPerson();
    MRChen.setName("��ҧ��");
	armyTaskOfRevolt.keepRunning=false;
	armyTaskOfSuiDynasty.keepRunning=false;
	try {
		armyOfRevolt.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	MRChen.start();
	try {
		Thread.sleep(50);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		MRChen.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("ս������");
}
	public static void main(String[] args) {
	new Stage().start();
	}

}
