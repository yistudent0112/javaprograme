package Basical.program.set;

import java.util.Scanner;

/*
 * �������Ա�ʾΪ����/��ĸ����ʽ��
 * ��дһ������Ҫ���û�����һ��������Ȼ����Լ��Ϊ����ʽ��
 * ����ʽ��ָ���Ӻͷ�ĸ�����п���Լ�ֵĳɷ��ˡ�
 * ��6/12���Ա�Լ��Ϊ1/2��
 * �����Ӵ��ڷ�ĸʱ������Ҫ����Ϊ�����ַ�������ʽ����11/8����11/8��
 * �������ӷ�ĸ���ʱ����Ȼ����Ϊ1/1�ķ�����ʽ��
 */
public class programe_7_24 {
	// �������
	private static int numerator;
	// �����ĸ
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
				//�ҵ����Ӻͷ�ĸ��ͬ�Ĺ�����������������
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