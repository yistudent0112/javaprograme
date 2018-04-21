package Bacial_program;
/*
 * 6_11
 * 本题要求实现一个函数，求N个集合元素A[]的中位数，即序列中第⌊N/2+1⌋大的元素。
 * 其中集合元素的类型为自定义的ElementType。
 */
/*
 * 6_12
 * 本题要求实现判断给定整数奇偶性的函数。
 * 其中n是用户传入的整型参数。
 * 当n为偶数时，函数返回1；n为奇数时返回0。注意：0是偶数。
 */
public class sum_6_11_12 {
public static boolean even(int n) {
	boolean flag=false;
	if(n%2==0) {
		flag=true;
	}
	return flag;
}
public static int Median(int[] list) {
	if(even(list.length)) {
		//0表示list的长度为偶数，不存在中间项
		return 0;
	}else {
		return list[(list.length-1)/2];
	}
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      //System.out.println(even(0));
      int []list= {1,2,3,4,5,6 };
      System.out.println(Median(list));
	}

}
