package Basical.program.set;

/*
 * 程序每次读入一个正3位数，然后输出按位逆序的数字。
 * 注意：当输入的数字含有结尾的0时，输出不应带有前导的0。
 * 比如输入700，输出应该是7。
 */

public class programe_7_3 {
public static int transverse(int number) {
	if(number>-1) {
	int []numbers=new int[20];
	int index=0;
	//把数字中的每位分别存贮到数组中去
	while(number>0) {		
		numbers[index]=number%10;		
		number=number/10;
		index++;
	}
	int result=0;
	//把数组中的每位反向读取出来
	for(int i=0;i<index;i++) {
		result=result*10+numbers[i];
	}
	return result;
	//当遇到负数是直接返回-1
	}else {
		return -1;
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(transverse(-1));
	}

}
