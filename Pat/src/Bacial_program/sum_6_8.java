package Bacial_program;
/*
 * ����Ҫ��ʵ��һ������Ǹ������׳˵ļ򵥺���
 */
public class sum_6_8 {
public static int Factorial(int n) {
	int sum=0;
	if(n>0) {
		sum=1;
		for(int i=n;i>0;i--) {
			sum=sum*i;
		}
	}
	return sum;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.out.println(Factorial(6));
	}

}
