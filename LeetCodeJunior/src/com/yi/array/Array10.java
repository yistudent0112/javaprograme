package com.yi.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @ClassName: Array10
 * @Description: TODO 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。 数字 1-9
 *               在每一行只能出现一次。 数字 1-9 在每一列只能出现一次。 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * @author yi
 * @date 2018年7月15日
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
				//按行来判断
				if (!Row.add(board[i][j])&&(board[i][j]!='.')) {
					flag = false;
					return flag;
				}
				//按列来判断
				if (!Column.add(board[j][i])&&(board[j][i]!='.')) {
					flag = false;
					return flag;
				}
				//按小方块格来判断
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
