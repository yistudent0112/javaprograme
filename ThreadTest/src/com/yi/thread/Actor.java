package com.yi.thread;
/*
 * 新建一个线程有两种方式，一种是继承Thread类，另一种是实现Runnable接口
 * 两种方式中都需要实现run()函数
 * 这个函数的功能是定义线程开始之后要执行的事情
 * 线程的启动方式是start()
 */
//通过继承Thread类来声明一个线程类
public class Actor extends Thread {

	@Override
	public void run() {
		System.out.println(getName() + "是一个演员！");
		int count = 0;
		boolean keepRunning = true;
		while (keepRunning) {
			System.out.println(getName() + "登台演出" + (++count));
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
		System.out.println(getName() + "结束演出！");
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
//通过实现Runnable接口来声明一个线程类
class Actress implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "是一个演员！");
		int count = 0;
		boolean keepRunning = true;
		while (keepRunning) {
			System.out.println(Thread.currentThread().getName() + "登台演出" + (++count));
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
		System.out.println(Thread.currentThread().getName() + "结束演出！");
	}
}
