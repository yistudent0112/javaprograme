package com.yi.Recall;

public class Recall5 {
	/*
	 *因为这道题是要在二维字典中寻找出一条路径包含所有的字母，所以要用到回溯
	 *和之前那道寻找岛屿数量的题目有比较像的地方
	 *这道题的做法是，先找到第一个字符串在二维数组中出现的位置，然后把这个信息交给回溯函数来处理
	 *回溯函数会对应的做如下判断
	 *1.如果传入下标已经越界了，就返回false
	 *2.如果已经递归到足够的深度，即找齐了路径就返回true
	 *3.如果当前的位置已经在之前的递归中被访问过了或者不匹配寻找的信息，返回false
	 *4.如果当前位置信息满足要求，就去这个点的上下左右四个方向寻找合适路径
	 *5.如果出现一个结点的四个方向都无法走通，就应该把它的访问信息修改回false，
	 *这样才不会影响下一次回溯的结果
	 */
	  public boolean exist(char[][] board, String word) {
	      if(board==null||word==null) {
	    	  return false;
	      }
	      int row=board.length;
	      int column=board[0].length;
	      boolean [][]found=new boolean[row][column];
	      boolean have=false;
	      //寻找第一个字符在二维数组的位置
	    	  for(int j=0;j<row;j++) {
	    		  for(int k=0;k<column;k++) {
	    			  if(board[j][k]==word.charAt(0)) {
	    				 have=backTracking(found, word,0, j,k,  board);
	    				 if(have) {
	    					 break;
	    				 }
	    			  }
	    		  }
	    		  if(have) {
 					 break;
 				 }
	    	  }	    
		  return have;
	    }
	
	  public static boolean backTracking(boolean [][]found,String word,int wordIndex,int indexX,int indexY,char [][]board) {
	//如果已经递归到足够的深度，即找齐了路径就返回true
		  if(word.length()==wordIndex) {
		return true;
	}
		  //如果传入下标已经越界了，就返回false
		  if(indexX<0||indexX>=found.length) {
			return false;
		}
		if(indexY<0||indexY>=found[0].length) {
			return false;
		}
		//如果当前的位置已经在之前的递归中被访问过了或者不匹配寻找的信息，返回false
		  if(board[indexX][indexY]!=word.charAt(wordIndex)||found[indexX][indexY]) {
			  return false;
		  }
		  found[indexX][indexY]=true;
		  //如果当前位置信息满足要求，就去这个点的上下左右四个方向寻找合适路径
		  boolean temp=  backTracking(found, word, wordIndex+1,indexX-1,indexY,board)||
				  backTracking(found, word, wordIndex+1,indexX+1,indexY,board)||
		          backTracking(found, word, wordIndex+1,indexX,indexY+1,board)||
		          backTracking(found, word, wordIndex+1,indexX,indexY-1,board);
		//如果出现一个结点的四个方向都无法走通，就应该把它的访问信息修改回false
		  if(!temp) {
			  found[indexX][indexY]=false;
		  }
		  return temp;
	  }
	public static void main(String[] args) {
		Recall5 test=new Recall5();
		char[][]board= {{'c','a','a'},{'a','a','a'},{'b','c','d'}};
		test.exist(board,"aab");

	}

}
