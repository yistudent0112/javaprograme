package com.yi.DynamicPrograme;
/*
 * 这道题就是利用动态规划的思想，找到后一项答案与前一项答案的关系，
 * 然后通过开始时的已知条件来不断推导，直到得出最后的答案
 * 在这道题中，因为人物只能进行向下和向右的移动
 * 所以f(x,y)=f(x-1,y)+f(x,y-1)
 * 通过这个公式就能找到答案
 * 两个函数只不过是不同的实现方法，第二种占用的空间会小一点
 */
public class DynamicPrograme2 {
	//分配的存贮空间为二维数组，实际上只需要存贮当前行的信息就够了
	public int uniquePaths(int m, int n) {
		int result = 0;
		if (m <= 0 || n <= 0) {
			return result;
		}
		int[][] paths = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				//为第一行和第一列的元素赋值，默认的值为1，即只可能做一种方向的移动(往下，或往右)
				//不可能做过两个方向上的移动
				if (i == 0 || j == 0) {
					paths[i][j] = 1;
				} else {
					paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
				}
			}
		}
		result=paths[m-1][n-1];
		return result;
	}
	//使用一个一维数组来保存当前行的结果，占用的空间更小
	public int uniquePaths1(int m, int n) {
		int result = 0;
		if (m <= 0 || n <= 0) {
			return result;
		}
		int row=Math.min(m, n);
		int column=Math.max(m, n);
		int []paths=new int [column];
		for(int i=0;i<column;i++) {
			paths[i]=1;
		}
		for(int i=0;i<row;i++) {
			for(int j=1;j<column;j++) {
				paths[j]+=paths[j-1];
			}
		}
		result=paths[column-1];
		return result;
	}
	public static void main(String[] args) {
		DynamicPrograme2 test=new DynamicPrograme2();
		test.uniquePaths1(20, 13);

	}

}
