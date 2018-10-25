import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main7 {

	public static void main(String[] args) {
		Scanner in=new Scanner(new BufferedInputStream(System.in));
		List<Integer>list=new ArrayList<Integer>();
		int mynunber=in.nextInt();
		int x=in.nextInt();
		int y=in.nextInt();
		in.close();
		int temp1;
		int temp2;
		double temp3;
		int []nums=new int[2];
		double bing=0.0;
		boolean jump=false;
		for(int i=1;i<10;i++) {
			for(int j=0;j<10;j++) {
				temp1=i*10+j;
				//System.out.println(temp1);
				temp2=j*10+i; 
				temp3=(int)Math.abs(temp1-temp2);
				if(temp3*y==temp2*x) {
					//System.out.println((double)temp3/x*1.0);
					nums[0]=temp1;
					nums[1]=temp2;
					bing=temp3/x*1.0;  
					//break;
					jump=true;
				}
			}
		}
		if(jump) {
			System.out.print(nums[0]+" ");
		for(int i=0;i<2;i++) {
			if(nums[i]<mynunber) {
				System.out.print("Gai ");
			}
			else if(nums[i]==mynunber) {
				System.out.print("Ping ");
			}else {
				System.out.print("Cong ");
			}
		}
		if(bing<mynunber) {
			System.out.print("Gai");
		}
		else if(bing==mynunber) {
			System.out.print("Ping");
		}else {
			System.out.print("Cong");
		}
		System.out.println();
		} else {
			System.out.println("No Solution");
		}
	}

}
