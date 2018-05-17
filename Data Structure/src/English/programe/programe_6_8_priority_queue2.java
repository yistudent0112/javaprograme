package English.programe;

/**
 * 
 * @ClassName: programe_6_8_priority_queue2
 * @Description: TODO(基于有序对列实现的优先对列)
 * @author yi
 * @date 2018年5月15日
 *
 */
public class programe_6_8_priority_queue2 {
	private static int[] arr;
	private static int Length;
	private static int Capcity;

	public programe_6_8_priority_queue2(int n) {
		/*
		 * Scanner in =new Scanner(System.in); int n=in.nextInt();
		 */
		Capcity = n;
		arr = new int[n];
	}

	public boolean IsFull() {
		boolean flag = true;
		if (Length < Capcity) {
			flag = false;
		}
		return flag;
	}

	public boolean IsEmpty() {
		boolean flag = true;
		if (Length > 0) {
			flag = false;
		}
		return flag;
	}
/**
 * 
    * @Title: DeleteElement  
    * @Description: TODO(从数组中取出一个元素)  
    * @param @return    参数  
    * @return int    返回类型  
    * @throws
 */
	public int DeleteElement() {
		int element = -1;
		if (!IsEmpty()) {
			element = arr[Length - 1];
			Length--;
		}
		return element;
	}
/**
 * 
    * @Title: AddElement  
    * @Description: TODO(从数组中读进一个元素)  
    * @param @param number    参数  
    * @return void    返回类型  
    * @throws
 */
	public void AddElement(int number) {
		if (IsEmpty()) {
			arr[0] = number;
			Length++;
		} else if (!IsFull()) {
			int index = BinSearch(arr, number);
			Move(index, number);
			Length++;
		}
	}
/**
 * 
    * @Title: Move  
    * @Description: TODO(把number插入到index的数组位置上，并把index即之后的元素往后挪一格)  
    * @param @param index
    * @param @param number    参数  
    * @return void    返回类型  
    * @throws
 */
	public void Move(int index, int number) {
		for (int i = index; i < Length; i++) {
			arr[i + 1] = arr[i];
		}
		arr[index] = number;
	}
/**
 * 
    * @Title: BinSearch  
    * @Description: TODO(二分查找key的插入位置)  
    * @param @param list
    * @param @param key
    * @param @return    参数  
    * @return int    返回类型  
    * @throws
 */
	public static int BinSearch(int[] list, int key) {
		int temp = Length / 2;
		int high = Length;
		int low = 0;
		if (list[0] > key && list[Length - 1] < key) {
			return -1;
		}
		boolean found = false;
		while (!found) {
			if (list[temp] < key) {
				low = temp;
				temp = (temp + high) / 2;
			} else if (list[temp] > key) {
				high = temp;
				temp = (temp + low) / 2;
			} else if (list[temp] == key) {
				found = true;
			}
			if ((high - low) < 2) {
				found = true;
				temp++;
			}
			// System.out.println(temp);
		}
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		programe_6_8_priority_queue2 p = new programe_6_8_priority_queue2(10);
		//p.AddElement(10);
		//p.AddElement(20);
		// p.AddElement(15);
		p.AddElement(30);
		p.AddElement(50);
		System.out.println(p.DeleteElement());
		System.out.println(p.DeleteElement());		
		System.out.println(p.DeleteElement());
		
	}

}
