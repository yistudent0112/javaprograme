package Bacial_program;

/*
 * 本题要求实现一个函数，可统计任一整数中某个位数出现的次数。
 * 例如-21252中，2出现了3次，则该函数应该返回3。
 */
public class sum_6_9 {
	//直接拿出最后一位数字进行判断
	public static int Count_Digit(int number, int n) {
		int temp = 0;
		int LastDigit = 0;
		//防止number为负数导致的问题
		while (Math.abs(number) > 0) {
			LastDigit = number % 10;
			if (LastDigit == n) {
				temp++;
			}
			number = number / 10;
		}
		//判断n的值是否正常
		if (n > 9 || n < 0) {
              temp=-1;
		}
		return temp;
	}
	//使用String来存放每一位数字
    public static int Count_Digit1(int number,int n) {
    	int temp=0;
    	String t=Integer.toString(n);
    	String numbers;
    	number=Math.abs(number);
    	numbers=number+"";	
    	for(int i=0;i<numbers.length();i++) {
    		//System.out.println(numbers.charAt(i));
    		if(String.valueOf(numbers.charAt(i)).equals(t)) {
    			temp++;
    		}
    	}
    	//判断n的值是否正常
		if (n > 9 || n < 0) {
              temp=-1;
		}
    	return temp;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Count_Digit1(123321222, 2));
	}

}
