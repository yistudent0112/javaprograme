import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main6 {

	public static void main(String[] args) {
		Scanner in=new Scanner(new BufferedInputStream(System.in));
		int number=in.nextInt();
		int []nums=new int[number];
		for(int i=0;i<number;i++) {
			nums[i]=in.nextInt();
		}
		in.close();
		Arrays.sort(nums);
		if(number%2==0) {
			System.out.println(nums[number/2-1]);
		}else {
			System.out.println(nums[number/2]);
		}
	}

}
