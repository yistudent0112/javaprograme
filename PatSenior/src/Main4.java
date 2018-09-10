import java.util.Objects;
import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int digits = in.nextInt();
//		double a = in.nextDouble();
//		double b = in.nextDouble();
//		in.close();
//		String as = trans(a, digits);
//		String bs = trans(b, digits);
//		if (Objects.equals(as, bs)) {
//			System.out.print("YES ");
//			System.out.print(as);
//		} else {
//			System.out.print("NO " + as + " " + bs);
//		}
		 double a=0.00000000000000012;
		 System.out.println(a);
	}

	public static String trans(double number, int digit) {
		StringBuffer sb = new StringBuffer();
		String word = Double.toString(number);
		int length = word.length();
	    int count=word.indexOf(".");
		sb.append("0.");
		int i;
		if (number == 0) {
for(i=0;i<digit;i++) {
	sb.append(0);
	count=0;
}
		} else {
			if (length < digit) {
				for (i = 0; i < length; i++) {
					sb.append(word.charAt(i));
				}
				for (; i < digit; i++) {
					sb.append(0);
				}
			} else {
				for (i = 0; i < digit; i++) {
					sb.append(word.charAt(i));
				}
			}
		}
		sb.append("*10^"+count);
		return sb.toString();
	}
}
