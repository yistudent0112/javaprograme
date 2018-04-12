package Bacial_program;

import java.util.Scanner;

/*
 * 编写一个程序，要求用户输入24小时制的时间，然后显示12小时制的时间。
 */
public class programe_7_7 {
public static void TranseTime() {
	Scanner in =new Scanner(System.in);
	String time=in.next();
	//将读入的时间分割成小时和分钟两个变量
	String[] times=time.split(":");

    int hour=Integer.parseInt(times[0]);
	int minute=Integer.parseInt(times[1]);
	String noon="AM";
	//对小时变量进行处理，区分上午和下午的区别
	if(hour>12) {
		hour=hour-12;
		noon="PM";
	}
	System.out.println(hour+":"+minute+" "+noon);
	in.close();
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     TranseTime();
	}

}
