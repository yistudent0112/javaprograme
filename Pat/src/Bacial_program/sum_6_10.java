package Bacial_program;
/*
 * ����Ҫ��ʵ��һ����ӡ�Ǹ������׳˵ĺ�����
 * ����n���û�����Ĳ�������ֵ������1000��
 * ���n�ǷǸ���������ú���������һ���д�ӡ��n!��ֵ�������ӡ��Invalid input����
 */
public class sum_6_10 {
public static void Print_Factorial(int n) {
	if(n<0) {
		System.out.println("Invalid input");
	}else {
		//��׳�ʱ�������ĳ�ʼ����ӦΪ1��������0
		int sum=1;
		//��nΪ0ʱ������sum��ֵ
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
