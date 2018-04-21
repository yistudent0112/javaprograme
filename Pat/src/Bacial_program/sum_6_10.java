package Bacial_program;
/*
 * 本题要求实现一个打印非负整数阶乘的函数。
 * 其中n是用户传入的参数，其值不超过1000。
 * 如果n是非负整数，则该函数必须在一行中打印出n!的值，否则打印“Invalid input”。
 */
public class sum_6_10 {
public static void Print_Factorial(int n) {
	if(n<0) {
		System.out.println("Invalid input");
	}else {
		//求阶乘时，变量的初始化都应为1，而不是0
		int sum=1;
		//当n为0时，更正sum的值
		if(n==0) {
			sum=0;
		}
		for(int i=1;i<=n;i++) {
			sum=sum*i;
		}
		System.out.println("the sum is "+sum);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Print_Factorial(3);
	}

}
