package Bacial_program;

import java.util.Scanner;

/*
 * ������A��B��C����С��״��ͬ��������һ������������������ͬ��
 * Ҫ���ҳ������һ������
 * ������һ���и���3����������˳���Ӧ��A��B��C��������
 * ��һ�������Ψһ���Ǹ���һ������ 
 */
public class programe_7_9 {
	private int a;
	private int b;
	private int c;
	public void Input() {
		Scanner in = new Scanner(System.in);
		a = in.nextInt();
		b = in.nextInt();
		c = in.nextInt();
		in.close();
	}
    public int FindDifferent() {
    	int dif=0;
    	if(a==b) {
    		dif=c;
    	}else if(a==c) {
    		dif=b;
    	}else if(b==c){
    		dif=a;
    	}else {
    		//������������ֶ�����ͬ
    		dif=-1;
    	}
    	return dif;
    }
    public int FindDif(int []a) {
    	int dif=a[0];
    	for(int i=1;i<a.length;i++) {
    		if(dif!=a[i]) {
    			if(i==1) {
    				
    			}
    			dif=a[i];
    			break;
    		}
    	}
    	return dif;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     programe_7_9 p=new programe_7_9();
     p.Input();
     System.out.println(p.FindDifferent());
	}

}
