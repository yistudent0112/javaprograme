package Bacial_program;

import java.util.Scanner;

/*
 * һȺ����Ҫѡ�º�����
 * �º�����ѡ�񷽷��ǣ���Nֻ��ѡ����Χ��һȦ��
 * ��ĳλ����˳����Ϊ1~N�š�
 * �ӵ�1�ſ�ʼ������ÿ�ִ�1����3��������3�ĺ��Ӽ��˳�Ȧ�ӣ�
 * �����ִӽ��ڵ���һֻ���ӿ�ʼͬ���ı�����
 * ��˲���ѭ�������ʣ�µ�һֻ���Ӿ�ѡΪ������
 * ������ԭ���ڼ��ź��ӵ�ѡ������
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
			//1������״̬��0��������״̬
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
    			//������ɱ����ʱ��ɱ����ǰλ���ϵĺ��ӣ�����ʼ��һ�ּ���
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
