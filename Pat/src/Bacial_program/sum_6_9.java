package Bacial_program;

/*
 * ����Ҫ��ʵ��һ����������ͳ����һ������ĳ��λ�����ֵĴ�����
 * ����-21252�У�2������3�Σ���ú���Ӧ�÷���3��
 */
public class sum_6_9 {
	//ֱ���ó����һλ���ֽ����ж�
	public static int Count_Digit(int number, int n) {
		int temp = 0;
		int LastDigit = 0;
		//��ֹnumberΪ�������µ�����
		while (Math.abs(number) > 0) {
			LastDigit = number % 10;
			if (LastDigit == n) {
				temp++;
			}
			number = number / 10;
		}
		//�ж�n��ֵ�Ƿ�����
		if (n > 9 || n < 0) {
              temp=-1;
		}
		return temp;
	}
	//ʹ��String�����ÿһλ����
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
    	//�ж�n��ֵ�Ƿ�����
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
