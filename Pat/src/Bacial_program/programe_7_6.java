package Bacial_program;

import java.util.Scanner;

/*
 * ����Ҫ���д����
 * ˳����븡����1���������ַ���������2��
 * �ٰ����ַ���������������1��������2��˳�������
 * ��һ���а����ַ���������������1��������2��˳�������
 * ���и���������С�����2λ��
 */

public class programe_7_6 {
	private float f1;
	private float f2;
	private int i1;
	private String s1;

	public void input() {
		Scanner in = new Scanner(System.in);
		f1 = in.nextFloat();
		i1 = in.nextInt();
		s1 = in.next();
		f2 = in.nextFloat();
		in.close();
	}

	public void format() {
		int i=1;
		float t=(float) 1.0;
		String s="yi";
		System.out.printf("%+f\n",t);//+�ű�ʾ����ĸ�ʽ�д���+ ����
		System.out.printf("%9.2f",t);//'9.2'�е�9��ʾ����ĳ��ȣ�2��ʾС������λ����
		}
	public void output() {
	
		System.out.printf("%s ",s1);
		System.out.printf("%d ",i1);
		System.out.printf("%.2f ", f1);
		System.out.printf("%.2f ", f2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		programe_7_6 p = new programe_7_6();
	/*	p.input();
		p.output();*/
	p.format();
	}

}
