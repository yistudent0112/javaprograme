package com.yi.Maths;

/*
 * Ѱ��������һ���Ƚϼ򵥵Ĺ��ܣ�ʵ������Ҳ��������
 * ���ǳ��ֶ�������Ҫ�������£��Ͳ���ʹ������ı������е������Ƚ������Ƿ�Ϊ0�ķ���ȥʵ����
 * ��Ϊÿ�β��ҵ���������������Ϊ��һ�β�ѯ����������������ʹ�ö�̬�滮�����ϴβ��ҵ������������б��������ų���
 * �������ܹ����ߺ���������
 */
public class Math2 {
	public int countPrimes1(int n) {
		if (n < 3) {
			return 0;
		}
		if (n == 3) {
			return 1;
		}
		int number = 2;
		for (int i = 5; i < n; i = i + 2) {
			if (isPrimes(i)) {
				number++;
			}
		}
		return number;

	}

	public int countPrimes2(int n) {
		if (n < 3) {
			return 0;
		}
		if (n == 3) {
			return 1;
		}
		int number = 2;
		for (int i = 5; i < n; i++) {
			if (isPrimes(i)) {
				number++;
			}
		}
		return number;

	}

	public boolean isPrimes(int n) {
		boolean flag = true;
		int size = (int) Math.sqrt(n) + 1;
		for (int i = 2; i < size; i++) {
			if (n % i == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public int countPrimes(int n) {
		if (n < 3) {
			return 0;
		}
		if (n == 3) {
			return 1;
		}
		int number = 2;
		boolean[] flag = new boolean[n];
		int l = 3;
		for (int j = 2; j * l < n; j++) {
			flag[j * l] = true;
		}
		for (int i = 5; i < n; i = i + 2) {
			if (flag[i] == false)
				number++;
			for (int j = 2; j * i < n; j++) {
				flag[j * i] = true;
			}
		}
		return number;
	}

	public int countPrimes3(int n) {
		if (n < 3) {
			return 0;
		}
		if (n == 3) {
			return 1;
		}
		int number = 2;
		boolean[] flag = new boolean[n];
		int l = 3;
		for (int j = 2; j * l < n; j++) {
			flag[j * l] = true;
		}
		for (int i = 5; i < n; i++) {
			if (flag[i] == false)
				number++;
			for (int j = 2; j * i < n; j++) {
				flag[j * i] = true;
			}
		}
		return number;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Math2 test = new Math2();
		Long time = System.currentTimeMillis();
//System.out.println(test.isPrimes(10));
		System.out.println("�����Ż�ǰ: ");
		test.countPrimes3(15000000);
		System.out.println(System.currentTimeMillis() - time);
		time = System.currentTimeMillis();
		System.out.println("�����Ż���");
		test.countPrimes(15000000);
		System.out.println(System.currentTimeMillis() - time);
		System.out.println("ʹ�ñ�����");
		System.out.println("�����Ż�ǰ��");
		time = System.currentTimeMillis();
		test.countPrimes2(15000000);
		System.out.println(System.currentTimeMillis() - time);
		System.out.println("�����Ż���");
		time = System.currentTimeMillis();
		test.countPrimes1(15000000);
		System.out.println(System.currentTimeMillis() - time);
	}

}
