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
    * @Description: TODO(�ж���������Ƿ�����)  
    * @param @return    ����  
    * @return boolean    ��������  
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
    * @Description: TODO(�ж���������Ƿ�Ϊ��)  
    * @param @return    ����  
    * @return boolean    ��������  
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
    * @Description: TODO(����������һ��Ԫ��)  
    * @param @param number    ����  
    * @return void    ��������  
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
    * @Description: TODO(�Ӷ����г�ȥһ��Ԫ��)  
    * @param @return    ����  
    * @return int    ��������  
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
    * @Description: TODO(�ϸ�������ʹ��ֵС�����Ӻ����λ�õ�ǰ���λ��ȥ)  
    * @param @param index    ����  
    * @return void    ��������  
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
    * @Description: TODO(�³�������ʹ��ֵ�������ǰ���λ�ó��������λ��ȥ)  
    * @param @param index    ����  
    * @return void    ��������  
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
    * @Description: TODO(�ȽϺ����������һ�������������ֵ���򷵻�false)  
    * @param @param index1
    * @param @param index2
    * @param @return    ����  
    * @return boolean    ��������  
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
    * @Description: TODO(�����������Դ������������л���)  
    * @param @param index1
    * @param @param index2    ����  
    * @return void    ��������  
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
