package English.programe;

public class programe_6_8_priority_queue3 {
	private static int[] arr;
	private static int Length;
	private static int Capcity;

	public programe_6_8_priority_queue3(int n) {
		/*
		 * Scanner in =new Scanner(System.in); int n=in.nextInt();
		 */
		Capcity = n;
		arr = new int[n];
	}
/**
 * 
    * @Title: IsFull  
    * @Description: TODO(判断这个队列是否已满)  
    * @param @return    参数  
    * @return boolean    返回类型  
    * @throws
 */
	public boolean IsFull() {
		boolean flag = true;
		if (Length < Capcity) {
			flag = false;
		}
		return flag;
	}
/**
 * 
    * @Title: IsEmpty  
    * @Description: TODO(判断这个队列是否为空)  
    * @param @return    参数  
    * @return boolean    返回类型  
    * @throws
 */
	public boolean IsEmpty() {
		boolean flag = true;
		if (Length > 0) {
			flag = false;
		}
		return flag;
	}
/**
 * 
    * @Title: AddElement  
    * @Description: TODO(向对列中添加一个元素)  
    * @param @param number    参数  
    * @return void    返回类型  
    * @throws
 */
	public void AddElement(int number) {
		if (!IsFull()) {
			arr[Length] = number;
			swim(Length);
			Length++;
		}
	}
/**
 * 
    * @Title: DeleteElement  
    * @Description: TODO(从队列中除去一个元素)  
    * @param @return    参数  
    * @return int    返回类型  
    * @throws
 */
	public int DeleteElement() {
		int number = -1;
		if (!IsEmpty()) {
			swap(0, --Length);
			number = arr[Length];
			arr[Length] = 0;
			sink(0);
		}
		return number;
	}
/**
 * 
    * @Title: swim  
    * @Description: TODO(上浮函数，使数值小的数从后面的位置到前面的位置去)  
    * @param @param index    参数  
    * @return void    返回类型  
    * @throws
 */
	public void swim(int index) {
		while (index > 0 && Compare(index, index / 2)) {
			swap(index, index / 2);
			index = index / 2;
		}
	}
/**
 * 
    * @Title: sink  
    * @Description: TODO(下沉函数，使数值大的数从前面的位置沉到后面的位置去)  
    * @param @param index    参数  
    * @return void    返回类型  
    * @throws
 */
	public void sink(int index) {
		while (2 * index <= Length) {
			int j = 2 * index;
			if (j < Length && !Compare(j, j + 1)) {
				j++;
			}
			if (Compare(j, index)) {
				swap(j, index);
			}
			index = j;
			if(index==0) {
				return;
			}
		}
	}
/**
 * 
    * @Title: Compare  
    * @Description: TODO(比较函数，如果第一个参数所代表的值大，则返回false)  
    * @param @param index1
    * @param @param index2
    * @param @return    参数  
    * @return boolean    返回类型  
    * @throws
 */
	public boolean Compare(int index1, int index2) {
		boolean flag = false;
		if (arr[index1] > arr[index2]) {
			flag = true;
		}
		return flag;
	}
/**
 * 
    * @Title: swap  
    * @Description: TODO(交换函数，对传进来的数进行互换)  
    * @param @param index1
    * @param @param index2    参数  
    * @return void    返回类型  
    * @throws
 */
	public void swap(int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		programe_6_8_priority_queue3 p = new programe_6_8_priority_queue3(10);
		p.AddElement(10);
	    p.AddElement(10);
	    p.AddElement(20);
		// p.AddElement(15);
		p.AddElement(30);
		p.AddElement(50);
		System.out.println(p.DeleteElement());
		System.out.println(p.DeleteElement());
		System.out.println(p.DeleteElement());
		System.out.println(p.DeleteElement());
		System.out.println(p.DeleteElement());
	}

}
