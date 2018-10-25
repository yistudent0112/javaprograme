package com.imooc.ArraysAndString;

public class ArraysAndString5 {
	/*
	 * 之前对于java参数传递这一块不是特别的清楚，
	 * 就大致记得基本类型的传参和对象传参的结果会不太一样
	 * 但是具体的不同点在哪就不是特别的清楚了
	 * 
	 * 而这道题题目正好要做对象传递，而且我在其中也遇到了问题，
	 * 就顺便总结一下java函数传参的内容
	 * 1.基本类型作为参数传递时
	 * 当基本类型作为参数传递时，传递的是实参值的副本
	 * 即传的是值，在调用函数中对值进行修改并不会影响到原来的实参值
	 * 2.对象作为参数传递时
	 * 在Java中，当对象作为参数传递时，实际上传递的是一份"引用的拷贝"
	 * 即如果直接在调用函数中使用这个对象进行修改，会对实参值进行改动
	 * 如果对这个对象重新分配了内存空间后，再进行修改，则不会对实参值进行改动
	 * 例       int[]  a 作为形参传入函数中  主函数中分配的地址为100
	 *            a               调用函数中分配的地址为100
	 * 而如果此时对 a进行new 操作，就为他重新分配了一块地址，修改了它的地址为101
	 * 则之后对地址为101的更改操作就不会影响主函数中地址为100的对象了        
	 */
	/*
	 * 这道题不难，主要就是对细胞周围8个点中存活细胞数量的判断上需要注意下标越界的情况
	 * 设计一个函数专门处理对细胞生存状况更新的函数，对细胞的8个点进行扫描
	 * 从而得出这个细胞是否存活的信息。
	 * 之后就只是做遍历调用就行了
	 */
	/*
	 * 这题的提高版是需要不使用另外的内存空间的情况下，来解决问题
	 * 难点在于，更新了细胞的存活状况后，怎么保留原有的细胞存活信息
	 *解决方案是对于存储的细胞状态信息进行编码，总共有4种状态
	 *分别为状态1 死细胞转为死细胞    最后为死的情况
	 *           状态2活细胞转为活细胞     最后为活的情况
	 *           状态3活细胞转为死细胞     最后为死的情况
	 *           状态4死细胞转为活细胞     最后为活的情况
	 *  可以观察出，只要将状态信息除以2之后得到的余数就是最后细胞的存活信息
	 *  这样就能够实现在不使用额外内存空间的条件下对所有的细胞信息进行同时更新
	 *           
	 */
public void gameOfLife(int[][] board) {
        if(board==null||board.length==0||board[0].length==0) {
        	return ;
        }
        int row=board.length;
        int column=board[0].length;
        int [][]board1=new int[row][column];
        for(int i=0;i<row;i++) {
        	for(int j=0;j<column;j++) {
        		board1[i][j]=update(board, i, j, row, column);
        	}
        }
        for(int i=0;i<row;i++) {
        	for(int j=0;j<column;j++) {
        		board[i][j]=board1[i][j];
        	}
        }
    }
public int update(int [][]board,int x,int y,int row,int column) {
	int result=0;
	int lives=0;
	for(int i=x-1;i<x+2;i++) {
		if(i<0||i>row-1) {
			continue;
		}
		for(int j=y-1;j<y+2;j++) {
			if(j<0||j>column-1) {
				continue;
			}
			if(i==x&&j==y) {
				continue;
			}
			if(board[i][j]==1) {
				lives++;
			}
		}
	}
	if(board[x][y]==1&&(lives==2||lives==3)) {
		result=1;
	}else if(board[x][y]==1&&(lives<2||lives>3)) {
		result=0;
	}else if(board[x][y]==0&&lives==3) {
		result=1;
	}
	return result;
}
public void test(Integer a) {
	a++;
}
	public static void main(String[] args) {
		ArraysAndString5 test=new ArraysAndString5();
		int [][]board= {
		               {0,1,0},
		               {0,0,1},
		               {1,1,1},
		               {0,0,0}
		};
test.gameOfLife(board);
for(int i=0;i<board.length;i++) {
	for(int j=0;j<board[0].length;j++) {
		System.out.print(board[i][j]+" ");
	}
	System.out.println();
}
Integer a=1;
System.out.println(a);
test.test(a);
System.out.println(a);
	}

}