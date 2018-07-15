package com.yi.array;

/**
 * 
 * @ClassName: Array7
 * @Description: TODO ����һ���Ǹ�������ɵķǿ����飬�ڸ����Ļ����ϼ�һ������һ���µ����顣 ���λ���ִ�����������λ��
 *               ������ÿ��Ԫ��ֻ�洢һ�����֡� ����Լ���������� 0 ֮�⣬��������������㿪ͷ��
 * @author yi
 * @date 2018��7��15��
 *
 */
public class Array7 {
	public int[] plusOne(int[] digits) {
		int index = 1;
		digits[digits.length - index] = (digits[digits.length - index] + 1) % 10;
		while (((digits[digits.length - index]) % 10) == 0) {
			index++;
			//�����һ��ᷢ��λ�������ֻ�п��ܽ����1��ͷ�����0������
			if(index>digits.length) {
				int[] res=new int[digits.length+1];
				res[0]=1;
				return res;
			}
			digits[digits.length - index] = (digits[digits.length - index] + 1) % 10;
		}
		
		return digits;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array7 test = new Array7();
		int[] digits = {  9 };
		test.plusOne(digits);
	}

}
