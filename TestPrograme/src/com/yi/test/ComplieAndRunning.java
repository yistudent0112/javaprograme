package com.yi.test;

import org.junit.Test;

/**
 * 
 * ���������״̬ ��Ϊ ����ʱ ����ʱ ����ʱ
 * 1�������ط����ڱ���ʱ
 * 2������д����������ʱ
 * 3���ͷ����ڱ���ʱ
 * 4ע����Է���������ʱҲ���Է����ڱ���ʱ(������)
 * 5�쳣 ��Ϊ����ʱ�쳣 �ͱ���ʱ�쳣(���߱���)
 * 6�̳� �����ڱ���ʱ ��Ϊ���Ǿ�̬��
 * 7���������� ����������ʱ ��Ϊ���Ƕ�̬��
 *
 */
/**
 * 
 * ���͵ļ̳й�ϵ
 *
 */
class person {
	private String name;
	private int age;

	public person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void show() {
		System.out.println("age: " + age + "name : " + name);
	}
}

class father extends person {
	public father(String name, int age, String job) {
		super(name, age);
		this.job = job;
	}

	private String job;

	public void show() {
		super.show();
		System.out.println("job : " + job);
	}
}

/**
 * 
 * ���͵Ĵ������ϵĹ�ϵ
 *
 */
class person1 {
	private String name;
	private int age;

	public person1(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void show() {
		System.out.println("age: " + age + "name : " + name);
	}
}

class father1 {
	private person1 p1;
	private String job;

	public father1(String name, int age, String job) {
		p1 = new person1(name, age);
		this.job = job;
	}

	public void show() {
		p1.show();
		System.out.println("job : " + job);
	}
}

public class ComplieAndRunning {
	@Test(timeout = 100)
	public void test() {
		System.out.println("start");
		while (true) {
			System.out.println("running");
		}
		// System.out.println("end");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComplieAndRunning test = new ComplieAndRunning();
		test.test();
	}

}
