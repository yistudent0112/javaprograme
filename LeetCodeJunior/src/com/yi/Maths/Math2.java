package com.yi.Maths;

/*
 * 寻找素数是一个比较简单的功能，实现起来也并不复杂
 * 但是出现对性能有要求的情况下，就不能使用最蠢的遍历所有的数来比较余数是否为0的方法去实现了
 * 因为每次查找到的素数都可以作为下一次查询的条件，所以这里使用动态规划，将上次查找到的素数的所有倍数都给排除了
 * 这样就能够调高函数的性能
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
		System.out.println("性能优化前: ");
		test.countPrimes3(15000000);
		System.out.println(System.currentTimeMillis() - time);
		time = System.currentTimeMillis();
		System.out.println("性能优化后：");
		test.countPrimes(15000000);
		System.out.println(System.currentTimeMillis() - time);
		System.out.println("使用笨方法");
		System.out.println("性能优化前：");
		time = System.currentTimeMillis();
		test.countPrimes2(15000000);
		System.out.println(System.currentTimeMillis() - time);
		System.out.println("性能优化后：");
		time = System.currentTimeMillis();
		test.countPrimes1(15000000);
		System.out.println(System.currentTimeMillis() - time);
	}

}
