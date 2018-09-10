import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;
/*
 * 这道题目不难，主要是在于题意的理解上比较困难
 */
public class Main2 {
private static int[]ranks=null;
	public static void main(String[] args) {
		Scanner in=new Scanner(new BufferedInputStream(System.in));
		int number=in.nextInt();
	    int group=in.nextInt();
	    int []mice=new int[number];
	    ranks=new int[number];
	    List<Integer>pre=new ArrayList<Integer>(number);
	    for(int i=0;i<number;i++) {
	    	mice[i]=in.nextInt();
	    }
	    for(int i=0;i<number;i++) {
	    	pre.add(in.nextInt());
	    }
        in.close();
int rank=(int) Math.ceil(pre.size()*1.0/group)+1;
while(rank>1) {
	pre=ranking(pre, group, rank,mice);
	if(pre.size()==1) {
		ranks[pre.get(0)]=1;
		break;
	}
	rank=(int) Math.ceil(pre.size()*1.0/group)+1;
}
for(int temp:ranks) {
	System.out.print(temp+" ");
}
		
	}
	public static List<Integer> ranking(List<Integer> pre,int group,int rank,int []mice) {
		List<Integer>result=new ArrayList<Integer>();
		List<Integer>temp=null;
		int length=pre.size();
		int j=0;
		int i;
		for(i=0;i<=length-group;i=i+group) {
			temp=new ArrayList<Integer>(group);
			for(j=0;j<group;j++) {
				temp.add(pre.get(i+j));
			}
			result.add(findBiggest(temp, mice, rank));
			
		}
		if(i<length) {
			temp=new ArrayList<Integer>();
			for(;i<length;i++) {
				temp.add(pre.get(i));
			}
			result.add(findBiggest(temp, mice, rank));
		}
        return result;
	}
	public static int findBiggest(List<Integer>list,int []mice,int rank) {
		int temp=0;
		//Map<Integer,Integer>map=new HashMap<Integer,Integer>();
		int max=Integer.MIN_VALUE;
		for(int i:list) {
			ranks[i]=rank;
			if(mice[i]>max) {
				max=mice[i];
				temp=i;
			}
			//map.put(i, mice[i]);
		}
		return temp;
	}

}
