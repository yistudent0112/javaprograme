import java.util.Scanner;
/*
 * 题目要求是自己建立一个hash，并且使用正方向上的平方探测法来解决碰撞问题
 * 要求不难，重点是要看懂题目，而且还要注重细节
 * 我就在平方探测的区间上卡了很久
 */
public class Main {
public static void main(String[] args) {
	Scanner in=new Scanner(System.in);
	int number=in.nextInt();
	int size=in.nextInt();
	int []nums=new int[number];
	for(int i=0;i<number;i++) {
		nums[i]=in.nextInt();
	}
	in.close();
	if(!isPrime(size)) {
		while(!isPrime(size)) {
			size++;
		};
	}
	boolean []use =new boolean[size];
	int temp=0;
	boolean found=false;
	for(int i=0;i<number;i++) {
		temp=nums[i]%size;
		found=false;
		if(!use[temp]) {
			System.out.print(temp+" ");
			found=true;
			use[temp]=true;
		}else {
			for(int j=1;j<number;j++) {
				if(!use[(temp+j*j)%size]) {
					System.out.print((temp+j*j)%size+" ");
					found=true;
					use[(temp+j*j)%size]=true;
					break;
				}
//				else if(!use[(temp-j*j+size)%size]) {
//					System.out.print((temp-j*j+size)%size+" ");
//					found=true;
//					use[(temp-j*j+size)%size]=true;
//					break;
//				}
			}
			if(!found) {
			System.out.print("- ");
			}
		}
	}
	
}
public static boolean isPrime(int n) {
	if(n<2) {
		return false;
	}
	if(n==2||n==3) {
		return true;
	}
	boolean flag=true;
	int length=(int)Math.sqrt(n)+1;
	for(int i=2;i<=length;i++) {
		if(n%i==0) {
			flag=false;
			break;
		}
	}
	return flag;
}
}
