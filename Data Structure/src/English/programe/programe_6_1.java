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
 * @date 2018年4月16日
 *
 */
public class programe_6_1 {
	private static int Front = 0;//队首位置
	private static int Rear = 0;//队尾位置
	private static List<Integer> lists = new ArrayList<Integer>();
/**
 * 
    * @Title: Push  
    * @Description: TODO(将一个元素插入到头部)  
    * @param @param int    参数  
    * @return void    返回类型  
    * @throws
 */
	public static void Push(int in) {
		lists.add(Front, in);
		Rear++;
		
	}
/**
 * 
    * @Title: Pop  
    * @Description: TODO(从头部取出一个元素)  
    * @param @return    参数  
    * @return int    返回类型  
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
    * @Description: TODO(将一个元素插入到尾部)  
    * @param @param in    参数  
    * @return void    返回类型  
    * @throws
 */
	public static void Inject(int in) {
		lists.add(Rear, in);
		Rear++;
	}
/**
 * 
    * @Title: Eject  
    * @Description: TODO(从尾部取出一个元素)  
    * @param @return    参数  
    * @return int    返回类型  
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
    * @Description: TODO(判断deque是否存在)  
    * @param @return    参数  
    * @return boolean    返回类型  
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
