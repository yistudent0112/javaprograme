package com.yi.Math;

import java.util.ArrayList;
/*
 *�������ѵ�������������ѭ��С��������С��������������ѭ��С����˵��Ҫ׼ȷ���ҵ�С����ѭ������  
 *��  Ҫ ����   0.2  ��    0.11111111    ��Ҫ����       0.16666666  ��    0.3333333333
 *һ��ʼ��ֱ�ӱ���С�����֣�����������û�а취���ֺ�һ�����������������Ҫ��¼����ÿ�γ�������֮������
 *������������ظ����ʹ�����ѭ���Ŀ�ʼ   ��ô��ѭ��֮ǰ������Ӧ�ñ�д��(��ǰ��
 *����㷨�ľ��岽��������������
 *��ͨ����long���͵ĳ���    �õ��������ֵ�ֵ��ͬʱҲ�õ�����
 *���Ŵ���С������
 *Ȼ���ģ���������Ĺ��̣��Ժ����λ(����*10)ȥ���Գ���������������������󣬾ͼ���ȥ��λ
 *ͨ�����ϵ��ظ�����Ĺ��̣�ֱ������Ϊ0(���Ϊ����С��)�����������������ظ�ֹͣ(���Ϊ����ѭ��С��)
 *Ȼ��ȥ��ֱ���Ǹ��ظ���������һ�γ��ֵĵط���������֮ǰ�������(Ҳ���Ƿ�ѭ��С��)��(ǰ�����
 *Ȼ����(���ѭ�����ֵ�С��)
 *�����ݽ�������Ŵ�ӡ���
 *
 *������Ҫע�����Int���͵�������⣬��Ϊ���ڸ��ָ����Ŀ��ܵ������
 *�������еĴ���Ҫʹ��long������������һ������    
 *�������    -Integer.MIN_VALUE   /   -1   ��ʱ��ֵΪ     Integer.MAX_VALUE  +1   ���������
 */
public class Math7 {
	public String fractionToDecimal(int numerator, int denominator) {
		//�жϳ����ͱ�����Ϊ0�����
		  if(numerator==0){
	          return "0";
	      }
	      if(denominator==0){
	          return "";
	      }
		StringBuffer result = new StringBuffer();
		boolean flag1 = true;
		boolean flag2 = true;
		boolean loop = false;
		if (numerator < 0) {
			flag1 = false;
		}
		if (denominator < 0) {
			flag2 = false;
		}
		//�ѳ��������������������֣�������ת��long����
		long absNumerator = Math.abs((long)numerator);
		long absDenominator = Math.abs((long)denominator);
		//�����������ֵĽ��
		long res = absNumerator / absDenominator;
		long remainder = absNumerator % absDenominator;
		//���Ϊ����ʱ������-��
		if ((flag1 && !flag2) || (!flag1 && flag2)) {
			result.append("-");
		}
		
		if (remainder == 0) {
			result.append(res);
		} else {
			result.append(res);
			//��С�����ֵĴ���
			result.append(".");
			StringBuffer sb = new StringBuffer();
			//�������������
			ArrayList<Long> list = new ArrayList<Long>();
			while (remainder > 0) {
				//����������ظ����ͼ�������
				if (!list.contains(new Long(remainder))) {
					list.add(remainder);
					sb.append(remainder * 10 / absDenominator);
					remainder = remainder * 10 % absDenominator;
				} else {
					list.add(remainder);
					loop = true;
					break;
				}
			}
			if (loop) {
				//�����ѭ�����ֵ�С��
				int index = list.indexOf(list.get(list.size() - 1));

				for (int i = 0; i < index; i++) {
					result.append(sb.charAt(0));
					sb.deleteCharAt(0);
				}

				result.append("(");
				result.append(sb);
				result.append(")");
			} else {
				result.append(sb);
			}
		}
		return result.toString();
	}

	// public String fractionToDecimal(int numerator, int denominator) {
	// String result="";
	// if(numerator==0) {
	// return "0";
	// }
	// if(denominator==0) {
	// return result;
	// }
	// long absNumerator=Math.abs(numerator);
	// long absDenominator=Math.abs(denominator);
	// int res=(int) (absNumerator/absDenominator);
	// int remainder=(int)(absNumerator%absDenominator);
	// while(remainder>0&&) {
	//
	// }
	// if((numerator>0&&denominator>0)||(numerator<0&&denominator<0)) {
	// return result;
	// }else {
	// return "-"+result;
	// }
	// }
	public static void main(String[] args) {
		Math7 test = new Math7();
		test.fractionToDecimal(-2147483648, 1);
	}
}
