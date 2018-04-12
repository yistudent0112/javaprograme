package Bacial_program;

/*
 * BCD数是用一个字节来表达两位十进制的数，每四个比特表示一位。
 * 所以如果一个BCD数的十六进制是0x12，它表达的就是十进制的12。
 * 但是小明没学过BCD，把所有的BCD数都当作二进制数转换成十进制输出了。
 * 于是BCD的0x12被输出成了十进制的18了！

现在，你的程序要读入这个错误的十进制数，然后输出正确的十进制数。
提示：你可以把18转换回0x12，然后再转换回12。
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
		//将每位数字转换成bcd编码方式
		//不能处理有字母时的转换
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
