package English.programe;

/**
 * 
 * @ClassName: programe_6_8_priority_queue2
 * @Description: TODO(�����������ʵ�ֵ����ȶ���)
 * @author yi
 * @date 2018��5��15��
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
    * @Description: TODO(��������ȡ��һ��Ԫ��)  
    * @param @return    ����  
    * @return int    ��������  
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
    * @Description: TODO(�������ж���һ��Ԫ��)  
    * @param @param number    ����  
    * @return void    ��������  
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
    * @Description: TODO(��number���뵽index������λ���ϣ�����index��֮���Ԫ������Ųһ��)  
    * @param @param index
    * @param @param number    ����  
    * @return void    ��������  
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
    * @Description: TODO(���ֲ���key�Ĳ���λ��)  
    * @param @param list
    * @param @param key
    * @param @return    ����  
    * @return int    ��������  
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
