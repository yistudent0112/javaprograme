package com.yi.String;
/**
 * 
 * ������ĸ��࣬������abstract�����Σ�������һ�������࣬�ǲ���ʵ�����ģ�
 * ����������ר�ŷ���һ���ļ���
 * ע���ļ���Ҫ���������һֱ���������person
 * ����һ���ļ�Ҳ��ͬ��
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
 * ����������࣬�̳���֮ǰ���Ǹ����࣬������ʵ���ˣ�����û��ʵ�ֵĺ���getinfo
 * ��Ҳ���Ե�����һ���ļ�
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
		System.out.println("����" + super.getName() + ";nianling" + super.getAge() + ";xuexiao" + this.getSchool());
		;
	}

}
/**
 * 
 * 
�����������Ĳ����࣬����������������������ö�������
 *
 */
public class abstractD {
	public static void main(String[] args) {
		student stu = new student("zhangsan", 5, "qingha");

		stu.getinfo();

	}
}
