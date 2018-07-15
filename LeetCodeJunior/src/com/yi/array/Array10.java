package com.yi.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @ClassName: Array10
 * @Description: TODO �ж�һ�� 9x9 �������Ƿ���Ч��ֻ��Ҫ�������¹�����֤�Ѿ�����������Ƿ���Ч���ɡ� ���� 1-9
 *               ��ÿһ��ֻ�ܳ���һ�Ρ� ���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ� ���� 1-9 ��ÿһ���Դ�ʵ�߷ָ��� 3x3 ����ֻ�ܳ���һ�Ρ�
 * @author yi
 * @date 2018��7��15��
 *
 */
public class Array10 {
	public boolean isValidSudoku(char[][] board) {
		boolean flag = true;

		for (int i = 0; i < 9; i++) {
			Set<Character> Row = new HashSet<Character>();
			Set<Character> Column=new HashSet<Character>();
			Set<Character> Cube=new HashSet<Character>();
			for (int j = 0; j < 9; j++) {
				//�������ж�
				if (!Row.add(board[i][j])&&(board[i][j]!='.')) {
					flag = false;
					return flag;
				}
				//�������ж�
				if (!Column.add(board[j][i])&&(board[j][i]!='.')) {
					flag = false;
					return flag;
				}
				//��С��������ж�
				int RowIndex = 3*(i/3);
				int ColumnIndex = 3*(i%3);
				if(!Cube.add(board[RowIndex+j/3][ColumnIndex+j%3])&&(board[RowIndex+j/3][ColumnIndex+j%3]!='.')) {
					flag=false;
					return flag;
				}
			}
		}

		return flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
