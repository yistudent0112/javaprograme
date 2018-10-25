package com.imooc.ArraysAndString;

public class ArraysAndString5 {
	/*
	 * ֮ǰ����java����������һ�鲻���ر�������
	 * �ʹ��¼ǵû������͵Ĵ��κͶ��󴫲εĽ���᲻̫һ��
	 * ���Ǿ���Ĳ�ͬ�����ľͲ����ر�������
	 * 
	 * ���������Ŀ����Ҫ�����󴫵ݣ�������������Ҳ���������⣬
	 * ��˳���ܽ�һ��java�������ε�����
	 * 1.����������Ϊ��������ʱ
	 * ������������Ϊ��������ʱ�����ݵ���ʵ��ֵ�ĸ���
	 * ��������ֵ���ڵ��ú����ж�ֵ�����޸Ĳ�����Ӱ�쵽ԭ����ʵ��ֵ
	 * 2.������Ϊ��������ʱ
	 * ��Java�У���������Ϊ��������ʱ��ʵ���ϴ��ݵ���һ��"���õĿ���"
	 * �����ֱ���ڵ��ú�����ʹ�������������޸ģ����ʵ��ֵ���иĶ�
	 * ���������������·������ڴ�ռ���ٽ����޸ģ��򲻻��ʵ��ֵ���иĶ�
	 * ��       int[]  a ��Ϊ�βδ��뺯����  �������з���ĵ�ַΪ100
	 *            a               ���ú����з���ĵ�ַΪ100
	 * �������ʱ�� a����new ��������Ϊ�����·�����һ���ַ���޸������ĵ�ַΪ101
	 * ��֮��Ե�ַΪ101�ĸ��Ĳ����Ͳ���Ӱ���������е�ַΪ100�Ķ�����        
	 */
	/*
	 * ����ⲻ�ѣ���Ҫ���Ƕ�ϸ����Χ8�����д��ϸ���������ж�����Ҫע���±�Խ������
	 * ���һ������ר�Ŵ����ϸ������״�����µĺ�������ϸ����8�������ɨ��
	 * �Ӷ��ó����ϸ���Ƿ������Ϣ��
	 * ֮���ֻ�����������þ�����
	 */
	/*
	 * �������߰�����Ҫ��ʹ��������ڴ�ռ������£����������
	 * �ѵ����ڣ�������ϸ���Ĵ��״������ô����ԭ�е�ϸ�������Ϣ
	 *��������Ƕ��ڴ洢��ϸ��״̬��Ϣ���б��룬�ܹ���4��״̬
	 *�ֱ�Ϊ״̬1 ��ϸ��תΪ��ϸ��    ���Ϊ�������
	 *           ״̬2��ϸ��תΪ��ϸ��     ���Ϊ������
	 *           ״̬3��ϸ��תΪ��ϸ��     ���Ϊ�������
	 *           ״̬4��ϸ��תΪ��ϸ��     ���Ϊ������
	 *  ���Թ۲����ֻҪ��״̬��Ϣ����2֮��õ��������������ϸ���Ĵ����Ϣ
	 *  �������ܹ�ʵ���ڲ�ʹ�ö����ڴ�ռ�������¶����е�ϸ����Ϣ����ͬʱ����
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