package English.programe;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import English.programe.programe_6_3_Node;

/**
 * 
 * @ClassName: programe_6_3
 * @Description: TODO(Write a function to add two polynomials. Do not destroy
 *               the input. Use a linked list implementation with a dummy head
 *               node. Note: The zero polynomial is represented by an empty list
 *               with only the dummy head node. )
 * @author yi
 * @date 2018��4��17��
 *
 */
public class programe_6_3 {

	private static Map<Integer, programe_6_3_Node> lists = new HashMap<Integer, programe_6_3_Node>();
/**
 * 
    * @Title: AddPolynomial  
    * @Description: TODO(����һ���ڵ㵽��������ʽ��map��ȥ)  
    * @param @param coefficient
    * @param @param exponent    ����  
    * @return void    ��������  
    * @throws
 */
	public static void AddPolynomial(int coefficient, int exponent) {
		Set<Integer> set = lists.keySet();
		programe_6_3_Node Node = new programe_6_3_Node(coefficient, exponent);
		for (int temp : set) {
			if (temp == exponent) {
				int Coefficient = lists.get(exponent).getCoefficient();
				Coefficient += coefficient;
				lists.get(exponent).setCoefficient(Coefficient);
				return;
			}
		}
		lists.put(exponent, Node);
	}
/**
 * 
    * @Title: Print  
    * @Description: TODO(��ӡmap�е����нڵ�)  
    * @param     ����  
    * @return void    ��������  
    * @throws
 */
	public static void Print() {
		Set<Integer> set = lists.keySet();
		for (int temp : set) {
			System.out.println(lists.get(temp));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddPolynomial(1, 2);
		AddPolynomial(0, 2);
		AddPolynomial(10, 2);
		AddPolynomial(1, 1);
		AddPolynomial(1, 2);
		AddPolynomial(1, 3);
		AddPolynomial(1, 4);
		AddPolynomial(1, 5);
		Print();
	}

}
