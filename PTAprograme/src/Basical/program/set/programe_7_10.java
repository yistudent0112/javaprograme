package Basical.program.set;

import java.util.concurrent.CountDownLatch;

/*
 * 某公司员工的工资计算方法如下：一周内工作时间不超过40小时，按正常工作时间计酬；
 * 超出40小时的工作时间部分，按正常工作时间报酬的1.5倍计酬。
 * 员工按进公司时间分为新职工和老职工，进公司不少于5年的员工为老职工，
 * 5年以下的为新职工。新职工的正常工资为30元/小时，
 * 老职工的正常工资为50元/小时。
 * 请按该计酬方式计算员工的工资
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
