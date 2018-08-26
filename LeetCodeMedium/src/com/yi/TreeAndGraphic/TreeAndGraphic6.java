package com.yi.TreeAndGraphic;

public class TreeAndGraphic6 {
	/*
	 * 这道题就是巧妙的利用图的深度遍历思想来解决实际中的问题
	 * 对于岛屿的判断就是判断这个点的前后左右四个点的情况
	 * 如果他的附近都是相同的陆地，那么就把那些陆地都标志位同一个岛屿，从而不会误以为是一个新的岛屿
	 * 如果出现一个没有被标记过的大陆，那就记为一个新的岛屿
	 * 每次都遍历出一个完整岛屿的做法，就是对这个岛在做深度遍历
	 * 这是非常实际的理论在现实中的使用
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
		  //如果使用下面这种方法，会引发无限递归从而导致内存溢出
		  //原因是如果不做已经检测过的点的判断，而只是判断当前点是否未被检测过
		  //会不断的调用这个函数，而没有出口，就比如读入0,0 然后在第二个深度递归中传入 0,1 
		  //0,1这个值又会在第一个深度递归处来判断0,0点，这两个点都没有超出范围，所以会无限的互相调用下去
		  //所以要对这种情况加上一个跳出递归的判断条件
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


