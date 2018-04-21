package Bacial_program;

import java.util.Scanner;

/*
 * 一群猴子要选新猴王。
 * 新猴王的选择方法是：让N只候选猴子围成一圈，
 * 从某位置起顺序编号为1~N号。
 * 从第1号开始报数，每轮从1报到3，凡报到3的猴子即退出圈子，
 * 接着又从紧邻的下一只猴子开始同样的报数。
 * 如此不断循环，最后剩下的一只猴子就选为猴王。
 * 请问是原来第几号猴子当选猴王？
 */
public class programe_7_28 {
	private static int n;
	private static int K;
	private static int[] number;

	public static void Input() {
		Scanner in = new Scanner(System.in);
		K=in.nextInt();
		n = in.nextInt();
		number=new int[n];
		for(int i=0;i<number.length;i++) {
			//1代表存活状态，0代表死亡状态
			number[i]=1;
		}
		in.close();
	}
    public static void PickKing() {
    	int LeftCount=n;
    	int KillNumber=0;
    	int index=0;
    	while(LeftCount>1) {
    		if(number[index]==1) {
    			KillNumber++;
    			//当数到杀猴数时，杀掉当前位置上的猴子，并开始下一轮计数
    			if(KillNumber==K) {
    				
    				number[index]=0;
    				LeftCount--;
    				KillNumber=0;
    			}
    		}
    		index++;
    		if(index==number.length) {
    			index=0;
    		}
    	}
    	if(FindALive()!=-1) {
    		System.out.println(FindALive()+1+" is the  monkey king");
    	}
    }
    public static int FindALive() {
    	for(int i=0;i<number.length;i++) {
    		if(number[i]==1) {
    			
    			return i;
    		}
    	}
    	return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Input();
PickKing();
	}

}
