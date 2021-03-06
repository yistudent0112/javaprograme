package Basical.program.set;

import java.util.Scanner;

/*
 * 分数可以表示为分子/分母的形式。
 * 编写一个程序，要求用户输入一个分数，然后将其约分为最简分式。
 * 最简分式是指分子和分母不具有可以约分的成分了。
 * 如6/12可以被约分为1/2。
 * 当分子大于分母时，不需要表达为整数又分数的形式，即11/8还是11/8；
 * 而当分子分母相等时，仍然表达为1/1的分数形式。
 */
public class programe_7_24 {
	// 定义分子
	private static int numerator;
	// 定义分母
	private static int denominator;

	public static void Input() {
		Scanner in = new Scanner(System.in);
		numerator = in.nextInt();
		denominator = in.nextInt();
		in.close();
	}
 public static void Calculate() {
		programe_7_24_number p1 = new programe_7_24_number(numerator);
		programe_7_24_number p2 = new programe_7_24_number(denominator);
		p1.Count();
		p2.Count();
		
		int a1[]=p1.GetNumbers();
		int a2[]=p2.GetNumbers();

		for(int i=0;i<p1.getLength();i++) {
			for(int j=0;j<p2.getLength();j++) {
				//找到分子和分母共同的公因数，并把它除掉
				if(a1[i]==a2[j]) {
					//System.out.println(a1[i]);
					p1.setNumber(p1.getNumber()/a1[i]);
					p2.setNumber(p2.getNumber()/a2[j]);
					i++;
				}
				if(a1[i]<a2[j]) {
					break;
				}
			}
		}
		System.out.println(p1.getNumber()+"/"+p2.getNumber());
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Input();
	Calculate();
	}
	

}
