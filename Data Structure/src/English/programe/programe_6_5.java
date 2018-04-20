package English.programe;

import java.util.Scanner;
import java.util.Stack;


/**
 * 
 * @ClassName: programe_6_5
 * @Description: TODO(Write a program to evaluate a postfix expression. You only
 *               have to handle four kinds of operators: +, -, x, and /.)
 * @author yi
 * @date 2018��4��18��
 *
 */
public class programe_6_5 {
	private static String Instruction;
	private static String[] Instructions;
	private static boolean Infinity = false;
	private static double Sum = 0;
	private static Stack<Double> temps = new Stack<Double>();

	public static void Input() {
		Scanner in = new Scanner(System.in);
		Instruction = in.nextLine();
		Instructions = Instruction.split(" ");
		in.close();
	}

	/**
	 * 
	 * @Title: IsNumber @Description: TODO(�ж��ַ����Ƿ�Ϊ����) @param @param
	 *         word @param @return ���� @return boolean �������� @throws
	 */
	public static boolean IsNumber(String word) {

		String NumberRegex = "[0-9]{1,}";
		return word.matches(NumberRegex);
	}

	/**
	 * 
	 * @Title: IsOperation @Description: TODO(�ж��ַ����Ƿ�Ϊ������) @param @param
	 *         word @param @return ���� @return boolean �������� @throws
	 */
	public static boolean IsOperation(String word) {
		String OperateRegex = "[-+/*]";
		return word.matches(OperateRegex);
	}

	/**
	 * 
	 * @Title: Calculate @Description: TODO(���ݲ��������������ֽ�������) @param @param
	 *         number1 @param @param number2 @param @param operator @param @return
	 *         ���� @return int �������� @throws
	 */
	public static double Calculate(double number1, double number2, String operator) {
		double temp = 0;
		if (operator.equals("+")) {
			temp = (double)number1 + number2;
		} else if (operator.equals("-")) {
			temp =(double) number1 - number2;
		} else if (operator.equals("*")) {
			temp = (double)number1 * number2;
		} else if (operator.equals("/")) {
			if (number2 == 0) {
				Infinity = true;
			} else {
				temp = (double)number1 / number2;
			}
		}
		return temp;
	}
/**
 * 
    * @Title: Do  
    * @Description: TODO(���պ���㷨����ÿһ���ڵ�)  
    * @param     ����  
    * @return void    ��������  
    * @throws
 */
	public static void Do() {

		while (!Infinity) {
			for (int i = 0; i < Instructions.length; i++) {
				if (IsNumber(Instructions[i])) {
					double temp = Double.valueOf(Instructions[i]);
					temps.push(temp);
				} else if (IsOperation(Instructions[i])) {
					//System.out.println(temps.size());
					if (temps.size() < 2) {
						Infinity = true;
					} else {
						double number2 = temps.pop();
						double number1 = temps.pop();
						temps.push(Calculate(number1, number2, Instructions[i]));
					}
				}
			}
			if(!Infinity) {
				Sum=temps.pop();
			}
			
			break;
			
		}
	}
/**
 * 
    * @Title: Print  
    * @Description: TODO(��ӡ���)  
    * @param     ����  
    * @return void    ��������  
    * @throws
 */
	public static void Print() {
		if(Infinity) {
			System.out.println("error!");
		}else {
			System.out.println(Sum);
		}
	}
	public static void main(String[] args) {
		Input();
		Do();
		Print();
		//System.out.println(Calculate(7, 23, "/"));
	}

}
