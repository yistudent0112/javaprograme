package English.programe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @ClassName: programe_6_1
 * @Description: TODO( A "deque" is a data structure consisting of a list of
 *               items, on which the following operations are possible:
 * 
 *               Push(X,D): Insert item X on the front end of deque D. Pop(D):
 *               Remove the front item from deque D and return it. Inject(X,D):
 *               Insert item X on the rear end of deque D. Eject(D): Remove the
 *               rear item from deque D and return it. Write routines to support
 *               the deque that take O(1) time per operation. )
 * @author yi
 * @date 2018��4��16��
 *
 */
public class programe_6_1 {
	private static int Front = 0;//����λ��
	private static int Rear = 0;//��βλ��
	private static List<Integer> lists = new ArrayList<Integer>();
/**
 * 
    * @Title: Push  
    * @Description: TODO(��һ��Ԫ�ز��뵽ͷ��)  
    * @param @param int    ����  
    * @return void    ��������  
    * @throws
 */
	public static void Push(int in) {
		lists.add(Front, in);
		Rear++;
		
	}
/**
 * 
    * @Title: Pop  
    * @Description: TODO(��ͷ��ȡ��һ��Ԫ��)  
    * @param @return    ����  
    * @return int    ��������  
    * @throws
 */
	public static int Pop() {
		if(DequeExits()) {
		int temp = lists.get(Front);
		lists.remove(Front);
		Rear--;
		return temp;
		}else {
			return -1;
		}
	}
/**
 * 
    * @Title: Inject  
    * @Description: TODO(��һ��Ԫ�ز��뵽β��)  
    * @param @param in    ����  
    * @return void    ��������  
    * @throws
 */
	public static void Inject(int in) {
		lists.add(Rear, in);
		Rear++;
	}
/**
 * 
    * @Title: Eject  
    * @Description: TODO(��β��ȡ��һ��Ԫ��)  
    * @param @return    ����  
    * @return int    ��������  
    * @throws
 */
	public static int Eject() {
		if(DequeExits()) {
		Rear--;
		int temp = lists.get(Rear);
		lists.remove(Rear);	
		return temp;
		}else {
			return -1;
		}
	}
/**
 * 
    * @Title: DequeExits  
    * @Description: TODO(�ж�deque�Ƿ����)  
    * @param @return    ����  
    * @return boolean    ��������  
    * @throws
 */
	public static boolean DequeExits() {
		boolean flag = false;
		if (Front < Rear) {
			flag = true;
		}
		if(!flag) {
			System.out.println("the deque is not exit");
		}
		return flag;
	}
    public static void print() {
    	for(int temp:lists) {
    		System.out.println(temp);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Pop();
        Push(in.nextInt()); 
       // print();
 
        Push(in.nextInt()); 
        Inject(in.nextInt());
        Inject(in.nextInt());
        Pop();
        Eject();
        
        print();
		in.close();
	}

}
