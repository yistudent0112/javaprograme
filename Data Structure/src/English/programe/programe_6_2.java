package English.programe;

import java.util.List;

/**
 * 
 * @ClassName: programe_6_2
 * @Description: TODO(Write routines to implement two stacks using only one
 *               array. Your stack routines should not declare an overflow
 *               unless every slot in the array is used.)
 * @author yi
 * @date 2018��4��17��
 *
 */
public class programe_6_2 {
	private static final int Capacity = 100;
	private static int[] Array = new int[Capacity * 2];
	private static final int Bottom1=0;// stack1��ջ��ָ��
	private static final int Bottom2=0;// stack2��ջ��ָ��
	private static int Top1 = 0;// stack1��ջ��ָ��
	private static int Top2 = 1;// stack2��ջ��ָ��

	/**
	 * 
	 * @Title: IsEmpty @Description: TODO(�ж�����ջ�Ƿ�Ϊ��) @param @param
	 * stack @param @return ���� @return boolean �������� @throws
	 */
	public static boolean IsEmpty(int stack) {
		boolean flag = false;
		if (stack == 1) {
			if (Top1 == Bottom1) {
				flag = true;
			}
		} else if (stack == Bottom2) {
			if (Top2 == 1) {
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * 
	 * @Title: IsFull @Description: TODO(�ж�����ջ�Ƿ�Ϊ��) @param @param
	 * stack @param @return ���� @return boolean �������� @throws
	 */
	public static boolean IsFull(int stack) {
		boolean flag = false;
		if (stack == 1) {
			if (Top1 == (Capacity * 2 - 2)) {
				flag = true;
			}
		} else if (stack == (Capacity * 2 - 1)) {
			if (Top2 == 1) {
				flag = true;
			}
		}
		return flag;
	}

/**
 * 
    * @Title: Push  
    * @Description: TODO(��һ������ѹ�뵽ջһ��ջ����ȥ)  
    * @param @param stack
    * @param @param number    ����  
    * @return void    ��������  
    * @throws
 */
	public static void Push(int stack, int number) {
		if (IsFull(stack)) {
			System.out.println("the stack is full");
		}
		if (stack < 1 || stack > 2) {
			System.out.println("there is only two stack,you input is invalid.");
		} else {
			if (stack == 1) {
				Top1 += 2;
				Array[Top1] = number;
			} else if (stack == 2) {
				Top2 += 2;
				Array[Top2] = number;
			}
		}
	}
/**
 * 
    * @Title: Pop  
    * @Description: TODO(��ջһ��ջ���ж���һ������)  
    * @param @param stack
    * @param @return    ����  
    * @return int    ��������  
    * @throws
 */
	public static int Pop(int stack) {
		int temp = -1;
		if (IsEmpty(stack)) {
			System.out.println("the stack is empty.");
		}
		if (stack < 1 || stack > 2) {
			System.out.println("there is only two stack,you input is invalid.");
		} else {
			if (stack == 1) {
				temp = Array[Top1];
				Top1 -= 2;
			} else if (stack == 2) {
				temp = Array[Top2];
				Top2 -= 2;
			}
		}
		return temp;
	}
/**
 * 
    * @Title: Print  
    * @Description: TODO(��ӡջһ��ջ��)  
    * @param @param stack    ����  
    * @return void    ��������  
    * @throws
 */
	public static void Print(int stack) {
		if (stack < 1 || stack > 2) {
			System.out.println("there is only two stack,you input is invalid.");
		} else {
			if (stack == 1) {
				for (int i = Top1; i > 0; i = i - 2) {
					System.out.print(Array[i] + " ");
				}
			} else if (stack == 2) {
				for (int i = Top2; i > 1; i = i - 2) {
					System.out.print(Array[i] + " ");
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Push(1, 1);
		Push(1, 2);
		Pop(1);
		Push(1, 3);
		Push(2, 11);
		Push(2, 12);
		Push(2, 13);
		Push(2, 14);
		Pop(2);
		Print(1);
		Print(2);
		Pop(1);
	}

}
