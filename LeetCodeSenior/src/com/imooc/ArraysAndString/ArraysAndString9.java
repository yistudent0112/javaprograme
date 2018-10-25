package com.imooc.ArraysAndString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/*
 *����� 
 *�ҵ������ǽ�������ַ���ȥ���ո��������ֺͷ��ŵķ��룬
 *�õ���������ֱ���˳�������ֺ��������
 *Ȼ�����һ������������ȴ���(* /)����Ĳ�������
 *������֮�󣬰Ѷ�Ӧ������λ���£�ɾ������Ҫ�����ֺ������
 *��     ��������Ϊ   2  3   3   4
 *  ���������Ϊ   +  *   /
 *  ����ͨ��������������ĳ���Ϊ��������鳤�ȼ�һ�Ĺ�������λ �������� �� ������
 *  ��   �����������±�Ϊ1                ����StringΪ    2 + 3 * 3 / 4 
 *    ����������Ӧ���±�Ϊ1 ���������±�Ϊ2   ��Ӧ�±�Ϊ        0 0 1 1 2 2 3  
 *  �ڱ������������Ĺ����з�����*�����ȶ����������������
 *  ������������ȡ����Ӧ�Ĳ�����   �õ�������Ϊ  3 * 3 =9
 *  ��9�Ż�������λ�ã���������������ֵ   ��������Ϊ  2  3  9  4
 *                             ���������Ϊ  +  *  /
 *   ɾ������������������                    ��������Ϊ 2  9  4
 *                          ���������Ϊ+  /                            
 *   �Գ˳������������ȴ���֮�󣬾Ϳ��Լ򵥵�ִ�мӼ�������
 *   ���̺�����һ�� 
 *   ������������ٶȲ��죬��44%
 *   �õķ�����ֻ�ѼӼ��������������������飬���ڳ˳�������ֱ��ִ��
 *   �������ܹ���ʡ�ռ��� 
 */
public class ArraysAndString9 {
	public int calculate(String s) {
		s = s.replaceAll(" ", "");
		if (s != null && !Objects.equals(s, "")) {
			List<Integer> numbers = new ArrayList<Integer>();
			List<Character> operators = new ArrayList<Character>();
			int length = s.length();
			int numberStart=0;
			int numberLength=0;
			for (int i = 0; i < length; i++) {
				if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					numberLength++;
				} else {
					if(numberLength>0) {
						numbers.add(Integer.valueOf(s.substring(numberStart, numberStart+numberLength)));
					}
					operators.add(s.charAt(i));
					numberStart=i+1;
					numberLength=0;
				}
			}
			if(numberLength>0) {
				numbers.add(Integer.valueOf(s.substring(numberStart, numberStart+numberLength)));
			}
			//int numberLength = numbers.size();
			int operatorLength = operators.size();
			// int numberIndex=0;
			// int operatorIndex=0;
			int index=0;
			while(index<operators.size()) {
				if(operators.get(index)=='*') {
					numbers.set(index+1, numbers.get(index)*numbers.get(index+1));
					numbers.remove(index);
					operators.remove(index);
				}else if(operators.get(index)=='/') {
					numbers.set(index+1, numbers.get(index)/numbers.get(index+1));
					numbers.remove(index);
					operators.remove(index);
				}else {
					index++;
				}
			}
//			for (int i = 0; i < operatorLength; i++) {
//				if (operators.get(i) == '*') {
//					numbers.set(i + 1, numbers.get(i) * numbers.get(i + 1));
//					numbers.remove(i);
//					operators.remove(i);
//					i=-1;
//					operatorLength = operators.size();
//				} else if (operators.get(i) == '/') {
//					numbers.set(i + 1, numbers.get(i) / numbers.get(i + 1));
//					numbers.remove(i);
//					operators.remove(i);
//					i=-1;
//					operatorLength = operators.size();
//				}
//			}
		
			operatorLength = operators.size();
			for (int i = 0; i < operatorLength; i++) {
				if (operators.get(i) == '+') {
					numbers.set(i + 1, numbers.get(i) + numbers.get(i + 1));
				} else if (operators.get(i) == '-') {
					numbers.set(i + 1, numbers.get(i) - numbers.get(i + 1));
				}
	    	 else if(operators.get(i)=='*') {
	    		 numbers.set(i+1, numbers.get(i)*numbers.get(i+1));
	    	 }else if(operators.get(i)=='/') {
	    		 numbers.set(i+1, numbers.get(i)/numbers.get(i+1));
	    	 }
			}
			// System.out.println(s);
			return numbers.get(operatorLength);
		} else {
			return -1;
		}

	}

	public static void main(String[] args) {
		ArraysAndString9 test = new ArraysAndString9();
		int a = test.calculate("2+3/3");
		System.out.println(a);
	}

}
