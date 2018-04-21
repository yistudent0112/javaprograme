package Bacial_program;

import java.util.Scanner;

/*
 * 二分法求函数根的原理为：如果连续函数f(x)在区间[a,b]的两个端点取值异号，即f(a)f(b)<0，
 * 则它在这个区间内至少存在1个根r，即f(r)=0。

二分法的步骤为：

检查区间长度，如果小于给定阈值，则停止，输出区间中点(a+b)/2；否则
如果f(a)f(b)<0，则计算中点的值f((a+b)/2)；
如果f((a+b)/2)正好为0，则(a+b)/2就是要求的根；否则
如果f((a+b)/2)与f(a)同号，则说明根在区间[(a+b)/2,b]，令a=(a+b)/2，重复循环；
如果f((a+b)/2)与f(b)同号，则说明根在区间[a,(a+b)/2]，令b=(a+b)/2，重复循环。
本题目要求编写程序，计算给定3阶多项式f(x)
​​ 在给定区间[a,b]内的根
 */
public class programe_7_18 {
private static double a3;
private static double a2;
private static double a1;
private static double a0;
private static double a;
private static double b;
private static double threshold=0.01;
public static void Input() {
	Scanner in =new Scanner(System.in);
	a3=in.nextDouble();
	a2=in.nextDouble();
	a1=in.nextDouble();
	a0=in.nextDouble();
	a=in.nextDouble();
	b=in.nextDouble();
	in.close();
}
//把值代入到函数中，获得函数值
public static double CountF(double n) {
	double sum=0.0;
	sum=a3*n*n*n+a2*n*n+a1*n+a0;
	return sum;
}
//用来求解函数解
public static double Solve() {
	double fa=CountF(a);
	double fb=CountF(b);
	//当a,b中不存在解时，返回提示信息
	if(fa*fb>0) {
		System.out.println("there is no result in this area : "+a+"~"+b);
		return -1;
	}
	//当a，b边界值就是解时，直接返回解时
	if(fa==0) {
		return a;
	}
	if(fb==0) {
		return b;
	}
	double result=(a+b)/2;
	double fn=CountF(result);
	while (Math.abs(fn)>threshold) {
		if(fa*fn>0) {
		a=(a+b)/2;
		}
		if(fb*fn>0) {
			b=(a+b)/2;
		}
		fa=CountF(a);
		fb=CountF(b);
		result=(a+b)/2;
		fn=CountF(result);
	}
	return result;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Input();
System.out.println(Solve());
	}

}
