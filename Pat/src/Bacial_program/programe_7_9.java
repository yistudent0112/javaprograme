package Bacial_program;

import java.util.Scanner;

/*
 * 三个球A、B、C，大小形状相同且其中有一个球与其他球重量不同。
 * 要求找出这个不一样的球。
 * 输入在一行中给出3个正整数，顺序对应球A、B、C的重量。
 * 在一行中输出唯一的那个不一样的球。 
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
    		//代表输入的数字都不相同
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
