package Basical.program.set;
/*
 * 本题要求实现一个函数，计算阶数为n，系数为a[0] ... 
 * a[n]的多项式f(x)=∑i=0n(a[i]×xi) 在x点的值。
 */
public class sum_6_2 {
public double f(int n,double []a,double x) {
	double number=0.0;
	if(n>a.length) {
		number=-1;
	}else {
		for(int temp=a.length-1;temp>=0;temp--) {
			number=a[temp]*Math.pow(x, temp)+number;
			//System.out.println(number);
		}
	}
	return number;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      sum_6_2 a=new sum_6_2();
      double []b={1,1,1,1,1,1,1,1,1,1};
      double x=2;
      int n=10;
      System.out.println(a.f(n,b,x));
	}

}
