package Basical.program.set;

import java.util.concurrent.CountDownLatch;

/*
 * ĳ��˾Ա���Ĺ��ʼ��㷽�����£�һ���ڹ���ʱ�䲻����40Сʱ������������ʱ��Ƴꣻ
 * ����40Сʱ�Ĺ���ʱ�䲿�֣�����������ʱ�䱨���1.5���Ƴꡣ
 * Ա��������˾ʱ���Ϊ��ְ������ְ��������˾������5���Ա��Ϊ��ְ����
 * 5�����µ�Ϊ��ְ������ְ������������Ϊ30Ԫ/Сʱ��
 * ��ְ������������Ϊ50Ԫ/Сʱ��
 * �밴�üƳ귽ʽ����Ա���Ĺ���
 */
public class programe_7_10 {
public static double CountSalary(int hours,programe_7_10_Worker p) {
	double salary=0;
	if(hours<=40) {
		salary=hours*p.getSalaryPerHour();
	}else {
		salary=(hours-40)*p.getSalaryPerHour()*1.5+40*p.getSalaryPerHour();
	}
	return salary;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      programe_7_10_Worker p1=new programe_7_10_Worker(10);
      programe_7_10_Worker p2=new programe_7_10_Worker(3);
      System.out.println(CountSalary(40, p1));
      System.out.println(CountSalary(45, p1));
      System.out.println(CountSalary(30, p2));
      System.out.println(CountSalary(50, p2));
      
	}

}
