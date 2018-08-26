package com.yi.DynamicPrograme;
/*
 * �����������ö�̬�滮��˼�룬�ҵ���һ�����ǰһ��𰸵Ĺ�ϵ��
 * Ȼ��ͨ����ʼʱ����֪�����������Ƶ���ֱ���ó����Ĵ�
 * ��������У���Ϊ����ֻ�ܽ������º����ҵ��ƶ�
 * ����f(x,y)=f(x-1,y)+f(x,y-1)
 * ͨ�������ʽ�����ҵ���
 * ��������ֻ�����ǲ�ͬ��ʵ�ַ������ڶ���ռ�õĿռ��Сһ��
 */
public class DynamicPrograme2 {
	//����Ĵ����ռ�Ϊ��ά���飬ʵ����ֻ��Ҫ������ǰ�е���Ϣ�͹���
	public int uniquePaths(int m, int n) {
		int result = 0;
		if (m <= 0 || n <= 0) {
			return result;
		}
		int[][] paths = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				//Ϊ��һ�к͵�һ�е�Ԫ�ظ�ֵ��Ĭ�ϵ�ֵΪ1����ֻ������һ�ַ�����ƶ�(���£�������)
				//�������������������ϵ��ƶ�
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
	//ʹ��һ��һά���������浱ǰ�еĽ����ռ�õĿռ��С
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
