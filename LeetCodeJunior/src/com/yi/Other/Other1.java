package com.yi.Other;
/**
 * 
 * �ڸ�Long���͸�ֵ��ʱ��Ҫע��java�ڴ���ƻ������û�б����ι�����
 * ��Ĭ��Ϊint���ͣ�����Ϊ4���ֽ�
 * �� long a=2147483648 ��ʱ�ұߵ������ڶ��лᱻ����int���ʹ���
 * �ͳ�����intֵ�ķ�Χ���ᱨ��
 * long a=2147483648L ���һ��long�͸����˶���Ҫ����8���ֽڵĿռ䣬�Ͳ��ᱨ����
 * �������ֵ�Ĺ����У��ǽ���ߵ�long ���͵ı���a
 * ��ջ�е�����ָ���������ڶ��д�������������
 *������ֱ�ӵİ���ջ�еı���a����Ϣд�ɶ�Ӧ��2147483648
 */
/**
 * ������������ж��У�����ʹ��0��Ϊ�ж��������жϣ���Ϊ��������Ǳ���ΪΪ�޷�������������
 * ��java����û���޷�������һ���ͣ����Ե������������2147483647ʱ
 * ������������ø�������������������
 * 
 */
public class Other1 {
	public int hammingWeight( int n) {
//		System.out.println(n);
//		int count=0;
//        while(n!=0){//����ÿ��n��n-1���붼�ᵼ�£�n�����ұߵ�Ϊ1��Ԫ�ر��0������ܹ�Ҫѭ���Ĵ�������1�ĸ����Ρ�
//            count++;
//            n=(n-1)&n;
//        }
//        return count;
	
		int number=0;
		while(n!=0) {
			if((1&n)==1) {
				number++;
			}
			n= n>>>1;
		}
		return number;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub0x80000000
		Other1 test=new Other1();
		//System.out.println(test.hammingWeight(0x80000000));
//int a=0xffffffff;
//System.out.println(a);
//System.out.println(a+1);
//a=-2;
//System.out.println(Integer.toBinaryString(a));
		int a=0xffffffff;
		Long b=(long)a+1L;
		System.out.println(b);
		Long c=(long)a;
		System.out.println(c);
	}

}
