package Bacial_program;

/*
 * BCD������һ���ֽ��������λʮ���Ƶ�����ÿ�ĸ����ر�ʾһλ��
 * �������һ��BCD����ʮ��������0x12�������ľ���ʮ���Ƶ�12��
 * ����С��ûѧ��BCD�������е�BCD����������������ת����ʮ��������ˡ�
 * ����BCD��0x12���������ʮ���Ƶ�18�ˣ�

���ڣ���ĳ���Ҫ������������ʮ��������Ȼ�������ȷ��ʮ��������
��ʾ������԰�18ת����0x12��Ȼ����ת����12��
 */

public class programe_7_4 {
public static String TranseDecimalToHex(int decimal) {
	String Hex=Integer.toHexString(decimal);
	return Hex;
}
public static int TranseHexToBCD(String hex) {
	int bcd=0;
	int number=0;
	for(int i=0;i<hex.length();i++) {
		//��ÿλ����ת����bcd���뷽ʽ
		//���ܴ�������ĸʱ��ת��
		number=Integer.parseInt(hex.charAt(i)+"",10);
		bcd=bcd*10+number;
	}
	return bcd;
}
public static int change(int wrong) {
	return TranseHexToBCD(TranseDecimalToHex(wrong));
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

System.out.println(change(18));

	}

}
