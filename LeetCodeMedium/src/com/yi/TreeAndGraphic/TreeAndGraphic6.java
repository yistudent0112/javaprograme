package com.yi.TreeAndGraphic;

public class TreeAndGraphic6 {
	/*
	 * �����������������ͼ����ȱ���˼�������ʵ���е�����
	 * ���ڵ�����жϾ����ж�������ǰ�������ĸ�������
	 * ������ĸ���������ͬ��½�أ���ô�Ͱ���Щ½�ض���־λͬһ�����죬�Ӷ���������Ϊ��һ���µĵ���
	 * �������һ��û�б���ǹ��Ĵ�½���Ǿͼ�Ϊһ���µĵ���
	 * ÿ�ζ�������һ��������������������Ƕ������������ȱ���
	 * ���Ƿǳ�ʵ�ʵ���������ʵ�е�ʹ��
	 */
	  public int numIslands(char[][] grid) {
	        if(grid.length==0||grid[0].length==0) {
	        	return 0;
	        }
	        int row=grid.length;
	        int column=grid[0].length;
	        boolean [][]flags=new boolean[row][column];
	        int result=0;
	        for(int i=0;i<row;i++) {
	        	for(int j=0;j<column;j++) {
	        		if(grid[i][j]=='1'&&!flags[i][j]) {
	        		findIsland(grid, flags, i, j);
	        		result++;
	        		}
	        	}
	        }
	        return result;
	    }
	  public void findIsland(char[][] grid,boolean [][]flags,int i,int j) {
		  if(i<0||i>=grid.length) {
			  return ;
		  }
		  if(j<0||j>=grid[0].length) {
			  return ;
		  }
		  if(grid[i][j]!='1'||flags[i][j]) {
			  return;
		  }
		  //���ʹ���������ַ��������������޵ݹ�Ӷ������ڴ����
		  //ԭ������������Ѿ������ĵ���жϣ���ֻ���жϵ�ǰ���Ƿ�δ������
		  //�᲻�ϵĵ��������������û�г��ڣ��ͱ������0,0 Ȼ���ڵڶ�����ȵݹ��д��� 0,1 
		  //0,1���ֵ�ֻ��ڵ�һ����ȵݹ鴦���ж�0,0�㣬�������㶼û�г�����Χ�����Ի����޵Ļ��������ȥ
		  //����Ҫ�������������һ�������ݹ���ж�����
//		  if(grid[i][j]=='1'&&!flags[i][j]) {
//		  flags[i][j]=true;
//		  }
		  flags[i][j]=true;
		  findIsland(grid, flags, i-1, j);
		  findIsland(grid, flags, i+1, j);
		  findIsland(grid, flags, i, j-1);
		  findIsland(grid, flags, i, j+1);
	  }
	public static void main(String[] args) {
		char [][]grid= {{'1','1','0','0','0'},
				        {'1','1','0','0','0'},
				        {'0','0','1','0','0'},
				        {'0','0','0','1','1'}};
		TreeAndGraphic6 test=new TreeAndGraphic6();
		int i=test.numIslands(grid);
		System.out.println(i);
		}
	}


