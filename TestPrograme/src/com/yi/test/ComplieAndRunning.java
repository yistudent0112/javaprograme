package com.yi.test;

import org.junit.Test;

/**
 * 
 * 代码的运行状态 分为 编译时 运行时 构建时
 * 1方法重载发生在编译时
 * 2方法重写发生在运行时
 * 3泛型发生在编译时
 * 4注解可以发生在运行时也可以发生在编译时(即反射)
 * 5异常 分为运行时异常 和编译时异常(红线报错)
 * 6继承 发生在编译时 因为他是静态的
 * 7代理或者组合 发生在运行时 因为他是动态的
 *
 */
/**
 * 
 * 典型的继承关系
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
 * 典型的代理和组合的关系
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
