package com.yi.thread;
/*
 * �½�һ���߳������ַ�ʽ��һ���Ǽ̳�Thread�࣬��һ����ʵ��Runnable�ӿ�
 * ���ַ�ʽ�ж���Ҫʵ��run()����
 * ��������Ĺ����Ƕ����߳̿�ʼ֮��Ҫִ�е�����
 * �̵߳�������ʽ��start()
 */
//ͨ���̳�Thread��������һ���߳���
public class Actor extends Thread {

	@Override
	public void run() {
		System.out.println(getName() + "��һ����Ա��");
		int count = 0;
		boolean keepRunning = true;
		while (keepRunning) {
			System.out.println(getName() + "��̨�ݳ�" + (++count));
			try {
				if (count % 10 == 0) {
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (count == 100) {
				keepRunning = false;
			}
		}
		System.out.println(getName() + "�����ݳ���");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread actor = new Actor();
		actor.setName("Mr Thread");
		actor.start();
		Thread actress = new Thread(new Actress(), "Mrs Runnable");
		actress.start();
	}

}
//ͨ��ʵ��Runnable�ӿ�������һ���߳���
class Actress implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "��һ����Ա��");
		int count = 0;
		boolean keepRunning = true;
		while (keepRunning) {
			System.out.println(Thread.currentThread().getName() + "��̨�ݳ�" + (++count));
			try {
				if (count % 10 == 0) {
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (count == 100) {
				keepRunning = false;
			}
		}
		System.out.println(Thread.currentThread().getName() + "�����ݳ���");
	}
}
