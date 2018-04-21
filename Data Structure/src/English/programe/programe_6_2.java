package English.programe;

import java.util.List;

/**
 * 
 * @ClassName: programe_6_2
 * @Description: TODO(Write routines to implement two stacks using only one
 *               array. Your stack routines should not declare an overflow
 *               unless every slot in the array is used.)
 * @author yi
 * @date 2018年4月17日
 *
 */
public class programe_6_2 {
	private static final int Capacity = 100;
	private static int[] Array = new int[Capacity * 2];
	private static final int Bottom1=0;// stack1的栈底指针
	private static final int Bottom2=0;// stack2的栈底指针
	private static int Top1 = 0;// stack1的栈顶指针
	private static int Top2 = 1;// stack2的栈顶指针

	/**
	 * 
	 * @Title: IsEmpty @Description: TODO(判断两个栈是否为空) @param @param
	 * stack @param @return 参数 @return boolean 返回类型 @throws
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
	 * @Title: IsFull @Description: TODO(判断两个栈是否为满) @param @param
	 * stack @param @return 参数 @return boolean 返回类型 @throws
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
    * @Description: TODO(将一个数据压入到栈一或栈二中去)  
    * @param @param stack
    * @param @param number    参数  
    * @return void    返回类型  
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
    * @Description: TODO(从栈一或栈二中读出一个数据)  
    * @param @param stack
    * @param @return    参数  
    * @return int    返回类型  
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
    * @Description: TODO(打印栈一或栈二)  
    * @param @param stack    参数  
    * @return void    返回类型  
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
