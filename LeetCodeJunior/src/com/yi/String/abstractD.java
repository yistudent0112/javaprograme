package com.yi.String;
/**
 * 
 * 这是你的父类，你用了abstract来修饰，他就是一个抽象类，是不能实例化的，
 * 这个类你可以专门放在一个文件里
 * 注意文件名要和你的类名一直，这个就是person
 * 下面一个文件也是同理
 *
 */
abstract class person {
	private String name;
	private int age;

	public person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public abstract void getinfo();

}
/**
 * 
 * 这是你的子类，继承了之前的那个父类，并且是实现了，父类没有实现的函数getinfo
 * 这也可以单独放一个文件
 *
 */
class student extends person {
	private String school;

	student(String name, int age, String school) {
		super(name, age);
		this.school = school;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public void getinfo() {
		System.out.println("姓名" + super.getName() + ";nianling" + super.getAge() + ";xuexiao" + this.getSchool());
		;
	}

}
/**
 * 
 * 
这里等于是你的测试类，你现在类名就是这个，不用动就行了
 *
 */
public class abstractD {
	public static void main(String[] args) {
		student stu = new student("zhangsan", 5, "qingha");

		stu.getinfo();

	}
}
