package com.yi.Recall;

public class Recall5 {
	/*
	 *��Ϊ�������Ҫ�ڶ�ά�ֵ���Ѱ�ҳ�һ��·���������е���ĸ������Ҫ�õ�����
	 *��֮ǰ�ǵ�Ѱ�ҵ�����������Ŀ�бȽ���ĵط�
	 *�����������ǣ����ҵ���һ���ַ����ڶ�ά�����г��ֵ�λ�ã�Ȼ��������Ϣ�������ݺ���������
	 *���ݺ������Ӧ���������ж�
	 *1.��������±��Ѿ�Խ���ˣ��ͷ���false
	 *2.����Ѿ��ݹ鵽�㹻����ȣ���������·���ͷ���true
	 *3.�����ǰ��λ���Ѿ���֮ǰ�ĵݹ��б����ʹ��˻��߲�ƥ��Ѱ�ҵ���Ϣ������false
	 *4.�����ǰλ����Ϣ����Ҫ�󣬾�ȥ���������������ĸ�����Ѱ�Һ���·��
	 *5.�������һ�������ĸ������޷���ͨ����Ӧ�ð����ķ�����Ϣ�޸Ļ�false��
	 *�����Ų���Ӱ����һ�λ��ݵĽ��
	 */
	  public boolean exist(char[][] board, String word) {
	      if(board==null||word==null) {
	    	  return false;
	      }
	      int row=board.length;
	      int column=board[0].length;
	      boolean [][]found=new boolean[row][column];
	      boolean have=false;
	      //Ѱ�ҵ�һ���ַ��ڶ�ά�����λ��
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
	//����Ѿ��ݹ鵽�㹻����ȣ���������·���ͷ���true
		  if(word.length()==wordIndex) {
		return true;
	}
		  //��������±��Ѿ�Խ���ˣ��ͷ���false
		  if(indexX<0||indexX>=found.length) {
			return false;
		}
		if(indexY<0||indexY>=found[0].length) {
			return false;
		}
		//�����ǰ��λ���Ѿ���֮ǰ�ĵݹ��б����ʹ��˻��߲�ƥ��Ѱ�ҵ���Ϣ������false
		  if(board[indexX][indexY]!=word.charAt(wordIndex)||found[indexX][indexY]) {
			  return false;
		  }
		  found[indexX][indexY]=true;
		  //�����ǰλ����Ϣ����Ҫ�󣬾�ȥ���������������ĸ�����Ѱ�Һ���·��
		  boolean temp=  backTracking(found, word, wordIndex+1,indexX-1,indexY,board)||
				  backTracking(found, word, wordIndex+1,indexX+1,indexY,board)||
		          backTracking(found, word, wordIndex+1,indexX,indexY+1,board)||
		          backTracking(found, word, wordIndex+1,indexX,indexY-1,board);
		//�������һ�������ĸ������޷���ͨ����Ӧ�ð����ķ�����Ϣ�޸Ļ�false
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
